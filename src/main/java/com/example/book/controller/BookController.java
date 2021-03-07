package com.example.book.controller;

import com.example.book.domain.model.Book;
import com.example.book.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping( "/books/{id}")
    public String getBook(Model model, @PathVariable long id) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books")
    public String getAll(Model model){
        model.addAttribute("books", bookService.getBooks());
        return "books";
    }


    @PutMapping("/books/{id}")
    public String edit(@PathVariable long id,@RequestBody Book book){
        bookService.update(id, book);
        return "redirect:/book/"+book.getId();
    }


    @PostMapping("/books")
    public String create(@RequestBody Book book) {
        bookService.create(book);
        return "redirect:/book/" + book.getId();
    }

    @DeleteMapping ("/books/{id}")
    public String delete(@PathVariable long id){
        bookService.delete(id);
        return "redirect:/book";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("id", "name", "description");
    }


}
