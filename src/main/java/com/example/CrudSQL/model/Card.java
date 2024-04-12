package com.example.CrudSQL.model;
import lombok.Data;
import lombok.Getter;

@Data
public class Card {
    private int Id;
    private String Name;
    private String Number;
    private String Type;
    private int Ccv;
    private int Status;
}
