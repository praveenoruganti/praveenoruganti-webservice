package com.praveen.hms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.hms.entity.Appointment;
import com.praveen.hms.service.AppointmentService;

@RestController
@RequestMapping("/rest/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	
	@PostMapping
	public void saveAppointment(@RequestBody Appointment appointment) {
		appointmentService.saveAppointment(appointment);
	}
	
	@PostMapping("/all")
	public void saveAllAppointment(@RequestBody List<Appointment> appointments) {
		appointmentService.saveAllAppointment(appointments);
	}
	
	
	@GetMapping("/byDate/{date}")
	public List<Object[]> getAppointAndPatientByDate(@PathVariable("date")
	                                                            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date) {
		return appointmentService.getAppointAndPatientByDate(date);
	}
	
}
