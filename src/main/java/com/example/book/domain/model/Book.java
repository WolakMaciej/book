package com.example.book.domain.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Transactional
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column
    @NotNull
    String name;
    @Column
    String description;

    public Book(@NotNull String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Book(){
        super();
}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


