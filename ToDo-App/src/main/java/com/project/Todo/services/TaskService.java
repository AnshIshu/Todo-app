package com.project.Todo.services;

import java.util.List;

import com.project.Todo.controller.entites.Tasks;

public interface TaskService {
	
	public List<Tasks> getTasks();
	
	public Tasks getTask(int taskId);

	public Tasks addTask(Tasks task_var);
	
	public  Tasks updateTask(int id, Tasks updatedTask);
	
	public int delTask(int id);

}
