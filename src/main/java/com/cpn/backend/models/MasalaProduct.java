package com.cpn.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "masala_products")
@Data
public class MasalaProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String subtitle;
    private String description;
    
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String imageUrl;

    @Embedded
    private TasteProfile tasteProfile;

    @ElementCollection(targetClass = IdealWith.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "product_ideal_with", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "meal_type")
    private Set<IdealWith> idealWith;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<ProductVariant> variants;
}
