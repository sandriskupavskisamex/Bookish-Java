package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService extends DatabaseService {

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO books (title, author, isbn, release_date) VALUES (:title, :author, :isbn, :release_date)")
                        .bind("title", book.getTitle())
                        .bind("author", book.getAuthor())
                        .bind("isbn", book.getIsbn())
                        .bind("release_date", book.getRelease_date())
                        .execute()
        );
    }

    public List<Book> searchBooks(String searchbar) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books WHERE title LIKE '%" + searchbar + "%'")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void deleteBook(String isbn) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE isbn = :isbn")
                        .bind("isbn", isbn)
                        .execute()
        );
    }

    public void editBook(int bookId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE books WHERE id = :id")
                .bind("Id", bookId)
                .execute()
                );
    }
}
