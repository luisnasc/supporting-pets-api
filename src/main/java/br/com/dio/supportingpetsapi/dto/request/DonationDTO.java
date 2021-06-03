package br.com.dio.supportingpetsapi.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import br.com.dio.supportingpetsapi.entity.Animal;
import br.com.dio.supportingpetsapi.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {

	private Long idDonation;
	
	@NotNull
	private double value;
	
	private String donationDate;
	
	@Valid
	private Animal animal;

	@Valid
	private Person person;
}
