package com.acme.msscbreweryclient;

import java.net.URI;
import java.util.UUID;

import com.acme.msscbrewery.domain.BeerDto;
import static com.acme.msscbreweryclient.EndPoints.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix="sfg.brewery", ignoreUnknownFields=false)
public class Client {
    
private String apiHost;

private final RestTemplate restTemplate;

public Client(RestTemplateBuilder restTemplateBuilder){
    restTemplate = restTemplateBuilder.build();
}


public void setApiHost(String apiHost){
    this.apiHost=apiHost;
}

public BeerDto getById(UUID uuid){
    return restTemplate.getForObject(apiHost + API_V1_BEER + "/{id}", BeerDto.class, uuid);
}

public URI save(BeerDto beerDto){
    return restTemplate.postForLocation(apiHost + API_V1_BEER, beerDto);
}

}