package com.tenpo.profit.infraestructure.adapters.input.rest.data.response;

import java.util.UUID;

public class ProfitQueryResponse {

    private final String id;
    private int operatorX;
    private int operatorY;
    private float total;

    public ProfitQueryResponse(String id, int operatorX, int operatorY, float total) {
        this.id = id;
        this.operatorX = operatorX;
        this.operatorY = operatorY;
        this.total = total;
    }

    public ProfitQueryResponse(int operatorX, int operatorY, float total) {
        this(UUID.randomUUID().toString(), operatorX, operatorY, total);
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
