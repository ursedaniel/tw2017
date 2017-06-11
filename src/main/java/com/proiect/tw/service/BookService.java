package com.proiect.tw.service;

import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.search.BookSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 6/11/2017.
 */
public interface BookService {

    Page<BookVO> getBooks(Pageable pageable);
    Page<BookVO> getBooks(BookSearchVO searchVO, Pageable page);
    BookVO getBook(Integer id);

    void createBook(BookVO bookVO);
    void updateBook(Integer id, BookVO bookVO);
    void deleteBook(Integer id);
}
