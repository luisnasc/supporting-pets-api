package br.com.dio.supportingpetsapi.exception;

public class PersonNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException(Long id) {
		super("Person not found with ID "+id);
	}
}
