package com.jameel.webapp;

import java.util.List;

public class RatingServiceResponse {
	private List<RatingDTO> ratingDTOs;
	private String status;

	public List<RatingDTO> getRatingDTOs() {
		return ratingDTOs;
	}

	public void setRatingDTOs(List<RatingDTO> ratingDTOs) {
		this.ratingDTOs = ratingDTOs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
