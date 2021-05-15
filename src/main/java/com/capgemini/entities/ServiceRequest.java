package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ServiceRequest {
	
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int service_Req_No; //auto-generated
	public int service_Id; //mapped from Service Catalog
	public int vehicle_Reg_No; //mapped from Vehicle
	public double price; //add in controller
	public String status; //add in controller
	public int mechanics_Id; //mapped from Mechanics
	//public String date = java.time.LocalDateTime.now().format(formatter); //add in controller
	public String date = ""; //add in controller
	
	@Column(nullable = false)
	public boolean isDeleted = false;
//	public LocalDateTime create_Date_Time = java.time.LocalDateTime.now();
//	public LocalDateTime update_Date_Time = java.time.LocalDateTime.now();
	
	public String create_Date_Time = "";
	public String update_Date_Time = "";

}
