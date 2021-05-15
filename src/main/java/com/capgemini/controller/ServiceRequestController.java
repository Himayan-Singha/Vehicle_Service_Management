package com.capgemini.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceRequest;
import com.capgemini.repository.ServiceRequestRepository;

@RestController
@RequestMapping("/api/ServiceRequest")
public class ServiceRequestController {
	
	private ServiceRequestRepository serviceRequestRepository;
	
	// http://localhost:8080/api/ServiceRequest/
	@GetMapping("/")
	public List<ServiceRequest> getAllServiceRequests(){
		return serviceRequestRepository.findAll();
		
	}
	
	// http://localhost:8080/api/ServiceRequest/{id}
	@GetMapping("/{id}")
	public ServiceRequest getServiceRequestsById(@PathVariable int id){
		return serviceRequestRepository.findById(id).get();
		
	}
	
	// http://localhost:8080/api/ServiceRequest/
		@PostMapping("/")
		public String createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
			
			return "Service Request Generated";
		}
	
}
