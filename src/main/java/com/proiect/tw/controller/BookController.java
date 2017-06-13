package com.proiect.tw.controller;

import com.proiect.tw.service.BookService;
import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.search.BookSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 6/11/2017.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //GET ALL BOOKS
    @RequestMapping("/books")
    public Page<BookVO> getBooks(Pageable pageable) {
        return bookService.getBooks(pageable);
    }

    //GET ALL BOOKS BY TITLE, AUTHOR OR LOCATION
    @RequestMapping(value = "/books/search")
    public Page<BookVO> searchBooks(@ModelAttribute BookSearchVO searchVO, Pageable page) {
        return bookService.getBooks(searchVO, page);
    }

    //GET BOOK BY ID
    @RequestMapping("/books/{id}")
    public BookVO getBook(@PathVariable("id") Integer id) {
        return bookService.getBook(id);
    }

    //CREATE A NEW BOOK
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void createBook(@RequestBody BookVO bookVO) {
        bookService.createBook(bookVO);
    }

    //UPDATE AN EXISTING BOOK
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public void updateBook(@PathVariable("id") Integer id, @RequestBody BookVO bookVO) {
        bookService.updateBook(id, bookVO);
    }

    //DELETE A BOOK
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") Integer id) {

        bookService.deleteBook(id);
    }
}
