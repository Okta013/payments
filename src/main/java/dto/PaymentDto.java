package dto;

import lombok.Data;
import java.util.Date;

@Data
public class PaymentDto {
    private int id;
    private Date date;
    private double amount;
    private int recipient;
    private String message;
}
