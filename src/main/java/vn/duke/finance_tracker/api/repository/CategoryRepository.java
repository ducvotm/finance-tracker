package vn.duke.finance_tracker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.duke.finance_tracker.api.entity.Account;
import vn.duke.finance_tracker.api.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
