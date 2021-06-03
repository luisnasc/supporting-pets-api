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
import br.com.dio.supportingpetsapi.dto.request.DonationDTO;
import br.com.dio.supportingpetsapi.exception.DonationNotFoundException;
import br.com.dio.supportingpetsapi.service.DonationService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/donation")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DonationController {

	DonationService donationService;
	
	@GetMapping
	public List<DonationDTO> findAll(){
		return donationService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MessageResponseDTO createDonation(@RequestBody @Valid DonationDTO donationDTO) {
		return donationService.create(donationDTO);
		
	}
	
	@GetMapping("/{id}")
	public DonationDTO findById(@PathVariable Long id) throws DonationNotFoundException {
		return donationService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid DonationDTO donationDTO) throws DonationNotFoundException {
		return donationService.updateById(id, donationDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws DonationNotFoundException {
		donationService.deleteById(id);
	}
}
