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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int service_Req_No; //auto-generated
	public int service_Id; //mapped from Service Catalog
	public int vehicle_Reg_No; //mapped from Vehicle
	public String date; //add in controller
	public double price; //add in controller
	public String status; //add in controller
	public int mechanics_Id; //mapped from Mechanics
	
	@Column(nullable = false)
	public boolean is_deleted = false;
	public String create_Date_Time;
	public String update_Date_Time;
	

}
