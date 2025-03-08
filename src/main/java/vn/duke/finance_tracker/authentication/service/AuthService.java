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

    @Transactional
    public AuthResponse login(LoginRequest request) {
        Optional<User> existedUserName = userRepository.findByUsername(request.getUsername());

        if (existedUserName.isEmpty()) {
            return AuthResponse.failure("Invalid username or password");
        }

        User existedUser = existedUserName.get();

        if (!passwordEncoder.matches(request.getPassword(), existedUser.getPassword())) {
            return AuthResponse.failure("Invalid username or password");
        }

        existedUser.setLastLogin(LocalDateTime.now());
        userRepository.save(existedUser);

        return AuthResponse.success(existedUser.getUsername(), existedUser.getId());
    }

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
        User newUser = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .roles("USER") //Default value
                .build();

        User savedUser = userRepository.save(newUser);

        return AuthResponse.success(savedUser.getUsername(), savedUser.getId());
    }
}
