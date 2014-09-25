package jaeyoon1.ualberta.c350.todolist;

public class TaskListController {
	private static TaskList tasklist = null;
	static public TaskList getTaskList(){
		if (tasklist == null){
			tasklist = new TaskList();
		}
		return tasklist;
	}
	
	public Task chooseTask(int i){
		return getTaskList().getTask(i);
	}

	public void addTask(Task task) {
		getTaskList().addTask(task);
	}
}
