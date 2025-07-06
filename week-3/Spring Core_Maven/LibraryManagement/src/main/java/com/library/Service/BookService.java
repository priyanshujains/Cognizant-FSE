package com.library.Service;

import com.library.Repository.BookRepository;

public class BookService {


    private BookRepository bookRepository;

    // Setter for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("BookService: Displaying book details.");
        bookRepository.fetchBook();
    }


}
