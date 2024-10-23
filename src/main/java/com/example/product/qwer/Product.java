package com.example.product.qwer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
  private int id;
  private String name;
  private String description;
  private int price;

  public Product(int id, String name, String description, int price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
