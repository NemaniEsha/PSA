package com.cg.citipark.service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.citipark.beans.Payment;
import com.cg.citipark.exceptions.PaymentNotFoundException;
import com.cg.citipark.repository.PaymentRepository;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	@Override
	public Payment getPayment(long paymentId) throws PaymentNotFoundException{
		Optional<Payment> optional=paymentRepository.findById(paymentId);
		if(!optional.isPresent())
			throw new PaymentNotFoundException("Payment Details not found for id "+paymentId);	
		return optional.get();
	}
	@Override
	public List<Payment> deletePayment(long paymentId) throws PaymentNotFoundException{
		Optional<Payment> optional= paymentRepository.findById(paymentId);
		if(!optional.isPresent())		 
			throw new PaymentNotFoundException("Payment Details not found for id "+paymentId);
		else{
			Payment payment = paymentRepository.findById(paymentId).get();
			paymentRepository.delete(payment);
			return getAllPayments();
		}
	}
	
	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
	@Override
	public List<Payment> getPayments(Date date) {
		return paymentRepository.getPayments(date);
	}

	
	
}