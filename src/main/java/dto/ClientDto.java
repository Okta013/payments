package dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ClientDto {
    private int id;
    private String name;
    private String phone;
    private double balancing;
}
