package br.com.dio.supportingpetsapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Species {

	DOG("Dog"), RABBIT("Rabbit"), CAT("Cat");
	
	private final String name;
}
