package br.com.dio.supportingpetsapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.supportingpetsapi.dto.MessageResponseDTO;
import br.com.dio.supportingpetsapi.dto.request.PersonDTO;
import br.com.dio.supportingpetsapi.exception.PersonNotFoundException;
import br.com.dio.supportingpetsapi.service.PersonService;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

	private PersonService personService;
	
	@GetMapping
	public List<PersonDTO> listAll() {
		return personService.listAll();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO person) {
		return personService.createPerson(person);
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
		return personService.updateById(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		personService.delete(id);
	}
}
