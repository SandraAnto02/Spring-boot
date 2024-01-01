package edu.training.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest 
{
	private String productName;
	private Double productPrice;
	private Integer productQuantitiy;

}
