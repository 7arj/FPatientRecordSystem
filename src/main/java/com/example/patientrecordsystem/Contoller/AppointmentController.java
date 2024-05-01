package com.example.patientrecordsystem.Contoller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patientrecordsystem.Models.Appointment;
import com.example.patientrecordsystem.Service.AppointmentServiceInterface;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentServiceInterface appointmentServiceInterface;
    public AppointmentController(AppointmentServiceInterface appointmentServiceInterface) {
        this.appointmentServiceInterface = appointmentServiceInterface;
    }
    @GetMapping
    public List<Appointment> getAllAppointments() {

        return appointmentServiceInterface.getAllAppointments();
    }
    @GetMapping("/{patientId}")
    public List<Appointment> getAllAppointmentsByPatientId(@PathVariable("patientId") Long patientId) {
        return appointmentServiceInterface.getAllAppointmentsByPatientId(patientId);
    }
    @PutMapping()
    public Appointment updateAppointment(@RequestBody Appointment appointment) {
        return appointmentServiceInterface.updateAppointment(appointment);
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable("id") Long id) {
        appointmentServiceInterface.deleteAppointment(id);
    }


}
