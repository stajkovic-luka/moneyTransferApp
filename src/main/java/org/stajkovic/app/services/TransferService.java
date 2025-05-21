package org.stajkovic.app.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.stajkovic.app.models.Account;
import org.stajkovic.app.repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    public final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
        Account sender =accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        // Sender amount in account decreases
        accountRepository.changeAmount(receiver.getId(), receiver.getAmount().add(amount));
        // Receiver amount in account increases
        accountRepository.changeAmount(sender.getId(), sender.getAmount().subtract(amount));
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAcounts();
    }
}
