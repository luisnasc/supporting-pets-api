package br.com.dio.supportingpetsapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.dio.supportingpetsapi.enums.Species;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnimal;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Species type;
	
	@Column(nullable = false)
	private String problem;
	
	@ManyToOne
	@JoinColumn(name = "idPerson")	
	private Person person;
	
	@OneToMany(mappedBy = "animal")
	private List<Donation> donations;
}
