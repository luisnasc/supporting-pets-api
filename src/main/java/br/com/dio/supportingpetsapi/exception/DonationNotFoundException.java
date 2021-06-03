package br.com.dio.supportingpetsapi.exception;

public class DonationNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public DonationNotFoundException(Long id) {
		super("Donation not found with ID "+id);
	}
}
