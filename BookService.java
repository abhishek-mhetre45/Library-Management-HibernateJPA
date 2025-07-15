package com.library.services;

import com.library.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BookService {
    private final EntityManager entityManager;

    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery(
            "SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    public List<Book> getAvailableBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.status = 'AVAILABLE'", Book.class);
        return query.getResultList();
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void updateBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }
}