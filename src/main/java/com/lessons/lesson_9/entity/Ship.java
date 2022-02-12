package com.lessons.lesson_9.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ships")
@Data
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column//("speed_1")
    private String speed1;
    @Column//("speed_2")
    private String speed2;
    @Column//("speed_3")
    private String speed3;
}

