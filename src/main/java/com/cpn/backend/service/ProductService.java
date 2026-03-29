package com.cpn.backend.service;

import com.cpn.backend.models.IdealWith;
import com.cpn.backend.models.MasalaProduct;
import com.cpn.backend.repository.MasalaProductRepository;
import com.cpn.backend.repository.ProductSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final MasalaProductRepository repository;

    public ProductService(MasalaProductRepository repository) {
        this.repository = repository;
    }

    public List<MasalaProduct> getFilteredProducts(
            String keyword, 
            Integer sweet, Integer sour, Integer tangy, Integer spice, 
            List<IdealWith> idealWithList) {
        
        return repository.findAll(ProductSpecification.filterProducts(
                keyword, sweet, sour, tangy, spice, idealWithList
        ));
    }
    
    public MasalaProduct saveProduct(MasalaProduct product) {
        return repository.save(product);
    }
    
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
