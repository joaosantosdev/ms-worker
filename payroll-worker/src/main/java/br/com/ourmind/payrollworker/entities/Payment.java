package br.com.ourmind.payrollworker.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private String name;
	private Double dailyIncome;
	private Integer days;

	public double getTotal() {
		return this.days * this.dailyIncome;
	}

}
