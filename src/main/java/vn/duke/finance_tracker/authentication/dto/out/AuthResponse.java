package vn.duke.finance_tracker.authentication.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private boolean success;
    private String message;
    private String username;
    private Long userId;

    // Static factory methods for common responses
    public static AuthResponse success(String username, Long userId) {
        return AuthResponse.builder()
                .success(true)
                .message("Authentication successful")
                .username(username)
                .userId(userId)
                .build();
    }

    public static AuthResponse failure(String message) {
        return AuthResponse.builder()
                .success(false)
                .message(message)
                .build();
    }
}
