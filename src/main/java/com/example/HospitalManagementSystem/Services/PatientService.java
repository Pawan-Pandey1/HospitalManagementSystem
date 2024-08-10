package com.example.HospitalManagementSystem.Services;

import com.example.HospitalManagementSystem.Repository.PatientRepository;
import com.example.HospitalManagementSystem.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        try {
            System.out.println("Fetching all patients");
            return patientRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching all patients: {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try {
            System.out.println("Fetching patient with ID: " + id);
            Optional<Patient> patient = patientRepository.findById(id);
            return patient.orElse(null);  // Return the patient if found, otherwise return null
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching patient with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            System.out.println("Creating a new patient: " + patient);
            patientRepository.save(patient);
            return patient;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating a patient: {}", e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            System.out.println("Deleting patient with ID: " + id);
            logger.info("Deleting the patient with Id: {}", id);
            patientRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting patient with ID: {}: {}", id, e.getMessage());
        }
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        try {
            System.out.println("Updating patient with ID: " + id);
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if (existingPatient.isPresent()) {
                Patient p = existingPatient.get();

                p.setName(updatedPatient.getName());
                p.setAge(updatedPatient.getAge());
                p.setGender(updatedPatient.getGender());
                patientRepository.save(p);
                return updatedPatient;
            } else {
                logger.error("Patient with id: {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating patient with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }
}
