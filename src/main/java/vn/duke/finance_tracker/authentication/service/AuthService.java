package vn.duke.finance_tracker.authentication.service;

import vn.duke.finance_tracker.authentication.dto.in.LoginRequest;
import vn.duke.finance_tracker.authentication.dto.in.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.duke.finance_tracker.authentication.dto.out.AuthResponse;
import vn.duke.finance_tracker.authentication.enity.User;
import vn.duke.finance_tracker.authentication.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Authenticate a user with credentials
     */
    @Transactional
    public AuthResponse login(LoginRequest request) {
        // Find user by username
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isEmpty()) {
            return AuthResponse.failure("Invalid username or password");
        }

        User user = userOpt.get();

        // Validate password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return AuthResponse.failure("Invalid username or password");
        }

        // Update last login time
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        return AuthResponse.success(user.getUsername(), user.getId());
    }

    /**
     * Register a new user
     */
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        // Check if username already exists
        if (userRepository.existsByUsername(request.getUsername())) {
            return AuthResponse.failure("Username is already taken");
        }

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return AuthResponse.failure("Email is already registered");
        }

        // Create and save new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setLastLogin(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return AuthResponse.success(savedUser.getUsername(), savedUser.getId());
    }
}
