package com.example.product.qwer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/products")
public class ProductController extends HttpServlet {
  ProductDAO service;


}
