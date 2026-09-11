package com.bookyard.service;

import com.bookyard.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(String title, String authorName);

    Book getBookById(Long id);

    List<Book> getAllBooks();

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);
}