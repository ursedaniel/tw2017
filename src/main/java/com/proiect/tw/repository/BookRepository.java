package com.proiect.tw.repository;

import com.proiect.tw.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JACK on 6/11/2017.
 */
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    @Query("select b from Book b where b.course_id = ?1")
    Page<Book> getBooksByQuery(Integer course_id, Pageable pageable);
}
