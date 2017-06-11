package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Doc;
import com.proiect.tw.vo.search.DocSearchVO;
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
public class DocSpecification {

    public static Specification<Doc> searchByVO(DocSearchVO docSearchVO) {
        return new Specification<Doc>() {

            @Override
            public Predicate toPredicate(Root<Doc> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (docSearchVO.getTitle() != null) {
                    predicates.add(cb.like(root.get("name"), "%" + docSearchVO.getTitle().toLowerCase() + "%"));
                    if (docSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("name"), docSearchVO.getTitle().toLowerCase()));
                    }
                    if (!docSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("name"), "%" + docSearchVO.getTitle().toLowerCase() + "%"));
                    }
                    if (docSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("name"), docSearchVO.getTitle().toLowerCase() + "%"));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
