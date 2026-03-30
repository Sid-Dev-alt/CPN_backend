package com.cpn.backend.repository;

import com.cpn.backend.models.IdealWith;
import com.cpn.backend.models.MasalaProduct;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import jakarta.persistence.criteria.Join;

import jakarta.persistence.criteria.JoinType;

import java.util.List;

public class ProductSpecification {

    public static Specification<MasalaProduct> filterProducts(
            String keyword, 
            Integer maxSweet, Integer maxSour, 
            Integer maxTangy, Integer maxSpice, 
            List<IdealWith> idealWithList) {
            
        return (root, query, cb) -> {
            if (query != null && !Long.class.equals(query.getResultType()) && !long.class.equals(query.getResultType())) {
                root.fetch("variants", JoinType.LEFT);
                root.fetch("idealWith", JoinType.LEFT);
            }
            if (query != null) query.distinct(true);
            
            Specification<MasalaProduct> spec = (r, q, c) -> c.conjunction();
            
            if (StringUtils.hasText(keyword)) {
                spec = spec.and((r, q, c) -> c.like(c.lower(r.get("name")), "%" + keyword.toLowerCase() + "%"));
            }
            
            if (maxSweet != null) {
                spec = spec.and((r, q, c) -> c.lessThanOrEqualTo(r.get("tasteProfile").get("sweet"), maxSweet));
            }
            if (maxSour != null) {
                spec = spec.and((r, q, c) -> c.lessThanOrEqualTo(r.get("tasteProfile").get("sour"), maxSour));
            }
            if (maxTangy != null) {
                spec = spec.and((r, q, c) -> c.lessThanOrEqualTo(r.get("tasteProfile").get("tangy"), maxTangy));
            }
            if (maxSpice != null) {
                spec = spec.and((r, q, c) -> c.lessThanOrEqualTo(r.get("tasteProfile").get("spice"), maxSpice));
            }
            
            if (idealWithList != null && !idealWithList.isEmpty()) {
                spec = spec.and((r, q, c) -> {
                    Join<MasalaProduct, IdealWith> idealWithJoin = r.join("idealWith");
                    return idealWithJoin.in(idealWithList);
                });
            }

            return spec.toPredicate(root, query, cb);
        };
    }
}
