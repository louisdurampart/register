package fr.sii.register.repository;

import fr.sii.register.model.Manager;
import fr.sii.register.model.Register;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<Register, Integer> {}
