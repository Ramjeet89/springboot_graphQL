package com.springboot.graphQL.service.impl;

import com.springboot.graphQL.model.Book;
import com.springboot.graphQL.repository.BookRepository;
import com.springboot.graphQL.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(() ->
                new RuntimeException("The Book you are looking for not found on server"));
    }
}
