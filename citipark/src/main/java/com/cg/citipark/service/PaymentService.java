package com.cg.citipark.service;
import java.util.List;
import java.sql.Date;

import com.cg.citipark.beans.Payment;
import com.cg.citipark.exceptions.PaymentNotFoundException;
public interface PaymentService {
	public Payment addPayment(Payment payment);
	public Payment getPayment(long paymentId) throws PaymentNotFoundException;
	public List<Payment> deletePayment(long PaymentId) throws PaymentNotFoundException;
	public List<Payment> getAllPayments();
	public List<Payment> getPayments(Date date);

}