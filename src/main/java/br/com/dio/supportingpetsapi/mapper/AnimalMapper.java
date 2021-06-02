package br.com.dio.supportingpetsapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import br.com.dio.supportingpetsapi.dto.AnimalDTO;
import br.com.dio.supportingpetsapi.entity.Animal;

@Mapper
public interface AnimalMapper {

	AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
	
	Animal toModel(AnimalDTO animalDTO);
	
	AnimalDTO toDTO(Animal animal);
}
