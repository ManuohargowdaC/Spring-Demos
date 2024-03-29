package com.bookapp.util;

import com.bookapp.model.Book;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BookDetails {
    public  List<Book> showBooks(){
        return Arrays.asList(
                new Book("java in action","john david","Tech",1,900),
                new Book("5 am Club","Robin sharma","Self help",2,500),
                new Book("HTML for Dummies","Ben john","Tech",3,1900),
                new Book("Secret sven","Enid ben","Fiction",5,800)
        );
    }
}
