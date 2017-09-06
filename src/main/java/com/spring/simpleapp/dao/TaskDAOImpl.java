package com.spring.simpleapp.dao;

import com.spring.simpleapp.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class TaskDAOImpl implements TaskDAO {

    private SessionFactory sessionFactory;

    public TaskDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer saveTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(task);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<Task> listTaskByAccount(Integer accountId) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("taskForUser");
        query.setParameter("accountId", accountId);
        List<Task> taskList = (List<Task>) query.list();
        session.close();
        return taskList;
    }

    @Override
    public void updateTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(task);
        transaction.commit();
        session.close();
    }

    @Override
    public Integer deleteTask(Integer taskId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("deleteTask");
        query.setParameter("taskId", taskId);
        Integer id = query.executeUpdate();
        transaction.commit();
        session.close();
        return id;
    }

}