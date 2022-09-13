package com.springmvc.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

	private BigDecimal amount;
	private Currency currency;
	private LocalDate date;
	private CreditCard creditCard;
}
