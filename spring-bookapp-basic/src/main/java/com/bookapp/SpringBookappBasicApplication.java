package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.IBookServiceImpl;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
		
		
	}
	@Autowired
	IBookService iBookService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	
	Scanner sc = new Scanner(System.in);
    System.out.println("Enter book category to find books");
    String userCategory = sc.next();
    

    List<Book> booksByCategory;

    try {
        List<Book> booksoByCategory = iBookService.getByCategory(userCategory);
        for (Book book : booksoByCategory) {
            System.out.println(book);
        }
    }catch (BookNotFoundException e){
                e.printStackTrace();
        }

        System.out.println("Find books by author");

        String userInputAuthor = sc.next();
        List<Book> booksByAuthor=iBookService.getByCategory(userCategory);

        try {
            booksByAuthor = iBookService.getByAuthorStartsWith(userInputAuthor);
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }}catch (BookNotFoundException e){
                e.printStackTrace();
            }
}
	

}
