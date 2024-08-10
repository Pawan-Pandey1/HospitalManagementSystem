package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.models.Bill;
import com.example.HospitalManagementSystem.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService; // Injecting the BillService to handle business logic.

    @GetMapping
    public List<Bill> getAllBills(){
        System.out.println("Fetching all bills");
        return billService.getAllBills(); // Calls the service method to get all bills.
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        System.out.println("Creating bill");
        return billService.createBill(bill); // Calls the service method to create a new bill.
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        System.out.println("Fetching the bill by ID: " + id);
        return billService.getBillById(id); // Calls the service method to get a bill by ID.
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id){
        System.out.println("Deleting the bill by ID: " + id);
        billService.deleteBill(id); // Calls the service method to delete a bill by ID.
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill bill){
        System.out.println("Updating the bill by ID: " + id);
        return billService.updateBill(id, bill); // Calls the service method to update a bill.
    }
}

