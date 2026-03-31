package com.cpn.backend.models;

import jakarta.persistence.*;
import lombok.Data;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private Set<ProductIdealWith> idealWith;
    @OrderColumn(name = "id")


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Set<ProductVariant> variants;
}
