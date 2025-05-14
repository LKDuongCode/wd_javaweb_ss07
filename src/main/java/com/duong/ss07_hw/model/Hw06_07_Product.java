package com.duong.ss07_hw.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hw06_07_Product  {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private String image;
}