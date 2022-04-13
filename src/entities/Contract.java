package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	Integer number;
	Date date;
	Double totalValue;
	List<Installments> list = new ArrayList<>();
	
	public Contract() {
		
	}
	public Contract(Integer number, Date date, Double totalValue, List<Installments> list) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		this.list = list;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNumber() {
		return number;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public List<Installments> getList() {
		return list;
	}
		
	
}
