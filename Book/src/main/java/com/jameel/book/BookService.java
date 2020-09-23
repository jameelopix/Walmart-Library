package com.jameel.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BookRepo bookRepo;

	public BookServiceResponse createBook(BookServiceRequest bookServiceRequest) {
		BookDTO bookDTO = bookServiceRequest.getBookDTO();
		Book book = this.convert(bookDTO);
		book = bookRepo.save(book);

		RatingServiceRequest ratingServiceRequest = new RatingServiceRequest();
		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setBookid(book.getId());
		ratingServiceRequest.setRatingDTO(ratingDTO);

		restTemplate.postForObject("http://Rating/rating", ratingServiceRequest, RatingServiceResponse.class);

		BookServiceResponse response = new BookServiceResponse();
		response.setStatus("SUCCESS");

		return response;
	}

	public BookServiceResponse updateBook(BookServiceRequest bookServiceRequest) {
		BookDTO bookDTO = bookServiceRequest.getBookDTO();
		Book book = bookRepo.getOne(bookDTO.getId());

		book.setTitle(bookDTO.getTitle());
		book.setDescription(bookDTO.getDescription());
		book = bookRepo.save(book);

		BookServiceResponse response = new BookServiceResponse();
		response.setStatus("SUCCESS");

		return response;
	}

	public BookServiceResponse getBooks(Long id) {
		List<BookDTO> bookDTOs = new ArrayList<>();

		List<Book> books = new ArrayList<Book>();
		if (id != null) {
			books.add(bookRepo.getOne(id));
		} else {
			books = bookRepo.findAll();
		}
		for (Book book : books) {
			bookDTOs.add(this.convert(book));
		}

		BookServiceResponse response = new BookServiceResponse();
		response.setBookDTOs(bookDTOs);
		return response;
	}

	public BookServiceResponse deleteBook(Long bookId) {
		bookRepo.deleteById(bookId);

		BookServiceResponse response = new BookServiceResponse();
		response.setStatus("SUCCESS");
		return response;
	}

	private Book convert(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setTitle(bookDTO.getTitle());
		book.setDescription(bookDTO.getDescription());
		return book;
	}

	private BookDTO convert(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setDescription(book.getDescription());
		return bookDTO;
	}
}
