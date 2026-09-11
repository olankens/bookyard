package com.bookyard.repository;

import com.bookyard.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
    @Query("select b from Book b join fetch b.author")
    List<Book> findAllWithAuthor();

    @Query("select b.title from Book b")
    List<Book> findAllTitles();

    @Query("select b from Book b order by b.title asc")
    List<Book> findAllOrderedByTitle();

    @Query("select b from Book b where b.title = :title and b.author.name = :authorName")
    List<Book> findByTitleAndAuthorName(String title, String authorName);

    // @Query("""
    //             select b from Book b where b.title like %:keyword%
    //                         and b.price between :minPrice and :maxPrice
    //                                     order by b.title asc
    //         """)
    // List<Book> searchBooks(String keyword, Double minPrice, Double maxPrice);

    @Query("select b from Book b where b.title like %:keyword% order by b.title asc")
    List<Book> searchBooks(@Param("keyword") String keyword);
}