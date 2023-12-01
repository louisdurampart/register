package fr.sii.register.controller;
import fr.sii.register.model.Manager;
import fr.sii.register.model.Register;
import fr.sii.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(method = RequestMethod.GET, value = "/Registers")
    public List<Register> getRegister() {
        return registerService.getRegisters();
    }
    @RequestMapping("/Register/{id}")
    public Register getRegister(@PathVariable int id){
        Register register = registerService.getRegister(id);
        Manager manager = register.getManager();
        return register;
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/Register/{id}")
    public void deleteRegister(@PathVariable int id) {
        registerService.deleteRegister(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/Registers")
    public void addRegister (@RequestBody Register register){
        registerService.addRegister(register);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/Register/{id}")
    public void updateRegister(@RequestBody Register register, @PathVariable int id){
        registerService.updateRegister(register,id);
    }
}
