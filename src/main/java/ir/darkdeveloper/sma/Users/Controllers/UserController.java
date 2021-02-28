package ir.darkdeveloper.sma.Users.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.darkdeveloper.sma.Configs.Security.JWT.JwtAuth;
import ir.darkdeveloper.sma.Users.Models.UserModel;
import ir.darkdeveloper.sma.Users.Service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup/")
    public ResponseEntity<?> signUpUser(@ModelAttribute UserModel user, HttpServletResponse response) {
        return userService.signUpUser(user, response);
    }

    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody JwtAuth model, HttpServletResponse response) {
        return userService.loginUser(model, response);
    }

    @PostMapping("/update/")
    public UserModel updateUser(@ModelAttribute UserModel user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(@RequestBody UserModel user) {
        return userService.deleteUser(user);
    }

    @GetMapping("/")
    public Page<UserModel> allUsers(Pageable pageable) {
        return userService.allUsers(pageable);
    }
}
