package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;
    private double amount;
    private int recipient;
    private String message;

    protected Payment(){}

    public Payment(Date date, double amount, int recipient, String message) {
        this.date = date;
        this.amount = amount;
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", amount: " + amount;
    }
}
