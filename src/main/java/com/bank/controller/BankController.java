package com.bank.controller;

import com.bank.model.User;
import com.bank.service.UserService;
import com.bank.model.Customer;
import com.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BankController {  // ❌ Removed @RequestMapping("/bank")

    @Autowired
    private BankService bankService;

    @Autowired
    private UserService userService;


    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", bankService.getAllCustomers());
        return "customers";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute Customer customer) {
        bankService.createCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountId, @RequestParam double amount) {
        bankService.deposit(accountId, amount);
        return "redirect:/customers";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accountId, @RequestParam double amount) {
        bankService.withdraw(accountId, amount);
        return "redirect:/customers";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam String username, @RequestParam String password) {
        // Dummy authentication logic (Replace with real authentication later)
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/customers"; // Redirect to customers page after successful login
        }
        return "redirect:/login?error"; // Redirect back to login page if login fails
    }


//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";  // Loads "login.html" from templates/
//    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute User user) {
//        userService.registerUser(user);
//        return "redirect:/login";
//    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String role) {

        userService.registerUser(username, password, role);
        return "redirect:/login";
    }

}
