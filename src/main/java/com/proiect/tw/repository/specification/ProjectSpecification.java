package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Project;
import com.proiect.tw.vo.search.ProjectSearchVO;
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
public class ProjectSpecification {

    public static Specification<Project> searchByVO(ProjectSearchVO projectSearchVO) {
        return new Specification<Project>() {

            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (projectSearchVO.getTitle() != null) {
                    predicates.add(cb.like(root.get("title"), "%" + projectSearchVO.getTitle().toLowerCase() + "%"));
                    if (projectSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("title"), projectSearchVO.getTitle().toLowerCase()));
                    }
                    if (!projectSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("title"), "%" + projectSearchVO.getTitle().toLowerCase() + "%"));
                    }
                    if (projectSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("title"), projectSearchVO.getTitle().toLowerCase() + "%"));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
