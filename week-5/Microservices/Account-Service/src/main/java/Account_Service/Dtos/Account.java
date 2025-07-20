package Account_Service.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private String accountNumber;
    private String accountHolder;
    private double balance;
}
