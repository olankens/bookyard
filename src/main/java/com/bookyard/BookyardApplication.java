package com.bookyard;

import com.bookyard.entity.Author;
import com.bookyard.entity.Book;
import com.bookyard.repository.AuthorRepository;
import com.bookyard.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class BookyardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookyardApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedData(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            if (bookRepository.count() == 0) {
                // @formatter:off
                var titles = List.of("Spring Boot Basics", "Mastering Java", "Clean Code", "Effective Java", "Java Concurrency", "Domain-Driven Design");
                var authors = List.of("John Doe", "Jane Smith", "Robert Martin", "Joshua Bloch", "Brian Goetz", "Eric Evans");
                // @formatter:on
                for (int i = 0; i < titles.size(); i++) {
                    var author = new Author();
                    author.setName(authors.get(i));
                    authorRepository.save(author);
                    var book = new Book();
                    book.setTitle(titles.get(i));
                    book.setAuthor(author);
                    bookRepository.save(book);
                }
            }
        };
    }
}