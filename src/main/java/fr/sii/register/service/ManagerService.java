package fr.sii.register.service;

import fr.sii.register.model.Manager;
import fr.sii.register.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

   public List<Manager> getManagers()
   {
       return managerRepository.findAllByOrderByFullnameAsc();
   }
    public Manager getManager(int id) {
       return managerRepository.findById(id).orElse(null);
       //return Managers.stream().filter(manager -> manager.getId() == id).findFirst().orElse(null);
    }
    public List<Manager> getActiveManagers() {
        return managerRepository.findAllByIsActiveTrue();
    }
    public void deleteManager(int id)
    {
        managerRepository.deleteById(id);
    }
    public void addManager(Manager manager) {
        managerRepository.save(manager);
    }
    public void updateManager(Manager manager, int id) {
        // Vérifiez si le gestionnaire existe dans la base de données
        Manager existingManager = managerRepository.findById(id).orElse(null);

        if (existingManager != null) {
            // Mettez à jour uniquement les propriétés que vous souhaitez modifier
            existingManager.setActive(manager.getActive());

            // Enregistrez les modifications dans la base de données
            managerRepository.save(existingManager);
        }
        // Si le gestionnaire n'existe pas, vous pouvez gérer cela en conséquence (par exemple, lever une exception)
    }
}
