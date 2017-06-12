package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Teacher;
import com.proiect.tw.vo.search.TeacherSearchVO;
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
public class TeacherSpecification {

    public static Specification<Teacher> searchByVO(TeacherSearchVO teacherSearchVO) {
        return new Specification<Teacher>() {

            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (teacherSearchVO.getName() != null) {
                    predicates.add(cb.like(root.get("name"), "%" + teacherSearchVO.getName().toLowerCase() + "%"));
                    if (teacherSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("name"), teacherSearchVO.getName().toLowerCase()));
                    }
                    if (!teacherSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("name"), "%" + teacherSearchVO.getName().toLowerCase() + "%"));
                    }
                    if (teacherSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("name"), teacherSearchVO.getName().toLowerCase() + "%"));
                    }
                }
                if (teacherSearchVO.getRating() != null) {
                    predicates.add(cb.equal(root.get("rating"), teacherSearchVO.getRating()));
                    if (teacherSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("rating"), teacherSearchVO.getRating()));
                    }
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
