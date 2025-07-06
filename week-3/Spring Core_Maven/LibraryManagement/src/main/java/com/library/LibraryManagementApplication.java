package com.library;

import com.library.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = ct.getBean(BookService.class);
        bookService.displayBook();

    }
}