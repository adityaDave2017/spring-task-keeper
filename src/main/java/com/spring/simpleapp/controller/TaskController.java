package com.spring.simpleapp.controller;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import com.spring.simpleapp.dao.AccountDAO;
import com.spring.simpleapp.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simpleapp.model.Account;
import com.spring.simpleapp.model.Login;
import com.spring.simpleapp.model.Task;


@Controller
@RequestMapping(value = "/tasker")
public class TaskController {

    private static final String ACCOUNT = "USER_ACCOUNT";
    private static final String USERNAME = "USERNAME";
    private static final String TASK_LIST = "TASKS_LIST";

    @Autowired
    private TaskDAO taskDao;

    @Autowired
    private AccountDAO accountDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView goToHome() {
        return new ModelAndView("home", "command", new Login());
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processCredentials(@ModelAttribute("SpringWeb") Login login, HttpSession session, ModelMap model) {
        System.out.println(login.toString());
        // Add username and password verification here...
        Account account = accountDao.getAccount(login);
        if (account != null) {
            System.out.println(account.toString());
            session.setAttribute(ACCOUNT, account);
            System.out.println("MAX TIME INTERVAL ... " + session.getMaxInactiveInterval());
            return new ModelAndView("forward:tasks", "command", new Login());
        }
        return new ModelAndView("login-error", "command", new Login());
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelMap model) {
        return new ModelAndView("register", "command", new Account());
    }


    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("account") Account account, HttpSession session, ModelMap model) {
        // create account by adding details to database and show tasks page
        System.out.println(account);
        accountDao.saveAccount(account);
        session.setAttribute(ACCOUNT, account);
        return new ModelAndView("forward:tasks");
    }


    @RequestMapping(value = "/tasks")
    public ModelAndView getTasks(ModelMap model, HttpSession session) {
        // Retrieve tasks for the logged in user, if none are
        // present keep the list empty. Tasks sorted on isDone field.
        Account account = (Account) session.getAttribute(ACCOUNT);
        ArrayList<Task> tasks = (ArrayList<Task>) taskDao.listTaskByAccount(account.getAccountId());
        session.setAttribute(TASK_LIST, tasks);
        session.setAttribute(ACCOUNT, account);
        return new ModelAndView("tasks-list", "tasks", tasks);
    }


    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public ModelAndView addTask(@RequestParam("taskDesc") String taskDesc, HttpSession session) {
        // Add the task to the database to corresponding user account
        if (session.isNew()) {
            System.out.println("The session has been created newly...");
        }
        Account account = (Account) session.getAttribute(ACCOUNT);
        Task t = new Task();
//        t.setAccountId(account.getAccountId());
        t.setTaskDesc(taskDesc);
//        taskDao.saveTask(t);
        ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute(TASK_LIST);
        if (tasks != null) {
            tasks.add(t);
        } else {
            tasks = new ArrayList<>();
            tasks.add(t);
        }
        return new ModelAndView("tasks-list", "tasks", tasks);
    }


    @RequestMapping(value = "/bye")
    public ModelAndView logout(ModelMap model, HttpSession session) {
        session.invalidate();
        return new ModelAndView("bye", "command", new Login());
    }

}