package com.cpn.backend.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class TasteProfile {
    private Integer sweet = 0;
    private Integer sour = 0;
    private Integer tangy = 0;
    private Integer spice = 0;
}
