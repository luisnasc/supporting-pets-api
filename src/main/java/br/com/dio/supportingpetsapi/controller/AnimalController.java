package br.com.dio.supportingpetsapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.supportingpetsapi.dto.AnimalDTO;
import br.com.dio.supportingpetsapi.dto.MessageResponseDTO;
import br.com.dio.supportingpetsapi.service.AnimalService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/animal")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimalController {

	private AnimalService animalService;
	
	@GetMapping
	public List<AnimalDTO> findAll(){
		return animalService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MessageResponseDTO createAnimal(@RequestBody @Valid AnimalDTO animalDTO) {
		return animalService.createAnimal(animalDTO);
	}
}
