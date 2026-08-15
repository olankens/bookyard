package com.bookyard.repository;

import com.bookyard.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findBooks(String title, String authorName);
}