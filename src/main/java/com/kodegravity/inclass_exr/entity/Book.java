package com.kodegravity.inclass_exr.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data // required by Jackson to serialize the return data
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int stock;
    private String isbn;

    @Column(name = "is_available")
    private boolean isAvailable;
    private BigDecimal price;

    public Book(bookBuilder b) {
        this.id = b.id;
        this.name = b.name;
        this.author = b.author;
        this.stock = b.stock;
        this.isbn = b.isbn;
        this.isAvailable = b.isAvailable;
        this.price = b.price;
    }

    public static class bookBuilder{
        private int id;
        private String name;
        private String author;
        private int stock;
        private String isbn;
        private boolean isAvailable;
        private BigDecimal price;

        public bookBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public bookBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public bookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }
        public bookBuilder setStock(int stock) {
            this.stock = stock;
            return this;
        }
        public bookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }
        public bookBuilder setIsAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }
        public bookBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Book build(){
            return new Book(this);
        }

    }
}
