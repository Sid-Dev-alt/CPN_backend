package com.cpn.backend.repository;

import com.cpn.backend.models.MasalaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MasalaProductRepository extends 
        JpaRepository<MasalaProduct, Long>, 
        JpaSpecificationExecutor<MasalaProduct> {
}
