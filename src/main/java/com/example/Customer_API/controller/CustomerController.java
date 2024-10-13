package com.example.Customer_API.controller;

import com.example.Customer_API.dto.Login;
import com.example.Customer_API.dto.Register;
import com.example.Customer_API.dto.ResetPassword;
import com.example.Customer_API.dto.RestResponse;
import com.example.Customer_API.service.ForgotPwdService;
import com.example.Customer_API.service.LoginService;
import com.example.Customer_API.service.RegisterService;
import com.example.Customer_API.service.ResetPwdService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private LoginService loginService;
    private ForgotPwdService forgotPwdService;

    private RegisterService registerService;

    private ResetPwdService resetPwdService;
    public CustomerController(LoginService loginService,ForgotPwdService forgotPwdService,RegisterService registerService,ResetPwdService resetPwdService){
        this.loginService=loginService;
        this.forgotPwdService=forgotPwdService;
        this.registerService=registerService;
        this.resetPwdService=resetPwdService;
    }
    @PostMapping("/loginHandle")
    @ResponseBody
    public Login loginHandle(@RequestBody Login login){
        System.out.println("Calling login controller");
        System.out.println(login.getEmail()+" "+login.getPassword());
        return loginService.loginHandle(login);
    }

    @PostMapping("/forgotPwdHandle/{email}")
    public Boolean forgotPasswordHandle(@PathVariable String email) throws MessagingException, IOException {
        Boolean flag=false;
        System.out.println("Calling forgot password controller with email: " + email);
        if(forgotPwdService.checkEmailValid(email)) {
            flag = forgotPwdService.sendMail(email);
        }
        return flag;
    }

    @PostMapping("/register")
    public String register(@RequestBody Register register){
        System.out.println(register);
        System.out.println("Calling register customer controller");
        return registerService.register(register);
    }

    @PostMapping("/reset-pwd/{email}")
    public String resetPassword(@RequestBody ResetPassword resetPassword,@PathVariable String email){

        System.out.println(resetPassword);
        System.out.println("Calling reset password customer controller");
        return resetPwdService.resetPassword(resetPassword,email);

    }
}
