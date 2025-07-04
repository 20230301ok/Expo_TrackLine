package apiTrackline.proyectoPTC.Repositories;

import apiTrackline.proyectoPTC.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indica que hay in repositorio de métodos

//Heredamos todo lo de JPARepository
//Practicamente ya está hecho el CRUD hecho con esto
public interface UserRepository extends JpaRepository<UserEntity, Long>  {
}
