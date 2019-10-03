package org.softwire.training.bookish.models.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Book {


    public String title;
    public String author;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    public Date release_date;
    public String isbn;
    public List<Book> books;
    public int bookId;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(String title, String author, Date release_date, String isbn, List<Book> books, int bookId) {
        this.title = title;
        this.author = author;
        this.release_date = release_date;
        this.isbn = isbn;
        this.books = books;
        this.bookId = bookId;
    }

    public Book(){}

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public String getIsbn() {
        return isbn;
    }
}
