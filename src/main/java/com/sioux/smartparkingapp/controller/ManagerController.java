package com.sioux.smartparkingapp.controller;

import com.sioux.smartparkingapp.models.Manager;
import com.sioux.smartparkingapp.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/save")
    public Manager save(@RequestBody Manager manager){
        return managerService.save(manager);
    }

    @GetMapping()
    public ResponseEntity<List<Manager>> getAll() {
        List<Manager> managers = managerService.getAll();

        if(!managers.isEmpty()) {
            return ResponseEntity.ok().body(managers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/")
    public ResponseEntity<List<Manager>> getFromName(@PathVariable (value="name") String name) {
        List<Manager> managers = managerService.findByName(name);

            return ResponseEntity.ok().body(managers);

    }
    @GetMapping("/email")
    public ResponseEntity<  List<Manager>> getFromEmail(@PathVariable (value="name") String email) {
        List<Manager> manager = managerService.findByEmail(email);


            return ResponseEntity.ok().body(manager);

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Manager> findById(@PathVariable (value="id") Long id){
        Manager manager =managerService.findById(id);

        if(manager != null) {
            return ResponseEntity.ok().body(manager);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @PutMapping("/update")
    public String updateAppointment(@RequestBody Manager manager){
        return managerService.update(manager);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        return managerService.delete(id);

    }



}
