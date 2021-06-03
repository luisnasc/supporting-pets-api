package br.com.dio.supportingpetsapi.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.dio.supportingpetsapi.entity.Animal;
import br.com.dio.supportingpetsapi.entity.Donation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	
	private Long idPerson;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	private String birthDate;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String city;
	
	@Valid
	private List<Animal> animals;
	
	@Valid
	private List<Donation> donations;
}
