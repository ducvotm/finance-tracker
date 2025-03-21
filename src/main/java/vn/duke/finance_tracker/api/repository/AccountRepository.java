package vn.duke.finance_tracker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.duke.finance_tracker.api.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
