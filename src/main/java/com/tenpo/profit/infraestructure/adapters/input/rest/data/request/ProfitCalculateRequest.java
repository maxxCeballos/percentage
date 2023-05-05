package com.tenpo.profit.infraestructure.adapters.input.rest.data.request;

public class ProfitCalculateRequest {

    private int operatorX;
    private int operatorY;

    public ProfitCalculateRequest(int operatorX, int operatorY) {
        this.operatorX = operatorX;
        this.operatorY = operatorY;
    }

    public int getOperatorX() {
        return operatorX;
    }

    public int getOperatorY() {
        return operatorY;
    }
}
