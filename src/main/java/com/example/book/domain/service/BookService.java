package com.example.book.domain.service;

import com.example.book.domain.model.Book;
import com.example.book.domain.repository.BookRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void create(Book book) {
        bookRepository.save(book);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    public Book getById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book update(long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }
}
