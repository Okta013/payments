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
    private int id;
    private String name;
    private String phone;
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