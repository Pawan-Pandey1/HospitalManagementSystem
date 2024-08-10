package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.models.Doctor;
import com.example.HospitalManagementSystem.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService; // Injecting the DoctorService to handle business logic.

    @GetMapping
    public List<Doctor> getAllDoctors(){
        System.out.println("Fetching all doctors");
        return doctorService.getAllDoctors(); // Calls the service method to get all doctors.
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("Creating doctor");
        return doctorService.createDoctor(doctor); // Calls the service method to create a new doctor.
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        System.out.println("Fetching the doctor by ID: " + id);
        return doctorService.getDoctorById(id); // Calls the service method to get a doctor by ID.
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        System.out.println("Deleting the doctor by ID: " + id);
        doctorService.deleteDoctor(id); // Calls the service method to delete a doctor by ID.
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
        System.out.println("Updating the doctor by ID: " + id);
        return doctorService.updateDoctor(id, doctor); // Calls the service method to update a doctor.
    }
}

