package com.proiect.tw.repository.specification;

import com.proiect.tw.model.Gossip;
import com.proiect.tw.vo.search.GossipSearchVO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JACK on 6/12/2017.
 */
public class GossipSpecification {


    public static Specification<Gossip> searchByVO(GossipSearchVO docSearchVO) {
        return new Specification<Gossip>() {

            @Override
            public Predicate toPredicate(Root<Gossip> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (docSearchVO.getTitle() != null) {
                    predicates.add(cb.like(root.get("title"), "%" + docSearchVO.getTitle().toLowerCase() + "%"));
                    if (docSearchVO.isMatch()) {
                        predicates.add(cb.equal(root.get("title"), docSearchVO.getTitle().toLowerCase()));
                    }
                    if (!docSearchVO.isMatch()) {
                        predicates.add(cb.like(root.get("title"), "%" + docSearchVO.getTitle().toLowerCase() + "%"));
                    }
                    if (docSearchVO.isStartWith()) {
                        predicates.add(cb.like(root.get("title"), docSearchVO.getTitle().toLowerCase() + "%"));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
