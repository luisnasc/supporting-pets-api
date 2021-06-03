package br.com.dio.supportingpetsapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.dio.supportingpetsapi.dto.MessageResponseDTO;
import br.com.dio.supportingpetsapi.dto.request.DonationDTO;
import br.com.dio.supportingpetsapi.entity.Animal;
import br.com.dio.supportingpetsapi.entity.Donation;
import br.com.dio.supportingpetsapi.exception.AnimalNotFoundException;
import br.com.dio.supportingpetsapi.exception.DonationNotFoundException;
import br.com.dio.supportingpetsapi.mapper.DonationMapper;
import br.com.dio.supportingpetsapi.repository.DonationRepository;

@Service
public class DonationService {

	private DonationRepository donationRepository;
	
	private DonationMapper donationMapper = DonationMapper.INSTANCE;
	
	@Autowired
	public DonationService(DonationRepository donationRepository) {
		this.donationRepository = donationRepository;
	}

	public List<DonationDTO> findAll() {
		return donationRepository.findAll()
				.stream()
				.map(donationMapper::toDTO)
				.collect(Collectors.toList());
				
	}

	public MessageResponseDTO create(@RequestBody @Valid DonationDTO donationDTO) {
		Donation donationToSave = donationMapper.toModel(donationDTO);
		Donation savedDonation = donationRepository.save(donationToSave);
		
		return createMessageResponse(savedDonation.getIdDonation(), "Donation created with ID ");
	}
	
	private MessageResponseDTO createMessageResponse(Long idDonation, String message) {
		return MessageResponseDTO.builder().message(message + idDonation).build();
	}
	
	private Donation verifyIfExists(Long id) throws DonationNotFoundException {
		return donationRepository.findById(id).orElseThrow(() -> new DonationNotFoundException(id) ); 
	}

}
