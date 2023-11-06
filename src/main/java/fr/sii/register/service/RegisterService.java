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
    static private ArrayList<Register> Registers = new ArrayList<>(Arrays.asList(
    ));
    public List<Register> getRegisters()
    {    List<Register> Registers = new ArrayList<>();
        registerRepository.findAll().forEach(register ->{
            Registers.add(register);
        });
        return Registers;
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

