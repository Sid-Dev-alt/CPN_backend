package com.cpn.backend.repository;

import com.cpn.backend.models.IdealWith;
import com.cpn.backend.models.MasalaProduct;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import jakarta.persistence.criteria.Join;

import java.util.List;

public class ProductSpecification {

    public static Specification<MasalaProduct> filterProducts(
            String keyword, 
            Integer maxSweet, Integer maxSour, 
            Integer maxTangy, Integer maxSpice, 
            List<IdealWith> idealWithList) {
            
        Specification<MasalaProduct> spec = (root, query, cb) -> cb.conjunction();
        
        if (StringUtils.hasText(keyword)) {
            spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("name")), "%" + keyword.toLowerCase() + "%"));
        }
        
        if (maxSweet != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("tasteProfile").get("sweet"), maxSweet));
        }
        if (maxSour != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("tasteProfile").get("sour"), maxSour));
        }
        if (maxTangy != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("tasteProfile").get("tangy"), maxTangy));
        }
        if (maxSpice != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("tasteProfile").get("spice"), maxSpice));
        }
        
        if (idealWithList != null && !idealWithList.isEmpty()) {
            spec = spec.and((root, query, cb) -> {
                Join<MasalaProduct, IdealWith> idealWithJoin = root.join("idealWith");
                return idealWithJoin.in(idealWithList);
            });
        }

        return spec;
    }
}
