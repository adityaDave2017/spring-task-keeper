package com.spring.simpleapp.model;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @Generated("assigned")
    @Column(name = "intTaskId")
    private Integer taskId;

    @Column(name = "strTaskDesc")
    private String taskDesc;

    @Column(name = "boolIsDone")
    private boolean isDone;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskDesc=" + taskDesc + ", isDone=" + isDone + "]";
    }

}
