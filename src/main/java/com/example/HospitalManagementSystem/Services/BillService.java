package com.example.HospitalManagementSystem.Services;

import com.example.HospitalManagementSystem.Repository.BillRepository;
import com.example.HospitalManagementSystem.models.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        try {
            System.out.println("Fetching all bills");
            return billRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching all bills: {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            System.out.println("Fetching bill with ID: " + id);
            Optional<Bill> bill = billRepository.findById(id);
            return bill.orElse(null);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching bill with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill) {
        try {
            System.out.println("Creating a new bill: " + bill);
            billRepository.save(bill);
            return bill;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating a bill: {}", e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id) {
        try {
            System.out.println("Deleting bill with ID: " + id);
            billRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting bill with ID: {}: {}", id, e.getMessage());
        }
    }

    public Bill updateBill(Long id, Bill updatedBill) {
        try {
            System.out.println("Updating bill with ID: " + id);
            Optional<Bill> existingBill = billRepository.findById(id);
            if (existingBill.isPresent()) {
                Bill b = existingBill.get();
                b.setPatientId(updatedBill.getPatientId());
                b.setAmount(updatedBill.getAmount());
                b.setStatus(updatedBill.getStatus());
                billRepository.save(b);
                return b;
            } else {
                logger.error("Bill with ID: {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating bill with ID: {}: {}", id, e.getMessage());
            return null;
        }
    }
}

