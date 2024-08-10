package com.example.HospitalManagementSystem.Services;

import com.example.HospitalManagementSystem.Repository.AppointmentRepository;
import com.example.HospitalManagementSystem.models.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        try {
            System.out.println("Fetching all appointments");
            return appointmentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching all appointments: {}", e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id) {
        try {
            System.out.println("Fetching appointment with ID: " + id);
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching appointment with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment) {
        try {
            System.out.println("Creating a new appointment: " + appointment);
            appointmentRepository.save(appointment);
            return appointment;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating an appointment: {}", e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id) {
        try {
            System.out.println("Deleting appointment with ID: " + id);
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting appointment with ID: {}: {}", id, e.getMessage());
        }
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        try {
            System.out.println("Updating appointment with ID: " + id);
            Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
            if (existingAppointment.isPresent()) {
                Appointment a = existingAppointment.get();
                a.setPatientId(updatedAppointment.getPatientId());
                a.setDoctorId(updatedAppointment.getDoctorId());
                a.setDate(updatedAppointment.getDate());
                appointmentRepository.save(a);
                return a;
            } else {
                logger.error("Appointment with ID: {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating appointment with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }
}
