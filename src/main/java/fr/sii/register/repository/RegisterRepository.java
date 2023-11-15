package fr.sii.register.repository;

import fr.sii.register.model.Manager;
import fr.sii.register.model.Register;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisterRepository extends CrudRepository<Register, Integer> {
    List<Register> findAllByOrderByStartedAtDesc();
}
