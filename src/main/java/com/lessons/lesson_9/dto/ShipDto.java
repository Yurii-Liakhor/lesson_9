package com.lessons.lesson_9.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipDto {
    private Integer id;
    private String name;
    private String speed1;
    private String speed2;
    private String speed3;
}

