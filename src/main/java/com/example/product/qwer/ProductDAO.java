package com.example.product.qwer;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class ProductDAO {
  //driver
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3305/db?serverTimezone=Asia/Seoul";
  //db connection
  Connection conn;
  //Statement
  PreparedStatement pstmt;
  //sql

  public void open(){
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL,"root","1234");
    } catch (Exception e) {
        e.printStackTrace();
        log.error("데이터베이스 연결 실패: {}", e.getMessage());
    } finally {
      if(conn != null){
        log.info("데이터베이스 접속 완료...");
      } else {
        log.error("데이터베이스 연결이 설정되지 않았습니다.");
      }
    }
  }

  public void close(){
    try {
      if(pstmt!=null) pstmt.close();
      if(conn!=null) conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      log.info("데이터베이스 종료");
    }
  }

  public void insert(Product p){
    String sql = "INSERT INTO products(name, price, description) VALUES(?,?,?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, p.getName());
      pstmt.setInt(2, p.getPrice());
      pstmt.setString(3, p.getDescription());

      int result = pstmt.executeUpdate();
      if(result > 0){
        log.info("Product insert success: {}", p.getName());
      } else {
        log.error("Product insert failed: {}", p.getName());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      log.error("Product insert error: {}", e.getMessage());
    } finally {
      if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
    }
  }
}
