package com.sioux.smartparkingapp.services;

import com.sioux.smartparkingapp.Repo.ManagerRepository;
import com.sioux.smartparkingapp.models.Manager;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerService {

    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager save(Manager manager){
        return managerRepository.save(manager);
    }

    public List<Manager> getAll(){
        return managerRepository.findAll();
    }

    public List<Manager> findByName(String name){
        return managerRepository.findByName(name);
    }

    public List<Manager> findByEmail(String email){
        return managerRepository.findByEmail(email);
    }

    public Manager findById(Long id){
        return managerRepository.findById(id).orElse(null);
    }

    public String delete(Long id){
        managerRepository.deleteById(id);
        return "Appointment removed";
    }

    public String update(Manager manager){
        managerRepository.save(manager);
        return "appointment updated successfully";
    }
}
