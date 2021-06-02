package br.com.dio.supportingpetsapi.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.dio.supportingpetsapi.entity.Donation;
import br.com.dio.supportingpetsapi.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

	private Long idAnimal;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String name;
	
	@NotNull
	private int age;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String type;
	
	@NotEmpty
	@Size(min = 5, max = 300)
	private String problem;
	
	@Valid
	private Person person;
	
	@Valid
	private List<Donation> donations;
}
