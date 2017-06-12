package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Course;
import com.proiect.tw.vo.search.CourseSearchVO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JACK on 4/21/2017.
 */
public class CourseSpecification {

    public static Specification<Course> searchByVO(CourseSearchVO courseSearchVO) {
        return new Specification<Course>() {

            @Override
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (courseSearchVO.getName() != null) {
                    predicates.add(cb.like(root.get("name"), "%" + courseSearchVO.getName().toLowerCase() + "%"));
                    if (courseSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("name"), courseSearchVO.getName().toLowerCase()));
                    }
                    if (!courseSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("name"), "%" + courseSearchVO.getName().toLowerCase() + "%"));
                    }
                    if (courseSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("name"), courseSearchVO.getName().toLowerCase() + "%"));
                    }
                }
                if (courseSearchVO.getYear() != null) {
                    predicates.add(cb.like(root.get("year"), "%" + courseSearchVO.getYear() + "%"));
                    if (courseSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("year"), courseSearchVO.getYear()));
                    }
                    if (!courseSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("year"), "%" + courseSearchVO.getYear() + "%"));
                    }
                    if (courseSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("year"), courseSearchVO.getYear() + "%"));
                    }
                }
                if (courseSearchVO.getMain_teacher() != null) {
                    predicates.add(cb.like(root.get("main_teacher"), "%" + courseSearchVO.getMain_teacher().toLowerCase() + "%"));
                    if (courseSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("main_teacher"), courseSearchVO.getMain_teacher().toLowerCase()));
                    }
                    if (!courseSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("main_teacher"), "%" + courseSearchVO.getMain_teacher().toLowerCase() + "%"));
                    }
                    if (courseSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("main_teacher"), courseSearchVO.getMain_teacher().toLowerCase() + "%"));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
