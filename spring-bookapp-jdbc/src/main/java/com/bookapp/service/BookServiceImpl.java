package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.BookMapper;
import com.bookapp.repository.IBookRepository;
import com.bookapp.util.Queries;
@Service
public class BookServiceImpl implements IBookService{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IBookRepository iBookRepository;
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		RowMapper<Book> mapper = new BookMapper();
		List<Book> books = jdbcTemplate.query(Queries.SELECTQUERY, mapper);
		return books;
		
	}

	@Override
	public List<Book> getByAuthorStartsWith(String author) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		iBookRepository.addBook(book);
		
	
	}

	@Override
	public void updateBook(int bookId, double price) {
		// TODO Auto-generated method stub
		iBookRepository.updateBook(bookId,price);
		
		
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		iBookRepository.deleteBook(bookId);
		
	}
	
	

}
