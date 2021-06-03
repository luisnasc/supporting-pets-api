package br.com.dio.supportingpetsapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import br.com.dio.supportingpetsapi.dto.request.DonationDTO;
import br.com.dio.supportingpetsapi.entity.Donation;

@Mapper
public interface DonationMapper {

	DonationMapper INSTANCE = Mappers.getMapper(DonationMapper.class);
	
	@Mapping(target = "donationDate", source = "donationDate", dateFormat = "dd-MM-yyyy")
	Donation toModel(DonationDTO donationDTO);
	
	DonationDTO toDTO(Donation donation);
}
