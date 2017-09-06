package com.spring.simpleapp.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "task")
@NamedQueries({
        @NamedQuery(name = "taskForUser", query = "FROM Task WHERE accountId=:accountId ORDER BY isDone"),
        @NamedQuery(name = "deleteTask", query = "DELETE FROM Task WHERE taskId=:taskId")
})
public class Task implements Serializable {

    @Id
    @GenericGenerator(name="kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    @Column(name = "intTaskId")
    private int taskId;

    @Column(name = "intAccId")
    private int accountId;

    @Column(name = "strTaskDesc")
    private String taskDesc;

    @Column(name = "boolIsDone")
    private boolean isDone;

    @Column(name = "intPriority")
    private int priority;

    @Column(name = "stampTimeStamp")
    private String time;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", accountId=" + accountId +
                ", taskDesc='" + taskDesc + '\'' +
                ", isDone=" + isDone +
                ", priority=" + priority +
                ", time='" + time + '\'' +
                '}';
    }

}
