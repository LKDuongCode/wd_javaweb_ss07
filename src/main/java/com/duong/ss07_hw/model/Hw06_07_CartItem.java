package com.duong.ss07_hw.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hw06_07_CartItem {
    private Hw06_07_Product product;
    private int quantity;

}
