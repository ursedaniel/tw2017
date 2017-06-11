package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Book;
import com.proiect.tw.repository.BookRepository;
import com.proiect.tw.repository.specification.BookSpecification;
import com.proiect.tw.service.BookService;
import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.convertor.BookConvertor;
import com.proiect.tw.vo.search.BookSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/11/2017.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookConvertor bookConvertor;

    private Page<BookVO> convertToVO(Page<Book> page) {

        return page.map(bookConvertor::toVO);
    }

    @Override
    public Page<BookVO> getBooks(Pageable pageable) {

        return convertToVO(bookRepository.findAll(pageable));
    }

    @Override
    public Page<BookVO> getBooks(BookSearchVO searchVO, Pageable pageable) {

        return convertToVO(bookRepository.findAll(BookSpecification.searchByVO(searchVO), pageable));
    }

    @Override
    public BookVO getBook(Integer id) {

        Book book = bookRepository.findOne(id);

        if (book == null) {
            throw new BusinessException( "Cartea cu id-ul " + id + " nu exista in baza de date! ");
        }

        return bookConvertor.toVO(book);
    }

    @Override
    public void createBook(BookVO bookVO) {

        if (bookRepository.findOne(bookVO.getId()) != null) {
            throw new BusinessException(" Cartea cu id-ul " + bookVO.getId() + " exista deja in baza de date! ");
        }
        else {
            bookRepository.save(bookConvertor.fromVO(bookVO));
        }
    }

    @Override
    public void updateBook(Integer id, BookVO bookVO) {

        if (bookRepository.findOne(id) == null) {
            throw new BusinessException(" Cartea cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            bookRepository.save(bookConvertor.fromVO(bookVO));
        }
    }

    @Override
    public void deleteBook(Integer id) {

        bookRepository.delete(id);
    }
}
