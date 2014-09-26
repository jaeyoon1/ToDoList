package jaeyoon1.ualberta.c350.todolist;

public class Task {
	protected String taskName;
	protected String taskNameCheck;
	protected Boolean taskArchived;
	protected Boolean taskSelected;
	protected Boolean taskChecked;
	
	public Task(String taskName) {
		// TODO Auto-generated constructor stub
		this.taskName = taskName;
		this.taskNameCheck = "[ ]TODO: "+taskName;
		this.taskArchived = false;
		this.taskSelected = false;
		this.taskChecked = false;
		
	}
	
	public String toString(){
		return getTask();
	}

	public String getTask() {
		// TODO Auto-generated method stub
		return this.taskNameCheck;
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
	
	public void setArchive(boolean a){
		this.taskArchived = a;
	}
	
	public void setSelected(boolean a){

		this.taskSelected = a;
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
