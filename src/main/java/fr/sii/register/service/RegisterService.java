package fr.sii.register.service;

import fr.sii.register.model.Manager;
import fr.sii.register.model.Register;
import fr.sii.register.repository.ManagerRepository;
import fr.sii.register.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    public List<Register> getRegisters() {
        // Use the custom query to get records ordered by startedAt
        List<Register> registers = registerRepository.findAllByOrderByStartedAtDesc();

        // Load associated managers (as in your original code)
        registers.forEach(register -> {
            Manager manager = register.getManager();
            if (manager != null) {
                manager.getFullname();
            }
        });

        return registers;
    }

    public Register getRegister(int id) {
        return registerRepository.findById(id).orElse(null);
    }

    public void deleteRegister(int id) {
        registerRepository.deleteById(id);
    }

    public void addRegister(Register register) {
        registerRepository.save(register);
    }

    public void updateManager(Register register, int id) {
        registerRepository.save(register);
    }
}
