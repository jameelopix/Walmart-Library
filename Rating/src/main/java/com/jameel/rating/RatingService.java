package com.jameel.rating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

	@Autowired
	RatingRepo ratingRepo;

	public RatingServiceResponse createRating(RatingServiceRequest ratingServiceRequest) {
		RatingDTO ratingDTO = ratingServiceRequest.getRatingDTO();
		Rating rating = new Rating();
		rating.setBookid(ratingDTO.getBookid());
		rating.setRating(0);
		rating.setRatingCount(0);
		rating.setRatingPoint(0);

		rating = ratingRepo.save(rating);

		RatingServiceResponse response = new RatingServiceResponse();
		response.setStatus("SUCCESS");

		return response;
	}

	public RatingServiceResponse updateRating(RatingServiceRequest ratingServiceRequest) {
		RatingDTO ratingDTO = ratingServiceRequest.getRatingDTO();
		Rating rating = ratingRepo.findByBookid(ratingDTO.getBookid());

		long point = rating.getRatingPoint() + ratingDTO.getRatingPoint();
		int count = rating.getRatingCount();
		count++;

		double finalRating = point / count;

		rating.setRatingCount(count);
		rating.setRatingPoint(point);
		rating.setRating(finalRating);
		rating = ratingRepo.save(rating);

		RatingServiceResponse response = new RatingServiceResponse();
		response.setStatus("SUCCESS");

		return response;
	}

	public RatingServiceResponse getRatings(Long id) {
		List<RatingDTO> ratingDTOs = new ArrayList<>();

		List<Rating> ratings = new ArrayList<Rating>();
		if (id != null) {
			ratings.add(ratingRepo.findByBookid(id));
		} else {
			ratings = ratingRepo.findAll();
		}
		for (Rating rating : ratings) {
			ratingDTOs.add(this.convert(rating));
		}

		RatingServiceResponse response = new RatingServiceResponse();
		response.setRatingDTOs(ratingDTOs);
		return response;
	}

	public RatingServiceResponse deleteRating(Long ratingId) {
		ratingRepo.deleteById(ratingId);

		RatingServiceResponse response = new RatingServiceResponse();
		response.setStatus("SUCCESS");
		return response;
	}

	private Rating convert(RatingDTO ratingDTO) {
		Rating rating = new Rating();
		rating.setId(ratingDTO.getId());
		rating.setBookid(ratingDTO.getBookid());
		rating.setRating(ratingDTO.getRating());
		rating.setRatingCount(ratingDTO.getRatingCount());
		rating.setRatingPoint(ratingDTO.getRatingPoint());
		return rating;
	}

	private RatingDTO convert(Rating rating) {
		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setId(rating.getId());
		ratingDTO.setBookid(rating.getBookid());
		ratingDTO.setRating(rating.getRating());
		ratingDTO.setRatingCount(rating.getRatingCount());
		ratingDTO.setRatingPoint(rating.getRatingPoint());
		return ratingDTO;
	}
}
