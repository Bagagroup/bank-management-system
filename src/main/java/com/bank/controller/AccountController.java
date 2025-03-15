package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "accounts"; // Make sure you have accounts.html in resources/templates
    }
}