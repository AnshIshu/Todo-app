package com.project.Todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Todo.controller.entites.Tasks;

@Service
public class TaskServiceImpl<Task> implements TaskService {
	
	List<Tasks> list;
	
	public TaskServiceImpl()
	{
		list = new ArrayList<>();
		list.add(new Tasks(1,"Shopping","Go to Shopping"));
		list.add(new Tasks(2,"Study","Go to coaching"));
	}

	@Override
	public List<Tasks> getTasks() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Tasks getTask(int taskId) {
		
		Tasks T = null;
		for(Tasks task:list)
		{
			if(task.getId()==taskId)
			{
				T = task;
				 break;
			}
		}
		
		
		return T;
	}

	@Override
	public Tasks addTask(Tasks task_var) {
		
		list.add(task_var);
		return task_var;
		//System.out.print("Service layer"+task_var);
		
	}


	@Override
//	public Tasks updateTask(int id,Tasks updatedTask) {
//		
//		list.set(id, updatedTask);
//		//list.set
//		return updatedTask;
//	}
	
	public Tasks updateTask(int id, Tasks updatedTask) {
	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i).getId() == id) {
	            list.set(i, updatedTask);
	            return updatedTask;
	        }
	    }
	    return null; // or throw an exception if the task with the specified ID is not found
	}

	@Override
	public int delTask(int id) {
	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i).getId() == id) {
	            list.remove(i);
	            return id;
	        }
	    }
	    return -1; // Return -1 if the task with the specified ID is not found
	}

}
