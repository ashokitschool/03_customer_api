package com.example.Customer_API.controller;

import com.example.Customer_API.dto.Login;
import com.example.Customer_API.dto.Register;
import com.example.Customer_API.dto.ResetPassword;
import com.example.Customer_API.dto.RestResponse;
import com.example.Customer_API.service.ForgotPwdService;
import com.example.Customer_API.service.LoginService;
import com.example.Customer_API.service.RegisterService;
import com.example.Customer_API.service.ResetPwdService;
import org.springframework.web.bind.annotation.*;

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
    public Boolean forgotPasswordHandle(@PathVariable String email) {
        System.out.println("Calling forgot password controller with email: " + email);
        return forgotPwdService.sendMail(email);
    }

    @PostMapping("/register")
    @ResponseBody
    public Boolean register(@RequestBody Register register){
        System.out.println(register);
        System.out.println("Calling register customer controller");
        return registerService.register(register);
    }

    @PostMapping("/reset-pwd")
    public RestResponse resetPassword(@RequestBody ResetPassword resetPassword){
        RestResponse response=new RestResponse();
        System.out.println(resetPassword);
        System.out.println("Calling reset password customer controller");
        response.setResponse(resetPwdService.resetPassword(resetPassword));
        return response;
    }
}
