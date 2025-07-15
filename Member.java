package com.library.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "join_date")
    private LocalDate joinDate = LocalDate.now();
    
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<BorrowRecord> borrowRecords = new HashSet<>();

    // Constructors, getters, setters
    public Member() {}

    public Member(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters...
}