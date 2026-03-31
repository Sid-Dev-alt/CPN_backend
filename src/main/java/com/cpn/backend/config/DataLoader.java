package com.cpn.backend.config;

import com.cpn.backend.models.*;
import com.cpn.backend.repository.MasalaProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataLoader {


    @Bean
    public CommandLineRunner loadData(MasalaProductRepository repository) {
        return args -> {

            if (repository.count() > 0) {
                System.out.println("Data already exists, skipping seed.");
                return;
            }

            // ================= PRODUCT 1 =================
            MasalaProduct p1 = new MasalaProduct();
            p1.setName("Guntur chilli powder");
            p1.setSubtitle("Authentic Guntur Red Chilli powder");
            p1.setDescription("Spicy, authentic Guntur red chilli powder for everyday cooking");
            p1.setImageUrl("/img/sec3.jpg");

            TasteProfile t1 = new TasteProfile();
            t1.setSweet(1);
            t1.setSour(0);
            t1.setTangy(0);
            t1.setSpice(4);
            p1.setTasteProfile(t1);

            // ✅ FIXED idealWith
            ProductIdealWith p1_i1 = new ProductIdealWith();
            p1_i1.setMealType(IdealWith.BREAKFAST);

            ProductIdealWith p1_i2 = new ProductIdealWith();
            p1_i2.setMealType(IdealWith.LUNCH_DINNER);

            p1.setIdealWith(Set.of(p1_i1, p1_i2));

            ProductVariant v1_1 = new ProductVariant();
            v1_1.setWeightLabel("500g");
            v1_1.setPrice(330.0);
            v1_1.setDiscountedPrice(330.0);

            ProductVariant v1_2 = new ProductVariant();
            v1_2.setWeightLabel("250g");
            v1_2.setPrice(165.0);
            v1_2.setDiscountedPrice(165.0);

            p1.setVariants(Set.of(v1_1, v1_2));

            // ================= PRODUCT 2 =================
            MasalaProduct p2 = new MasalaProduct();
            p2.setName("Bisibelebath Masala");
            p2.setSubtitle("Bisi bele bath powder");
            p2.setDescription("The right blend of spices for your perfect bisi bele bath");
            p2.setImageUrl("/img/sec2.png");

            TasteProfile t2 = new TasteProfile();
            t2.setSweet(1);
            t2.setSour(0);
            t2.setTangy(0);
            t2.setSpice(2);
            p2.setTasteProfile(t2);

            // ✅ FIXED idealWith
            ProductIdealWith p2_i1 = new ProductIdealWith();
            p2_i1.setMealType(IdealWith.BREAKFAST);

            ProductIdealWith p2_i2 = new ProductIdealWith();
            p2_i2.setMealType(IdealWith.LUNCH_DINNER);

            p2.setIdealWith(Set.of(p2_i1, p2_i2));

            ProductVariant v2_1 = new ProductVariant();
            v2_1.setWeightLabel("500g");
            v2_1.setPrice(350.0);
            v2_1.setDiscountedPrice(350.0);

            ProductVariant v2_2 = new ProductVariant();
            v2_2.setWeightLabel("250g");
            v2_2.setPrice(175.0);
            v2_2.setDiscountedPrice(175.0);

            p2.setVariants(Set.of(v2_1, v2_2));

            repository.saveAll(Arrays.asList(p1, p2));

            System.out.println("Dummy data explicitly loaded!");
        };
    }
}
