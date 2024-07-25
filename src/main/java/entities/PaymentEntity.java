package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="date")
    private Date date;
    @Column(name="amount")
    private double amount;
    @Column(name="recepient_id")
    private int recipient;
    @Column(name="message")
    private String message;

    public PaymentEntity(){}

    public PaymentEntity(Date date, double amount, int recipient, String message) {
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
