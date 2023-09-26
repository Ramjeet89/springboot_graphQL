package com.springboot.graphQL.service;

import com.springboot.graphQL.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    List<Book> getAllBooks();

    Book get(int bookId);
}
