package com.careergps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerCategoryDTO {

    private Long categoryId;
    private String name;
    private String description;
}
