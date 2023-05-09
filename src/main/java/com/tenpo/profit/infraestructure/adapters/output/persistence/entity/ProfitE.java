package com.tenpo.profit.infraestructure.adapters.output.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profit")
public class ProfitE {

    @Id
    private String id;
    private int operatorX;
    private int operatorY;
    private int percentage;
    private float total;
}
