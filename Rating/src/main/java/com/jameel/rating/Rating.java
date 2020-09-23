package com.jameel.rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "bookid")
	private long bookid;

	@Column(name = "rating")
	private double rating;

	@Column(name = "ratingPoint")
	private long ratingPoint;

	@Column(name = "ratingCount")
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