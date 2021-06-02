package br.com.dio.supportingpetsapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDonation;
	
	@Column(nullable = false)
	private double value;
	
	private LocalDate donationDate;
	
    @ManyToOne
    @JoinColumn(name = "idAnimal")	
	private Animal animal;
	
    @ManyToOne
    @JoinColumn(name = "idPerson")
	private Person person;
}
