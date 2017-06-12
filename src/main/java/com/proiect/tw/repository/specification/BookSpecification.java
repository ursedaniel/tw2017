package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Book;
import com.proiect.tw.vo.search.BookSearchVO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JACK on 6/11/2017.
 */
public class BookSpecification {

    public static Specification<Book> searchByVO(BookSearchVO bookSearchVO) {
        return new Specification<Book>() {

            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (bookSearchVO.getTitle() != null) {
                    predicates.add(cb.like(root.get("title"), "%" + bookSearchVO.getTitle().toLowerCase() + "%"));
                    if (bookSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("title"), bookSearchVO.getTitle().toLowerCase()));
                    }
                    if (!bookSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("title"), "%" + bookSearchVO.getTitle().toLowerCase() + "%"));
                    }
                    if (bookSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("title"), bookSearchVO.getTitle().toLowerCase() + "%"));
                    }
                }
                if (bookSearchVO.getAuthor() != null) {
                    predicates.add(cb.like(root.get("author"), "%" + bookSearchVO.getAuthor().toLowerCase() + "%"));
                    if (bookSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("author"), bookSearchVO.getAuthor().toLowerCase()));
                    }
                    if (!bookSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("author"), "%" + bookSearchVO.getAuthor().toLowerCase() + "%"));
                    }
                    if (bookSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("author"), bookSearchVO.getAuthor().toLowerCase() + "%"));
                    }
                }
                if (bookSearchVO.getLocation() != null) {
                    predicates.add(cb.like(root.get("location"), "%" + bookSearchVO.getLocation().toLowerCase() + "%"));
                    if (bookSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("location"), bookSearchVO.getLocation().toLowerCase()));
                    }
                    if (!bookSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("location"), "%" + bookSearchVO.getLocation().toLowerCase() + "%"));
                    }
                    if (bookSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("location"), bookSearchVO.getLocation().toLowerCase() + "%"));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
