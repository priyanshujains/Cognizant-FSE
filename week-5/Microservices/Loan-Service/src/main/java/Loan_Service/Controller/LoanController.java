package Loan_Service.Controller;

import Loan_Service.Dtos.Account;
import Loan_Service.Dtos.Loan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/loan")
public class LoanController {

    private final RestTemplate restTemplate;

    public LoanController(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan("LN001", "Priyanshu Jain", 250000, 7.5));
        loans.add(new Loan("LN002", "Amit Sharma", 100000, 6.8));
        return loans;
    }



    @GetMapping("/accounts")
    public List<Account> getAccountsFromAccountService() {
        ResponseEntity<List<Account>> response = restTemplate.exchange(
                "http://Karmbhumi:Account-Service/api/acc",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Account>>() {}
        );
        return response.getBody();
    }


}
