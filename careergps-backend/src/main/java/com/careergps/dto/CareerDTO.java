package com.careergps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerDTO {

    private Long careerId;
    private Long categoryId;
    private String name;
    private String description;
    private String workEnvironment;
    private String realityCheck;
}
