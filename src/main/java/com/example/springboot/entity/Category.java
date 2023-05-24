package com.example.springboot.entity;


import lombok.Data;

@Data
public class Category {
    private int id;
    private String categoryName;
    // 话题权重 排序时使用
    private int weight;
}
