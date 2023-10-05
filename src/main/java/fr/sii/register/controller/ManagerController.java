package fr.sii.register.controller;
import fr.sii.register.model.Manager;

import fr.sii.register.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(method = RequestMethod.GET, value = "/Managers")
    public List<Manager> getManager() {

        return managerService.getManagers();
    }
    @RequestMapping("/Manager/{id}")
    public Manager getManager(@PathVariable int id){
        return managerService.getManager(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/Manager/{id}" )
    public void deleteManager(int id){
        managerService.deleteManager(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/Managers")
    public void addManager (@RequestBody Manager manager){
        managerService.addManager(manager);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/Manager/{id}")
    public void updateManager(@RequestBody Manager manager,@PathVariable int id){
        managerService.updateManager(manager,id);
    }
}
