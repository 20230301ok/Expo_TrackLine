package apiTrackline.proyectoPTC.Services;

import apiTrackline.proyectoPTC.Entities.TransportistaEntity;
import apiTrackline.proyectoPTC.Entities.UsuarioEntity;
import apiTrackline.proyectoPTC.Models.DTO.DTOTransportista;
import apiTrackline.proyectoPTC.Repositories.TransportistaRepository;
import apiTrackline.proyectoPTC.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransportistaService {
    @Autowired
    private TransportistaRepository repo;

    @Autowired
    private UsuarioRepository userRepo;

    // Obtener todos los transportistas y los convierte a DTO
    public List<DTOTransportista> getData() {
        List<TransportistaEntity> lista = repo.findAll();
        return lista.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    //Convierte Entity a DTO
    private DTOTransportista convertirADTO(TransportistaEntity t) {
        DTOTransportista dto = new DTOTransportista();
        dto.setNombre(t.getNombre());
        dto.setApellido(t.getApellido());
        dto.setTelefono(t.getTelefono());
        dto.setCorreo(t.getCorreo());
        dto.setNit(t.getNit());
        dto.setIdUsuario(t.getUsuario());
        return dto;
    }

    //Post
    public String post(DTOTransportista dto) {
        try {
            TransportistaEntity t = new TransportistaEntity();
            t.setNombre(dto.getNombre());
            t.setApellido(dto.getApellido());
            t.setTelefono(dto.getTelefono());
            t.setCorreo(dto.getCorreo());
            t.setNit(dto.getNit());

            Optional<UsuarioEntity> usuario = userRepo.findById(t.getIdTransportista());
            if (usuario.isPresent()) {
                t.setUsuario(usuario.get());
                repo.save(t);
                return "Transportista creado correctamente";
            } else {
                return "Error: ID de usuario no encontrado";
            }
        } catch (Exception e) {
            return "Error al crear el transportista: " + e.getMessage();
        }
    }

    // Put
    public String update(Long id, DTOTransportista dto) {
        Optional<TransportistaEntity> optional = repo.findById(id);
        if (optional.isPresent()) {
            TransportistaEntity t = optional.get();
            t.setNombre(dto.getNombre());
            t.setApellido(dto.getApellido());
            t.setTelefono(dto.getTelefono());
            t.setCorreo(dto.getCorreo());
            t.setNit(dto.getNit());

            repo.save(t);
            return "Información del embarque actualizada correctamente";
        } else {
            return "Error: ";
        }
    }

    //Patch
    public String patch(Long id, DTOTransportista dto) {
        Optional<TransportistaEntity> optional = repo.findById(id);
        if (optional.isPresent()) {
            TransportistaEntity t = optional.get();

            if (dto.getNombre() != null) t.setNombre(dto.getNombre());
            if (dto.getApellido() != null) t.setApellido(dto.getApellido());
            if (dto.getTelefono() != null) t.setTelefono(dto.getTelefono());
            if (dto.getCorreo() != null) t.setCorreo(dto.getCorreo());
            if (dto.getNit() != null) t.setNit(dto.getNit());
            if (dto.getIdUsuario() != null) {
                Optional<UsuarioEntity> usuario = userRepo.findById(dto.getIdUsuario().getIdUsuario());
                usuario.ifPresent(t::setUsuario);
            }

            repo.save(t);
            return "Transportista actualizado parcialmente.";
        }
        return "Transportista no encontrado.";
    }

    //ELiminar
    public String delete(Long id) {
        Optional<TransportistaEntity> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Transportista eliminado correctamente";
        } else {
            return "Transportista no encontrado";
        }
    }
}