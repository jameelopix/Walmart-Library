package com.jameel.rating;

public class RatingDTO {

	private long id;

	private long bookid;

	private double rating;

	private long ratingPoint;

	private int ratingCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public long getRatingPoint() {
		return ratingPoint;
	}

	public void setRatingPoint(long ratingPoint) {
		this.ratingPoint = ratingPoint;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
}
