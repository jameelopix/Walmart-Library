package com.jameel.rating;

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
public class RatingController {

	@Autowired
	RatingService ratingService;

	@PostMapping("/rating")
	public RatingServiceResponse createRating(@RequestBody RatingServiceRequest ratingServiceRequest) {
		return ratingService.createRating(ratingServiceRequest);
	}

	@PutMapping("/rating")
	public RatingServiceResponse updateRating(@RequestBody RatingServiceRequest ratingServiceRequest) {
		return ratingService.updateRating(ratingServiceRequest);
	}

	@GetMapping("/rating")
	public RatingServiceResponse getAllRating() {
		return ratingService.getRatings(null);
	}

	@GetMapping("/rating/{bookId}")
	public RatingServiceResponse getRating(@PathVariable("bookId") String bookId) {
		Long bid = Long.parseLong(bookId);
		return ratingService.getRatings(bid);
	}

	@DeleteMapping("/rating/{ratingid}")
	public RatingServiceResponse deleteRating(@PathVariable("ratingid") Long ratingid) {
		return ratingService.deleteRating(ratingid);
	}
}