package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Book;
import com.proiect.tw.vo.BookVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/11/2017.
 */
@Service
public class BookConvertor {

    public BookVO toVO(Book book){
        BookVO bookVO = new BookVO();

        bookVO.setId(book.getId());
        bookVO.setCourse_id(book.getCourse_id());
        bookVO.setTitle(book.getTitle());
        bookVO.setAuthor(book.getAuthor());
        bookVO.setLocation(book.getLocation());

        return bookVO;
    }

    public Book fromVO(BookVO bookVO){
        Book book = new Book();

        book.setId(bookVO.getId());
        book.setCourse_id(bookVO.getCourse_id());
        book.setTitle(bookVO.getTitle());
        book.setAuthor(bookVO.getAuthor());
        book.setLocation(bookVO.getLocation());

        return book;
    }
}
