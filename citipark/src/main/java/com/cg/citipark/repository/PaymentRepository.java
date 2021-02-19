package com.cg.citipark.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.citipark.beans.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	@Query(value = "from Payment p where p.date=:date")
	public List<Payment> getPayments(Date date);

}