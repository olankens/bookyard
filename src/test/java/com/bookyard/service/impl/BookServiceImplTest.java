package com.bookyard.service.impl;

import com.bookyard.entity.Author;
import com.bookyard.entity.Book;
import com.bookyard.messaging.BookEventProducer;
import com.bookyard.repository.AuthorRepository;
import com.bookyard.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookEventProducer bookEventProducer;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void createBookSavesAuthorAndBookAndSendsEvent() {
        when(authorRepository.save(any(Author.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));
        var book = bookService.createBook("Dune", "Frank Herbert");
        assertThat(book.getTitle()).isEqualTo("Dune");
        assertThat(book.getAuthor().getName()).isEqualTo("Frank Herbert");
        verify(bookRepository).save(book);
        verify(bookEventProducer).sendBookCreatedEvent("Dune");
    }

    @Test
    void getBookByIdReturnsBookWhenFound() {
        var book = new Book();
        book.setId(1L);
        book.setTitle("Dune");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        assertThat(bookService.getBookById(1L)).isEqualTo(book);
    }

    @Test
    void getBookByIdThrowsWhenNotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> bookService.getBookById(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("99");
    }

    @Test
    void getAllBooksReturnsAllBooks() {
        var book = new Book();
        book.setTitle("Dune");
        when(bookRepository.findAll()).thenReturn(List.of(book));
        assertThat(bookService.getAllBooks()).containsExactly(book);
    }

    @Test
    void updateBookOverwritesTitleAndAuthor() {
        var existing = new Book();
        existing.setId(1L);
        existing.setTitle("Old");
        var author = new Author();
        author.setName("New Author");
        var changes = new Book();
        changes.setTitle("New Title");
        changes.setAuthor(author);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(bookRepository.save(existing)).thenAnswer(invocation -> invocation.getArgument(0));
        var updated = bookService.updateBook(1L, changes);
        assertThat(updated.getTitle()).isEqualTo("New Title");
        assertThat(updated.getAuthor()).isEqualTo(author);
        verify(bookRepository).save(existing);
    }

    @Test
    void updateBookThrowsWhenNotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> bookService.updateBook(99L, new Book()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("99");
    }

    @Test
    void deleteBookDeletesExistingBook() {
        when(bookRepository.existsById(1L)).thenReturn(true);
        bookService.deleteBook(1L);
        verify(bookRepository).deleteById(1L);
    }

    @Test
    void deleteBookThrowsWithoutDeletingWhenNotFound() {
        when(bookRepository.existsById(99L)).thenReturn(false);
        assertThatThrownBy(() -> bookService.deleteBook(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("99");
        verify(bookRepository, never()).deleteById(99L);
    }
}
