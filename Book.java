package com.library.models;

import jakarta.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String author;
    
    @Column(unique = true)
    private String isbn;
    
    private Year publicationYear;
    
    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.AVAILABLE;
    
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BorrowRecord> borrowRecords = new HashSet<>();

    public enum BookStatus {
        AVAILABLE, BORROWED, RESERVED, LOST
    }

    
    public Book() {
        
    }

    public Book(String title, String author, String isbn, Year publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    
}