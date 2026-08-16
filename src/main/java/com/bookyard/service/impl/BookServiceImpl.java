package com.bookyard.service.impl;

import com.bookyard.entity.Author;
import com.bookyard.entity.Book;
import com.bookyard.repository.AuthorRepository;
import com.bookyard.repository.BookRepository;
import com.bookyard.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(String title, String authorName) {
        var author = new Author();
        author.setName(authorName);
        // if (true) throw new RuntimeException("Dummy failure before saving to test transactional");
        authorRepository.save(author);
        var book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    @Cacheable(value = "books", key = "#id")
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @CacheEvict(value = "books", key = "#id")
    public Book updateBook(Long id, Book book) {
        var existing = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        return bookRepository.save(existing);
    }

    @Override
    @CacheEvict(value = "books", key = "#id")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) throw new RuntimeException("Book not found with id: " + id);
        bookRepository.deleteById(id);
    }
}