package vn.duke.finance_tracker.common.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.duke.finance_tracker.api.entity.Account;
import vn.duke.finance_tracker.api.entity.Category;
import vn.duke.finance_tracker.api.repository.AccountRepository;
import vn.duke.finance_tracker.api.repository.CategoryRepository;
import vn.duke.finance_tracker.authentication.enity.User;
import vn.duke.finance_tracker.authentication.repository.UserRepository;
import vn.duke.finance_tracker.common.enums.TypeEnum;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadTestData(
            UserRepository userRepository,     // Add user repository
            AccountRepository accountRepository,
            CategoryRepository categoryRepository) {

        return args -> {
            System.out.println("💾 Creating test data...");

            // Step 1: Create a test user first
            long testUserId = createTestUser(userRepository);

            // Step 2: Then create accounts and categories with that user ID
            createAccounts(accountRepository, testUserId);
            createCategories(categoryRepository, testUserId);

            System.out.println("✅ Test data created successfully!");
        };
    }

    // New method to create a test user
    private long createTestUser(UserRepository repository) {
        // Check if we already have users
        if (repository.count() > 0) {
            // If users exist, just return the ID of the first user
            return repository.findAll().get(0).getId();
        }

        // Create a test user
        User testUser = User.builder()
                .username("testuser")
                .email("test@example.com")
                .password("password") // In a real app, you'd encrypt this
                .build();

        // Save the user and return its ID
        User savedUser = repository.save(testUser);
        System.out.println("👤 Created test user with ID: " + savedUser.getId());

        return savedUser.getId();
    }

    // Your existing methods, unchanged
    private void createAccounts(AccountRepository repository, long userId) {
        // Create a list of test accounts
        List<Account> accounts = List.of(
                Account.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Checking Account")
                        .type("CHECKING")
                        .balance(2500.00)
                        .build(),

                Account.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Savings Account")
                        .type("SAVINGS")
                        .balance(10000.00)
                        .build(),

                Account.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Credit Card")
                        .type("CREDIT_CARD")
                        .balance(-750.50)
                        .build()
        );

        // Save all accounts to the database
        repository.saveAll(accounts);
        System.out.println("📊 Added " + accounts.size() + " accounts");
    }

    private void createCategories(CategoryRepository repository, long userId) {
        // Create a list of test categories
        List<Category> categories = List.of(
                // Income categories
                Category.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Salary")
                        .type(TypeEnum.INCOME)
                        .build(),

                Category.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Freelance")
                        .type(TypeEnum.INCOME)
                        .build(),

                // Expense categories
                Category.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Food & Dining")
                        .type(TypeEnum.EXPENSE)
                        .build(),

                Category.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Housing")
                        .type(TypeEnum.EXPENSE)
                        .build(),

                Category.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Transportation")
                        .type(TypeEnum.EXPENSE)
                        .build(),

                Category.builder()
                        .userId(userId)  // Now using the real user ID
                        .name("Entertainment")
                        .type(TypeEnum.EXPENSE)
                        .build()
        );

        // Save all categories to the database
        repository.saveAll(categories);
        System.out.println("🏷️ Added " + categories.size() + " categories");
    }
}
