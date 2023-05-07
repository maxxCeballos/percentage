package com.tenpo.profit.domain.model;

import java.util.UUID;

public class Profit {

    private final String id;
    private int operatorX;
    private int operatorY;
    private int percentage;
    private float total;

    public Profit(String id, int operatorX, int operatorY, int percentage) {
        this.id = id;
        this.operatorX = operatorX;
        this.operatorY = operatorY;
        this.percentage = percentage;
        this.total = calculateTotal();
    }

    public Profit(int operatorX, int operatorY, int percentage) {
        this(UUID.randomUUID().toString(), operatorX, operatorY, percentage);
    }

    private float calculateTotal() {
        var operatorsSum = this.operatorX + this.operatorY;
        var percentageApplied =  operatorsSum * (float) this.percentage/100;

        return operatorsSum + percentageApplied;
    }

    public String getId() {
        return id;
    }

    public int getOperatorX() {
        return operatorX;
    }

    public int getOperatorY() {
        return operatorY;
    }

    public float getTotal() {
        return total;
    }
}
