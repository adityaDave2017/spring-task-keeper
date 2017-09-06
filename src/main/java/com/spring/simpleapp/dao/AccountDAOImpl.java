package com.spring.simpleapp.dao;


import com.spring.simpleapp.model.Account;
import com.spring.simpleapp.model.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;


class AccountDAOImpl implements AccountDAO {

    private SessionFactory sessionFactory;

    public AccountDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Account getAccount(Login login) throws NoResultException {
        Session session = sessionFactory.openSession();
        Query namedQuery = session.getNamedQuery("accountForUserName");
        namedQuery.setParameter("username", login.getUsername());
        namedQuery.setParameter("password", login.getPassword());
        List<Account> accounts = (List<Account>) namedQuery.list();
        session.close();
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts.get(0);
    }

    @Override
    public Integer saveAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(account);
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public Boolean deleteAccount(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("deleteUser");
        query.setParameter("username", username);
        Integer id = query.executeUpdate();
        transaction.commit();
        session.close();
        return id != 0;
    }

}