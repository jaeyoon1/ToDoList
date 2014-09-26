package jaeyoon1.ualberta.c350.todolist;

public class TaskListController {
	private static TaskList tasklist = null; //main list for main/delete views
	private static TaskList archlist = null; //archive views
	
	//if list is null, create a new one, otherwise return list.
	static public TaskList getTaskList(){
		if (tasklist == null){
			tasklist = new TaskList();
		}
		return tasklist;
	}
	static public TaskList getArchList(){
		if (archlist == null){
			archlist = new TaskList();
		}
		return archlist;
	}
	
	
	public Task getTask(int i){
		return getTaskList().getTask(i);
	}
	
	public void addTask(Task task) {
		getTaskList().addTask(task);
	}
	
	public void addArchive(Task task){	
		getArchList().addTask(task);
	}
	
	public void removeTask(int i){
		getTaskList().removeTask(i);
	}
	
	public void removeArchive(int i){
		getArchList().removeTask(i);
	}
	
}
