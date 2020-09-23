package com.jameel.webapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryService {

	@Autowired
	RestTemplate restTemplate;

	public LibraryServiceResponse addBook(LibraryServiceRequest libraryServiceRequest) {
		LibraryServiceResponse serviceResponse = new LibraryServiceResponse();

		BookServiceRequest bookServiceRequest = new BookServiceRequest();
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle(libraryServiceRequest.getBook().getName());
		bookDTO.setDescription(libraryServiceRequest.getBook().getDescription());
		bookServiceRequest.setBookDTO(bookDTO);

		restTemplate.postForObject("http://Book/book", bookServiceRequest, BookServiceResponse.class);

		serviceResponse.setStatus("Data Saved Successfully!!!");
		return serviceResponse;
	}

	public LibraryServiceResponse editBook(LibraryServiceRequest libraryServiceRequest) {
		LibraryServiceResponse serviceResponse = new LibraryServiceResponse();

		BookServiceRequest bookServiceRequest = new BookServiceRequest();
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(libraryServiceRequest.getBook().getId());
		bookDTO.setTitle(libraryServiceRequest.getBook().getName());
		bookDTO.setDescription(libraryServiceRequest.getBook().getDescription());
		bookServiceRequest.setBookDTO(bookDTO);

		restTemplate.put("http://Book/book", bookServiceRequest);

		serviceResponse.setStatus("Data Updated Successfully!!!");
		return serviceResponse;
	}

	public LibraryServiceResponse getBook(LibraryServiceRequest libraryServiceRequest) {
		LibraryServiceResponse serviceResponse = new LibraryServiceResponse();

		String url = "http://Book/book/";

		Long id = libraryServiceRequest.getBook().getId();
		if (id != null) {
			url += id;
		}

		List<BookCatalog> bookCatalogs = new ArrayList<BookCatalog>();
		List<BookDTO> bookDTOs = restTemplate.getForObject(url, BookServiceResponse.class).getBookDTOs();
		for (BookDTO bookDTO : bookDTOs) {
			BookCatalog bookCatalog = new BookCatalog();
			bookCatalog.setId(bookDTO.getId());
			bookCatalog.setName(bookDTO.getTitle());
			bookCatalog.setDescription(bookDTO.getDescription());

			RatingServiceRequest ratingServiceRequest = new RatingServiceRequest();
			RatingDTO ratingDTO = new RatingDTO();
			ratingDTO.setBookid(bookDTO.getId());
			ratingServiceRequest.setRatingDTO(ratingDTO);

			RatingServiceResponse ratingServiceResponse = restTemplate
					.getForObject("http://Rating/rating/" + bookDTO.getId(), RatingServiceResponse.class);
			bookCatalog.setRatings(ratingServiceResponse.getRatingDTOs().get(0).getRating());
			bookCatalogs.add(bookCatalog);
		}

		serviceResponse.setBookCatalogs(bookCatalogs);
		return serviceResponse;
	}

	public LibraryServiceResponse updateRating(LibraryServiceRequest libraryServiceRequest) {
		LibraryServiceResponse serviceResponse = new LibraryServiceResponse();

		RatingServiceRequest ratingServiceRequest = new RatingServiceRequest();
		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setBookid(libraryServiceRequest.getBook().getId());
		ratingDTO.setRatingPoint((int) libraryServiceRequest.getBook().getRatings());
		ratingServiceRequest.setRatingDTO(ratingDTO);

		restTemplate.put("http://Rating/rating", ratingServiceRequest);

		serviceResponse.setStatus("Data Updated Successfully!!!");
		return serviceResponse;
	}
}
