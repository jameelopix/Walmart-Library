package com.jameel.rating;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, Long> {

	public Rating findByBookid(Long id);
}
