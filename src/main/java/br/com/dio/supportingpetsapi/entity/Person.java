package br.com.dio.supportingpetsapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerson;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	//@Column(nullable = false)
	private LocalDate birthDate;
	
	@Column(nullable = false)
	private String city;
	
	@OneToMany(mappedBy = "person")
	private List<Animal> animals;
	
	@OneToMany(mappedBy = "person")
	private List<Donation> donations;

}
