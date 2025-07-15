package com.library;

import com.library.config.HibernateConfig;
import com.library.services.BookService;
import com.library.services.MemberService;
import com.library.utils.ConsoleUI;
import jakarta.persistence.EntityManager;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        
        try {
            BookService bookService = new BookService(entityManager);
            MemberService memberService = new MemberService(entityManager);
            
            ConsoleUI consoleUI = new ConsoleUI(bookService, memberService);
            consoleUI.displayMainMenu();
        } finally {
            HibernateConfig.shutdown();
        }
    }
}