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
	public int service_Req_No;
	public int service_Id;
	public int vehicle_Reg_No;
	public String date;
	public double price;
	public String status;
	public int mechanics_Id;
	@Column(nullable = false)
	public boolean is_deleted = false;
	public String create_Date_Time;
	public String update_Date_Time;

}
