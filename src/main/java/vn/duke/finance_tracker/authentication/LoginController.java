package vn.duke.finance_tracker.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class LoginController {
    @PostMapping("/login")
    String login() {
        return "login";
    }
}
