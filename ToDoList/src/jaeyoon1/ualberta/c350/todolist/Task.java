package jaeyoon1.ualberta.c350.todolist;

import java.io.Serializable;

public class Task implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 462323210420920383L;
	protected String taskName;
	protected String taskNameCheck;
	protected boolean taskArchived;
	protected boolean taskChecked;
	
	public Task(String taskName) {
		// TODO Auto-generated constructor stub
		this.taskName = taskName;
		this.taskNameCheck = "[ ]TODO: "+taskName;
		this.taskArchived = false;
		this.taskChecked = false;
		
	}
	
	public String toString(){
		return getTask();
	}

	public String getTask() {
		// TODO Auto-generated method stub
		return this.taskNameCheck;
	}
	
	public boolean isArchived(){
		return this.taskArchived;
	}
	
	public boolean isChecked(){
		return this.taskChecked;
	}
	
	public void setArchive(boolean a){
		this.taskArchived = a;
	}
	
	public void setChecked(boolean a){
		if (a){
			taskNameCheck = "[x]TODO: "+this.taskName;
		}else{
			taskNameCheck = "[ ]TODO: "+this.taskName;
		}
		this.taskChecked = a;
	}
	

}
