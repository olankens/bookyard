package com.bookyard.service.impl;

import com.bookyard.entity.Book;
import com.bookyard.repository.BookRepository;
import com.bookyard.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        var existing = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        return bookRepository.save(existing);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) throw new RuntimeException("Book not found with id " + id);
        bookRepository.deleteById(id);
    }
}