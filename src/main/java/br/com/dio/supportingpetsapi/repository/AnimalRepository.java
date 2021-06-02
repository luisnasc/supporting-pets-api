package br.com.dio.supportingpetsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.supportingpetsapi.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
