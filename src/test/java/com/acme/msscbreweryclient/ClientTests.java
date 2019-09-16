package com.acme.msscbreweryclient;

import java.net.URI;
import java.util.UUID;

import com.acme.msscbrewery.domain.BeerDto;
import com.acme.msscbrewery.domain.BeerStyle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientTests {

	@Autowired
	Client client;

	@Test
	void getBeerById() {
		BeerDto beerDto = client.getById(UUID.randomUUID());
		System.out.println(beerDto);
	}

	@Test
	void saveBeer() {
		URI uri = client.save(BeerDto.builder().beerName("Busch Light").beerStyle(BeerStyle.Lager).build());
		System.out.println(uri);
	}
}
