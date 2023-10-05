package fr.sii.register.service;

import fr.sii.register.model.Manager;
import fr.sii.register.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
   static private ArrayList<Manager> Managers = new ArrayList<>(Arrays.asList(
            new Manager (1,"Eric Gourmel"),
            new Manager (2,"Nicolas Pettazoni"),
            new Manager (3,"Nathan Labbe"),
            new Manager (4,"Chloe Maillard")
    ));
   public List<Manager> getManagers()
   {    List<Manager> Managers = new ArrayList<>();
       managerRepository.findAll().forEach(manager ->{
           Managers.add(manager);
       });
       return Managers;
   }
    public Manager getManager(int id) {
       return managerRepository.findById(id).orElse(null);
       //return Managers.stream().filter(manager -> manager.getId() == id).findFirst().orElse(null);
    }
    public void deleteManager(int id)
    {
        managerRepository.deleteById(id);
    //   Managers.removeIf(manager -> manager.getId() ==id);
    }
    public void addManager(Manager manager) {
        managerRepository.save(manager);
       //Managers.add(manager);
    }
    public void updateManager(Manager manager, int id){

       managerRepository.save(manager);
      // Managers.forEach(Manager1 -> {
        //   if(Manager1.getId() == id){
          //     Managers.set(Managers.indexOf(Manager1), manager);
          // }
      // });
    }
}
