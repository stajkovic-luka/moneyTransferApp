package org.stajkovic.app.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.stajkovic.app.models.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account a = new Account();
        a.setId(rs.getInt("id"));
        a.setName(rs.getString("name"));
        a.setAmount(rs.getBigDecimal("amount"));

        return a;
    }
}
