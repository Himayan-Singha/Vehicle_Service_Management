package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.ServiceRequestDetail;

public interface ServiceRequestDetailRepository extends JpaRepository<ServiceRequestDetail,Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from ServiceRequestDetail where is_deleted = true")
	void deleteServiceRequestDetailByIsDelete(boolean isDeleted);

}
