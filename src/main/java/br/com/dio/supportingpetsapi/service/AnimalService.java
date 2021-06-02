package br.com.dio.supportingpetsapi.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.dio.supportingpetsapi.dto.AnimalDTO;
import br.com.dio.supportingpetsapi.dto.MessageResponseDTO;
import br.com.dio.supportingpetsapi.entity.Animal;
import br.com.dio.supportingpetsapi.mapper.AnimalMapper;
import br.com.dio.supportingpetsapi.repository.AnimalRepository;

@Service
public class AnimalService {

	private AnimalRepository animalRepository;
	
	private AnimalMapper animalMapper = AnimalMapper.INSTANCE;

	@Autowired
	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}
	
	public MessageResponseDTO createAnimal(@RequestBody @Valid AnimalDTO animalDTO) {
		Animal animalToSave = animalMapper.toModel(animalDTO);
		Animal savedAnimal = animalRepository.save(animalToSave);
		return createMessageResponse(savedAnimal.getIdAnimal(), "Animal created with ID ");
	}

	public List<AnimalDTO> findAll(){
		var animals = animalRepository.findAll();
		return animals.stream()
				.map(animalMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	private MessageResponseDTO createMessageResponse(Long idAnimal, String message) {
		return MessageResponseDTO.builder().message(message + idAnimal).build();
	}
}
