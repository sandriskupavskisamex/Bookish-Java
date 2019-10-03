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
                handle.createUpdate("INSERT INTO books (title, author, isbn) VALUES (:title, :author, :isbn)")
                        .bind("title", book.getTitle())
                        .bind("author", book.getAuthor())
                        .bind("isbn", book.getIsbn())
                        .execute()
        );
    }

    public void deleteBook(int bookId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE id = :id")
                        .bind("id", bookId)
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
