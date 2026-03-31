package com.cpn.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductIdealWith {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IdealWith mealType;
}