package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="client")
public class ClientEntity {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="balance")
    private double balancing;

    public ClientEntity() {}

    public ClientEntity(String name, String phone, double balancing) {
        this.name = name;
        this.phone = phone;
        this.balancing = balancing;
    }

    @Override
    public String toString() {
        return name;
    }
}