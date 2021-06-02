package br.com.dio.supportingpetsapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.dio.supportingpetsapi.dto.MessageResponseDTO;
import br.com.dio.supportingpetsapi.dto.PersonDTO;
import br.com.dio.supportingpetsapi.entity.Person;
import br.com.dio.supportingpetsapi.exception.PersonNotFoundException;
import br.com.dio.supportingpetsapi.mapper.PersonMapper;
import br.com.dio.supportingpetsapi.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	private PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO person) {
		Person personToSave = personMapper.toModel(person);
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse(savedPerson.getIdPerson(), "Person created with ID ");
	}
	
	public List<PersonDTO> listAll() {
		var allPeople = personRepository.findAll();
		return allPeople.stream().map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	private MessageResponseDTO createMessageResponse(Long idPerson, String message) {
		return MessageResponseDTO.builder().message(message + idPerson).build();
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}
	
	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		
		personRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, @Valid PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);
		
		Person personToUpdate = personMapper.toModel(personDTO);
		
		Person updatedPerson = personRepository.save(personToUpdate);
		return createMessageResponse(updatedPerson.getIdPerson(), "Updated person with ID: ");
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

}
