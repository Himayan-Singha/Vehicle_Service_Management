package com.capgemini;

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

import com.capgemini.entities.Mechanics;
import com.capgemini.entities.ServiceCatalog;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.Vehicle;
import com.capgemini.repository.MechanicsRepository;
import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceRequestRepository;
import com.capgemini.repository.VehicleRepository;

@RestController
@RequestMapping("/api/servicerequest/")
public class ServiceRequestController {

	@Autowired
	private ServiceRequestRepository serreqrepository;
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private ServiceCatalogRepository sercatrepo;
	
	@Autowired
	private MechanicsRepository mechanicsrepository;
	
	//creating the service request
	@PostMapping("/")
	public String create(@RequestBody ServiceRequest servicerequest) {
		if(servicerequest.getVehicle()!=null) {
			Vehicle vehi=vehiclerepository.findById(servicerequest.getVehicle().getVehicle_reg_no()).get();
			servicerequest.setVehicle(vehi);
		}
		if(servicerequest.getServiceCatalog()!=null) {
			ServiceCatalog ser_cat=sercatrepo.findById(servicerequest.getServiceCatalog().getService_catalog_id()).get();
			servicerequest.setServiceCatalog(ser_cat);
		}
		if(servicerequest.getMechanics()!=null) {
			Mechanics mech=mechanicsrepository.findById(servicerequest.getMechanics().getMechanicsId()).get();
			servicerequest.setMechanics(mech);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		servicerequest.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicerequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicerequest.date = java.time.LocalDateTime.now().format(formatter);
		
		serreqrepository.save(servicerequest);
		return "Request Added!!!";
	}
	
	@PutMapping("/{service_req_id}")
	public String update(@PathVariable int service_req_id ,@RequestBody ServiceRequest servicerequest) {
		ServiceRequest dbServiceRequest= serreqrepository.findById(service_req_id).get();
		if(dbServiceRequest!=null) {
			
			dbServiceRequest.setStatus(servicerequest.getStatus());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			servicerequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
		serreqrepository.save(dbServiceRequest);
			return "Status Updated";
		}
	//finding all the details of all service request
	@GetMapping("/")
	public List<ServiceRequest> getRequest(){
		return serreqrepository.findAll();
	}
	
	//finding request details by id
	@GetMapping("/{service_req_id}")
	public ServiceRequest getRequestById(@PathVariable Integer service_req_id) {
		ServiceRequest dbServiceRequest = serreqrepository.findById(service_req_id).get();
		if(dbServiceRequest.isDeleted == false) {
			return dbServiceRequest;
		}
		return null;
	}
	
	@DeleteMapping("/{service_req_id}")
	public String deleteUser(@PathVariable int service_req_id) {
		ServiceRequest dbServiceRequest= serreqrepository.findById(service_req_id).get();
		if(dbServiceRequest.isDeleted == false) {
			dbServiceRequest.isDeleted = true;
			serreqrepository.save(dbServiceRequest);
		}
		return "Service Request Deleted";
	}
}
