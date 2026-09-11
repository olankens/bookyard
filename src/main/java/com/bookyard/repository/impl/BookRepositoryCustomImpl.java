package com.bookyard.repository.impl;

import com.bookyard.entity.Book;
import com.bookyard.repository.BookRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findBooks(String title, String authorName) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        var predicates = new ArrayList<>();
        // @formatter:off
        if (title != null) predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
        if (authorName != null) predicates.add(criteriaBuilder.like(root.get("author").get("name"), "%" + authorName + "%"));
        // @formatter:on
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}