package edu.training.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductResponse 

{
	private Integer productID;
	private String productName;
	private Double productPrice;
	private Integer productQuantitiy;


}
