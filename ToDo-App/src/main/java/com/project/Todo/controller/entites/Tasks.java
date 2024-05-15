package com.project.Todo.controller.entites;


public class Tasks {
	
	private int id;
	private String TaskName;
	private String TaskDesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getTaskDesc() {
		return TaskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		TaskDesc = taskDesc;
	}
	public Tasks(int id, String taskName, String taskDesc) {
		super();
		this.id = id;
		this.TaskName = taskName;
		this.TaskDesc = taskDesc;
	}
	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", TaskName=" + TaskName + ", TaskDesc=" + TaskDesc + "]";
	}
	
	
	
}
