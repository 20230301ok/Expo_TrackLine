package apiTrackline.proyectoPTC.Repositories;

import apiTrackline.proyectoPTC.Entities.InfoEmbarqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indica que hay in repositorio de métodos

public interface InfoEmbarqueRepository extends JpaRepository<InfoEmbarqueEntity, Long> {

}
