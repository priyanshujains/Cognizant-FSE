package Account_Service.Controller;

import Account_Service.Dtos.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/acc")
public class AccountController {

    @GetMapping
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("ACC123", "Priyanshu Jain", 50000));
        accounts.add(new Account("ACC456", "Amit Sharma", 76000));
        accounts.add(new Account("ACC789", "Sneha Verma", 32000));
        return accounts;
    }
}
