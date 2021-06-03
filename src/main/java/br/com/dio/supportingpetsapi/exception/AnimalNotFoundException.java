package br.com.dio.supportingpetsapi.exception;

public class AnimalNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AnimalNotFoundException(Long id) {
		super("Animal not found with ID "+id);
	}
}
