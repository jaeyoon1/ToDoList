package jaeyoon1.ualberta.c350.todolist;

public class Task {
	protected String taskName;
	protected Boolean taskArchived;
	protected Boolean taskSelected;
	protected Boolean taskChecked;
	
	public Task(String taskName) {
		// TODO Auto-generated constructor stub
		this.taskName = taskName;
		
	}

	public Object getTask() {
		// TODO Auto-generated method stub
		return this.taskName;
	}
	
	public Boolean isArchived(){
		return this.taskArchived;
	}
	
	public Boolean isSelected(){
		return this.taskSelected;
	}
	
	public Boolean isChecked(){
		return this.taskChecked;
	}

}
