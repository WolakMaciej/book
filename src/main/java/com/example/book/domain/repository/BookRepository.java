package com.example.book.domain.repository;

import com.example.book.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Override
    List<Book> findAll();
}
