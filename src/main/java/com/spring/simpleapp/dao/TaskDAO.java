package com.spring.simpleapp.dao;

import com.spring.simpleapp.model.Task;

import java.util.List;

public interface TaskDAO {

    Integer saveTask(Task task);

    List<Task> listTaskByAccount(Integer accountId);

    void updateTask(Task task);

    Integer deleteTask(Integer taskId);

}