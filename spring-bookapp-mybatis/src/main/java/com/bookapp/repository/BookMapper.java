package com.bookapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.RowMapper;

import com.bookapp.model.Book;

public class BookMapper implements RowMapper<Book> {
	

	public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
		Book book = new Book();
		book.setAuthor(rs.getString("author"));
		book.setBookId(rs.getInt("book_Id"));
		book.setBookTitle(rs.getString("Book_title"));
		book.setCatagory(rs.getString("Catagory"));
		book.setPrice(rs.getDouble("price"));
		return book;
		
	}

	public int[] getRowsForPaths(TreePath[] path) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
