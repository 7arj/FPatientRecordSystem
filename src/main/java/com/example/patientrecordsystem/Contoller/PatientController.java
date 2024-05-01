package com.example.patientrecordsystem.Contoller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patientrecordsystem.Models.Patient;
import com.example.patientrecordsystem.Service.PatientServiceInterface;



@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientServiceInterface patientServiceInterface;
    public PatientController(PatientServiceInterface patientServiceInterface) {
        this.patientServiceInterface = patientServiceInterface;
    }
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientServiceInterface.getAllPatients();
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServiceInterface.getPatientById(id);
    }
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientServiceInterface.addPatient(patient);
    }
    @DeleteMapping("/{id}")
    public  void deletePatient(@PathVariable("id") Long id) {
         patientServiceInterface.deletePatient(id);
    }
}
