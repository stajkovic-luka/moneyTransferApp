package org.stajkovic.app.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.stajkovic.app.models.Account;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;

    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Account findAccountById(long id){
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount){
        String sql = "UPDATE account SET amount = ? WHERE id = ?";

        jdbc.update(sql,amount,id);
    }

    public List<Account> findAllAcounts(){
        String sql = "SELECT * FROM account";

        return jdbc.query(sql,new AccountRowMapper());
    }
}
