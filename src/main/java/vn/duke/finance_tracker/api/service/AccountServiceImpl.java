import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.duke.finance_tracker.api.entity.Account;
import vn.duke.finance_tracker.api.service.AccountService;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountDtoOut create(AccountDtoIn accountDtoIn) {
        Account account = accountRepository
    }

    @Override
    public AccountDtoOut update(Long id, AccountDtoIn accountDtoIn);

    @Override
    public AccountDtoOut get(Long id);

    @Override
    public void delete(Long id);

}
