package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Installments> list = new ArrayList<>();
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		sc.nextLine();
		String dateTemp = sc.nextLine();
		Date date = sdf.parse(dateTemp);
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		Integer months = sc.nextInt();
		
		
		
		double baseInstallment = totalValue / months;
		
		for (int i = 1; i<= months; i ++) {
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(date);
			cal.add(Calendar.MONTH, i);
			Date instDate = cal.getTime();
			Installments installment = new Installments(instDate, baseInstallment);
			list.add(installment);
		}
		
		
		Contract contract = new Contract(number, date, totalValue, list);
		ContractService contractService = new ContractService(new PaypalService()); 
		contractService.processContract(contract, months);
		
		System.out.println("Installments: ");
		
		for (Installments i : list) {
			String dueDate = sdf.format(i.getDueDate());
			System.out.println(dueDate + " - " + String.format("%.2f", i.getAmount()));
		}
		sc.close();
	}

}
