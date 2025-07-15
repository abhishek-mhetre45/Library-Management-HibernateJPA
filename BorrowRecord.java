package com.library.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    
    @Column(name = "borrow_date")
    private LocalDate borrowDate = LocalDate.now();
    
    @Column(name = "due_date")
    private LocalDate dueDate;
    
    @Column(name = "return_date")
    private LocalDate returnDate;
    
    // Constructors, getters, setters
    public BorrowRecord() {}

    public BorrowRecord(Book book, Member member, LocalDate dueDate) {
        this.book = book;
        this.member = member;
        this.dueDate = dueDate;
    }

    // Getters and setters...
}