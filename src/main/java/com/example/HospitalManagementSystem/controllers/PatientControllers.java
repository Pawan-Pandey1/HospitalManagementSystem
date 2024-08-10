package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.Services.PatientService;
import com.example.HospitalManagementSystem.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientControllers {

    //To use the Patient service layer we need the object of service layer
    @Autowired
    //Used automatic dependency injection,Object will be automatically created
    //In controller layer we injected the dependency of service layer and in service layer we will inject the dependency of repository layer
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        System.out.println("Fetching the patients");
        return patientService.getAllPatients();
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("Creating Patient");

        return patientService.createPatient(patient);
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        System.out.println("Fetching by the ID");

        return patientService.getPatientById(id);
    }

    @DeleteMapping
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id,@RequestBody Patient patient){
       return patientService.updatePatient(id,patient);
    }
}
