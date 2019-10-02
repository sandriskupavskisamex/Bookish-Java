package org.softwire.training.bookish.models.database;

import java.util.Date;
import java.util.List;

public class Book {


    public String title;
    public String author;
    public Date release_date;
    public String isbn;
    public List<Book> books;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(String title, String author, Date release_date, String isbn, List<Book> books) {
        this.title = title;
        this.author = author;
        this.release_date = release_date;
        this.isbn = isbn;
        this.books = books;
    }

    public Book(){}

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
