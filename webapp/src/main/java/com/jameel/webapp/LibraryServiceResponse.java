package com.jameel.webapp;

import java.util.List;

public class LibraryServiceResponse {

	private List<BookCatalog> bookCatalogs;
	private String status;
	private String errorMessage;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<BookCatalog> getBookCatalogs() {
		return bookCatalogs;
	}

	public void setBookCatalogs(List<BookCatalog> bookCatalogs) {
		this.bookCatalogs = bookCatalogs;
	}

}
