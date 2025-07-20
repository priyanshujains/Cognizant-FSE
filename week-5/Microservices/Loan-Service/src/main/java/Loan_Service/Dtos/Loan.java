package Loan_Service.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Loan {

    private String loanId;
    private String accountHolder;
    private double amount;
    private double interest;
}
