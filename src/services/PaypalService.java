package services;

public class PaypalService implements OnlinePaymentService {



	public Double interest(Double amount, Integer month) {
		Double interesstValue =  amount * 0.01 * month;
		return amount + interesstValue;
		
	}

	public Double paymentFee(Double amount) {
		return amount + amount * 0.02;
	}
}
