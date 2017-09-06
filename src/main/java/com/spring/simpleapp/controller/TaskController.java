package com.spring.simpleapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView goToHome() {
        return new ModelAndView("home", "command", new Login());
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processCredentials(@ModelAttribute("SpringWeb") Login login, ModelMap model) {
        System.out.println(login.toString());

        // Add username and password verification here...
        if (login.getUsername().equals(login.getPassword())) {
            return new ModelAndView("redirect:tasks", "command", new Login());
        }
        return new ModelAndView("login-error", "command", new Login());
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelMap model) {
        return new ModelAndView("register", "command", new Account());
    }


    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("account") Account account, ModelMap model) {
        // create account by adding details to database and show tasks page
        System.out.println(account);
        return new ModelAndView("redirect:tasks");
    }


    @RequestMapping(value = "/tasks")
    public ModelAndView getTasks(ModelMap model, HttpSession session) {
        // Retrieve tasks for the logged in user, if none are
        // present keep the list empty. Tasks sorted on isDone field.
        ArrayList<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Task task = new Task();
            task.setDone(i % 2 == 0);
            task.setTaskDesc("This is task no. " + i);
            tasks.add(task);
        }
        session.setAttribute("TASKS_LIST", tasks);
        return new ModelAndView("tasks-list", "tasks", tasks);
    }


    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public ModelAndView addTask(@RequestParam("taskDesc") String taskDesc, HttpSession session) {
        // Add the task to the database to corresponding user account
        Task t = new Task();
        t.setTaskDesc(taskDesc);
        ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute("TASKS_LIST");
        if (tasks != null) {
            tasks.add(t);
        }
        return new ModelAndView("tasks-list", "tasks", tasks);
    }


    @RequestMapping(value = "/bye")
    public ModelAndView logout(ModelMap model, HttpSession session) {
        session.removeAttribute("TASKS_LIST");
        return new ModelAndView("bye", "command", new Login());
    }

}