package com.library.utils;

import com.library.models.Book;
import com.library.models.Member;
import com.library.services.BookService;
import com.library.services.MemberService;
import org.apache.commons.lang3.StringUtils;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;
    private final BookService bookService;
    private final MemberService memberService;

    public ConsoleUI(BookService bookService, MemberService memberService) {
        this.scanner = new Scanner(System.in);
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Borrow/Return Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> bookManagementMenu();
                case 2 -> memberManagementMenu();
                case 3 -> borrowReturnMenu();
                case 4 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void bookManagementMenu() {
        // Implementation for book management
    }

    private void memberManagementMenu() {
        // Implementation for member management
    }

    private void borrowReturnMenu() {
        // Implementation for borrow/return operations
    }

    public void displayBooks(List<Book> books) {
        System.out.println("\n===== BOOK LIST =====");
        System.out.printf("%-5s %-30s %-20s %-10s %-15s%n", 
            "ID", "Title", "Author", "Year", "Status");
        System.out.println(StringUtils.repeat("-", 80));
        
        for (Book book : books) {
            System.out.printf("%-5d %-30s %-20s %-10s %-15s%n",
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getStatus());
        }
    }
}