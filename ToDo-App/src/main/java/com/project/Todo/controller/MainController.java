package com.project.Todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Todo.controller.entites.Tasks;
import com.project.Todo.services.TaskService;
//import org.springframework.web.bind.annotation.ResponseBody;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class MainController {
		
	@Autowired
	//declare a variable for parent service class
	public TaskService taskService;

	@GetMapping("/dashboard")
	 public String dashboard()
	 {
		 return "It's just a normal get mapping";
	 }
	
	@GetMapping("/Tasks")
	//get all the task added
	public List<Tasks> getTasks(){
		return this.taskService.getTasks();
	}
	
	//get task by id
	@GetMapping("/Tasks/{taskId}")
	public Tasks getTask(@PathVariable int taskId)
	{
		return this.taskService.getTask(taskId);
	}
	
	//Add Task
	@PostMapping("/Tasks")
	public Tasks addTask(@RequestBody Tasks task_var) 
	{
		
		//return this.taskService.addTask(task);
		return this.taskService.addTask(task_var);
	}
	
	//Update Tasks
	@PutMapping("/Tasks/{taskId}")
    public ResponseEntity<String> updateTaskById(@PathVariable("taskId") int taskId, @RequestBody Tasks updatedTask)
	{
        Tasks existingTask = taskService.getTask(taskId);
        
        if (existingTask != null) {
            updatedTask.setId(taskId); // Ensure the ID is set correctly
            taskService.updateTask(taskId,updatedTask);
            return ResponseEntity.ok("Task updated successfully"+updatedTask);
        	
        } 
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
    }
	
	//Delete tasks
	@DeleteMapping("Tasks/{taskId}")
	public ResponseEntity<String> delTask(@PathVariable("taskId") int taskId  )
	{ 			
		this.taskService.delTask(taskId);
		return ResponseEntity.ok("Deleted resource with ID: " + taskId);
	}
	
}


