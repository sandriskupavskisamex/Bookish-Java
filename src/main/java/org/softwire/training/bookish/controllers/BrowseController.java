package org.softwire.training.bookish.controllers;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.BrowsePageModel;
import org.softwire.training.bookish.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/browse")
public class BrowseController {

    private final BooksService booksService;

    @Autowired
    public BrowseController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("")
    ModelAndView browse() {

        List<Book> books = booksService.getAllBooks();
        BrowsePageModel browsePageModel = new BrowsePageModel();
        browsePageModel.setBooks(books);

        return new ModelAndView("browse", "model", browsePageModel);
    }

}

