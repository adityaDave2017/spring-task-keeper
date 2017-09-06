package com.spring.simpleapp.dao;


import com.spring.simpleapp.model.Account;
import com.spring.simpleapp.model.Login;

import java.util.List;


public interface AccountDAO {

    Account getAccount(Login login);

    Integer saveAccount(Account account);

    // Todo: Not used yet
    Boolean deleteAccount(String username);

    // Todo: Account update method

}