package com.example.HospitalManagementSystem.Services;

import com.example.HospitalManagementSystem.Repository.DoctorRepository;
import com.example.HospitalManagementSystem.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        try {
            System.out.println("Fetching all doctors");
            return doctorRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching all doctors: {}", e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            System.out.println("Fetching doctor with ID: " + id);
            Optional<Doctor> doctor = doctorRepository.findById(id);
            return doctor.orElse(null);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching doctor with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try {
            System.out.println("Creating a new doctor: " + doctor);
            doctorRepository.save(doctor);
            return doctor;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating a doctor: {}", e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        try {
            System.out.println("Deleting doctor with ID: " + id);
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting doctor with ID: {}: {}", id, e.getMessage());
        }
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        try {
            System.out.println("Updating doctor with ID: " + id);
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if (existingDoctor.isPresent()) {
                Doctor d = existingDoctor.get();
                d.setName(updatedDoctor.getName());
                d.setSpeciality(updatedDoctor.getSpeciality());
                doctorRepository.save(d);
                return d;
            } else {
                logger.error("Doctor with ID: {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating doctor with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }
}
