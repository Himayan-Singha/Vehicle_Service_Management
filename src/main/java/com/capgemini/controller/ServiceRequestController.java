package com.capgemini.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceRequest;
import com.capgemini.repository.ServiceRequestRepository;

@RestController
@RequestMapping("/api/ServiceRequest/")
public class ServiceRequestController {
	
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	
	// http://localhost:8080/api/ServiceRequest/
	@GetMapping("/")
	public List<ServiceRequest> getAllServiceRequests(){
		return serviceRequestRepository.findAll();
		
	}
	
	// http://localhost:8080/api/ServiceRequest/{id}
	@GetMapping("/{id}")
	public ServiceRequest getServiceRequestsById(@PathVariable int id){
		ServiceRequest dbServiceRequest = serviceRequestRepository.findById(id).get();
		if(dbServiceRequest.isDeleted == true) {
			System.out.println("Service Request is deleted");
			System.exit(1); 		//replace with error handling
		}
		return dbServiceRequest;
	}
	
	// http://localhost:8080/api/ServiceRequest/
	@PostMapping("/")
	public String createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		serviceRequest.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		serviceRequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		serviceRequest.date = java.time.LocalDateTime.now().format(formatter);
		serviceRequestRepository.save(serviceRequest);
		return "Service Request Generated";
	}
		
	// http://localhost:8080/api/ServiceRequest/{id}
	@PutMapping("/{id}")
	public String updateServiceRequest(@PathVariable int id, @RequestBody ServiceRequest serviceRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		ServiceRequest dbServiceRequest = serviceRequestRepository.findById(id).get();
		if(dbServiceRequest != null) {
			dbServiceRequest.setMechanics_Id(serviceRequest.getMechanics_Id());
			dbServiceRequest.setPrice(serviceRequest.getPrice());
			dbServiceRequest.setService_Id(serviceRequest.getService_Id());
			dbServiceRequest.setStatus(serviceRequest.getStatus());
//			dbServiceRequest.setUpdate_Date_Time(java.time.LocalDateTime.now());
			dbServiceRequest.setUpdate_Date_Time(java.time.LocalDateTime.now().format(formatter));
			
			serviceRequestRepository.save(dbServiceRequest);
		}
		
		return "Service Request Updated";
		
	}
	
	// http://localhost:8080/api/ServiceRequest/{id}
	@DeleteMapping("/{id}")
	public String deleteServiceRequest(@PathVariable int id) {
		ServiceRequest dbServiceRequest = serviceRequestRepository.findById(id).get();
		if(dbServiceRequest.isDeleted == false) {
			dbServiceRequest.isDeleted = true;
			serviceRequestRepository.save(dbServiceRequest);
		}
		return "Service Request Deleted";
	}
	
	
}
