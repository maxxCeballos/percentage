//package com.tenpo.profit.infraestructure.adapters.output.persistence.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//import java.util.UUID;
//
//@Entity
//public class ProfitE {
//    @Id
//    private String id;
//    private int operatorX;
//    private int operatorY;
//    private float total;
//
//    public ProfitE(){};
//
//    public ProfitE(String id, int operatorX, int operatorY, float total) {
//        this.id = id;
//        this.operatorX = operatorX;
//        this.operatorY = operatorY;
//        this.total = total;
//    }
//
//    public ProfitE(int operatorX, int operatorY, float total) {
//        this(UUID.randomUUID().toString(), operatorX, operatorY, total);
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public int getOperatorX() {
//        return operatorX;
//    }
//
//    public int getOperatorY() {
//        return operatorY;
//    }
//
//    public float getTotal() {
//        return total;
//    }
//}
