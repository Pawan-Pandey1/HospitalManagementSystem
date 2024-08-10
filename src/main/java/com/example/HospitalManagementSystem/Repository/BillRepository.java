package com.example.HospitalManagementSystem.Repository;

import com.example.HospitalManagementSystem.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

}
