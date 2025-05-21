package org.stajkovic.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.stajkovic.app.models.Account;
import org.stajkovic.app.models.TransferRequest;
import org.stajkovic.app.services.TransferService;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;

    }

    @PostMapping("/transfer")
    public void transferFunds(@RequestBody TransferRequest transferRequest){
        transferService.transferMoney(transferRequest.getSenderId(),transferRequest.getSenderId(),transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> fetchAccounts(){
        return transferService.getAllAccounts();
    }

}
