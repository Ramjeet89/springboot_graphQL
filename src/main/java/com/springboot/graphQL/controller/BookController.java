package com.springboot.graphQL.controller;

import com.springboot.graphQL.model.Book;
import com.springboot.graphQL.model.BookInput;
import com.springboot.graphQL.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

    @QueryMapping("allBooks")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }
}


