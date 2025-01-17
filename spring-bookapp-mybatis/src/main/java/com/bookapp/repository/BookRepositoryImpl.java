package com.bookapp.repository;

import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.util.Queries;

@Repository
public class BookRepositoryImpl implements IBookRepository {
	private JdbcTemplate jdbcTemplate;
	
	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Object[] bookArr = {book.getBookTitle(),book.getAuthor(),book.getBookId(),book.getCatagory()};
		jdbcTemplate.update(Queries.INSERTQUERY,bookArr);
	}

	@Override
	public void updateBook(int bookId, double price) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(Queries.UPDATEQUERY,price,bookId);
		
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(Queries.DELETEQUERY,bookId);
		
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		
		RowMapper<Book> mapper = new BookMapper();
		List<Book> books = jdbcTemplate.query(Queries.SELECTQUERY, mapper);
		return books;
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		// TODO Auto-generated method stub
		
		
		return jdbcTemplate.query(Queries.SELECTBYAUTHOURQUERY, (rs, rowNum)->{
			Book book = new Book();
			book.setAuthor(rs.getString("author"));
			book.setBookId(rs.getInt("book_Id"));
			book.setBookTitle(rs.getString("Book_title"));
			book.setCatagory(rs.getString("Catagory"));
			book.setPrice(rs.getDouble("price"));
			return book;
		},author);
	
		}

//	@Override
//	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		
//		List<Book> books=jdbcTemplate.query((Queries.SELECTBYPRICEQUERY, new BookMapper(), price);
//		return books;
//	}

	@Override
	public List<Book> findByAuthorCategory(String author, String Category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
