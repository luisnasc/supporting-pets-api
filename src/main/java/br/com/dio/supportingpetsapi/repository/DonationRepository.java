package br.com.dio.supportingpetsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.supportingpetsapi.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{

}
