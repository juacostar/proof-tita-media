package com.example.punto8.RequestModel;

public class RequestPay {
    private Double amount;

    private Integer dues;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDues() {
        return dues;
    }

    public void setDues(Integer dues) {
        this.dues = dues;
    }
}
