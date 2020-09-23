package com.jameel.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(name = "/api")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/book")
	public BookServiceResponse createBook(@RequestBody BookServiceRequest bookServiceRequest) {
		return bookService.createBook(bookServiceRequest);
	}

	@PutMapping("/book")
	public BookServiceResponse updateBook(@RequestBody BookServiceRequest bookServiceRequest) {
		return bookService.updateBook(bookServiceRequest);
	}

	@GetMapping("/book")
	public BookServiceResponse getAllBook() {
		return bookService.getBooks(null);
	}

	@GetMapping("/book/{bookid}")
	public BookServiceResponse getBook(@PathVariable("bookid") String bookid) {
		Long id = Long.parseLong(bookid);
		return bookService.getBooks(id);
	}

	@DeleteMapping("/book/{bookid}")
	public BookServiceResponse deleteBook(@PathVariable("bookid") Long bookid) {
		return bookService.deleteBook(bookid);
	}
}