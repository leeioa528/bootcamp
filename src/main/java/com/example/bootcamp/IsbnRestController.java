package com.example.bootcamp;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//this tells spring that this is an http api, or end point
@RestController
class IsbnRestController {

	// pointer to rest template
	private final RestTemplate restTemplate;

	IsbnRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	// localhost:8080/books/39929u22322
	@GetMapping("/books/{isbn}")
	String lookupBookByIsbn(@PathVariable("isbn") String isbn) {
		ResponseEntity<String> exchange = this.restTemplate.exchange(
				"https://www.googleapis.com/books/v1/volumes?q=isbn:1449374646",
				HttpMethod.GET, null, String.class);
		return exchange.getBody();
	}

}
