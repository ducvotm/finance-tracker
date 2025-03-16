import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.duke.finance_tracker.api.entity.Account;
import vn.duke.finance_tracker.api.service.AccountService;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountDtoOut create(AccountDtoIn accountDtoIn) {
        return null;
    }

    @Override
    public AccountDtoOut update(Long id, AccountDtoIn accountDtoIn) {
        return null;
    }

    @Override
    public AccountDtoOut get(Long id) {
        return null
    }

    @Override
    public void delete(Long id);

}
