package com.example.book.domain.model;

import lombok.Data;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
@Data
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

/*    public long getId() {
        return id;
    }*/

}


