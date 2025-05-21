# Spring Money Transfer App

A minimal application for simulating money transfers between user accounts, developed to practice Spring Boot and working with a database using `JdbcTemplate`. The project also aims to reinforce good coding standards and clean architecture.

## Technologies Used

- Java 17  
- Spring Boot 3.4  
- Spring Web  
- Spring JDBC (`JdbcTemplate`)  
- MySQL  
- Maven

## Endpoints

### `GET /accounts`
Returns a list of user accounts including their current fund balances.

### `POST /transfer`
Enables transferring funds between user accounts.

#### Example JSON request:
```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 100.00
}
