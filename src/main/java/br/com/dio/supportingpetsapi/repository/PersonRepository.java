package br.com.dio.supportingpetsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.supportingpetsapi.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{

}
