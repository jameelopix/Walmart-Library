package com.jameel.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@PostMapping("/book")
	public LibraryServiceResponse addBook(@RequestBody LibraryServiceRequest request) {
		return libraryService.addBook(request);
	}

	@PutMapping("/book")
	public LibraryServiceResponse updateBook(@RequestBody LibraryServiceRequest request) {
		return libraryService.editBook(request);
	}

	@GetMapping("/book")
	public LibraryServiceResponse getBook(@RequestBody LibraryServiceRequest request) {
		return libraryService.getBook(request);
	}

	@PutMapping("/rating")
	public LibraryServiceResponse updateRating(@RequestBody LibraryServiceRequest request) {
		return libraryService.updateRating(request);
	}
}
