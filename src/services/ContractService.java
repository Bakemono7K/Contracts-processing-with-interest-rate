package services;

import entities.Contract;
import entities.Installments;

public class ContractService {

	private OnlinePaymentService ops;

	public ContractService() {

	}

	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer months) {
		months = 0;
		for (Installments i : contract.getList()) {
			months++;
			 i.setAmount(ops.paymentFee(ops.interest(i.getAmount(),months)));
		}
		
	}
}
