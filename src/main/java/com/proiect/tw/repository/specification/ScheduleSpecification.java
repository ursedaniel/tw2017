package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Schedule;
import com.proiect.tw.vo.search.ScheduleSearchVO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JACK on 6/13/2017.
 */
public class ScheduleSpecification {

    public static Specification<Schedule> searchByVO(ScheduleSearchVO projectSearchVO) {
        return new Specification<Schedule>() {

            @Override
            public Predicate toPredicate(Root<Schedule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (projectSearchVO.getDay() != null) {
                    predicates.add(cb.like(root.get("day"), "%" + projectSearchVO.getDay().toLowerCase() + "%"));
                    if (projectSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("day"), projectSearchVO.getDay().toLowerCase()));
                    }
                    if (!projectSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("day"), "%" + projectSearchVO.getDay().toLowerCase() + "%"));
                    }
                    if (projectSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("day"), projectSearchVO.getDay().toLowerCase() + "%"));
                    }
                }
                if (projectSearchVO.getClass_room() != null) {
                    predicates.add(cb.like(root.get("class_room"), "%" + projectSearchVO.getClass_room().toLowerCase() + "%"));
                    if (projectSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("class_room"), projectSearchVO.getClass_room().toLowerCase()));
                    }
                    if (!projectSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("class_room"), "%" + projectSearchVO.getClass_room().toLowerCase() + "%"));
                    }
                    if (projectSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("class_room"), projectSearchVO.getClass_room().toLowerCase() + "%"));
                    }
                }
                if (projectSearchVO.getGroup() != null) {
                    predicates.add(cb.like(root.get("group"), "%" + projectSearchVO.getGroup().toLowerCase() + "%"));
                    if (projectSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("group"), projectSearchVO.getGroup().toLowerCase()));
                    }
                    if (!projectSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("group"), "%" + projectSearchVO.getGroup().toLowerCase() + "%"));
                    }
                    if (projectSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("group"), projectSearchVO.getGroup().toLowerCase() + "%"));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
