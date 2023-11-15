package fr.sii.register.repository;

import fr.sii.register.model.Manager;
import fr.sii.register.model.Register;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
    List<Manager> findAllByOrderByFullnameAsc();
    List<Manager> findAllByIsActiveTrue();

}
