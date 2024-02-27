package com.manager.service;

import java.util.List;

import com.manager.entity.Tasks;

public interface Service_Tasks {

public	String addTask(Tasks task);

public	String removeTask(String title);

public	List<Tasks> getTasks();

public	String addToComplete(String title);

public List<Tasks> getCompletedTasks();

}
