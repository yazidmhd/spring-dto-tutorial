package com.dtotutorial.dto.repository;

import com.dtotutorial.dto.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
