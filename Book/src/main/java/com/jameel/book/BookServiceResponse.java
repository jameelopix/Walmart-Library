package com.jameel.book;

import java.util.List;

public class BookServiceResponse {
	private List<BookDTO> bookDTOs;
	private String status;

	public List<BookDTO> getBookDTOs() {
		return bookDTOs;
	}

	public void setBookDTOs(List<BookDTO> bookDTOs) {
		this.bookDTOs = bookDTOs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
