package jaeyoon1.ualberta.c350.todolist;

import java.io.IOException;

public class TaskListController {
	
	//class that acts as interface between the activities and the tasklist
	//contains methods that allow you to manipulate tasklist and archlist
	
	private static TaskList tasklist = null; //main list for main/delete views
	private static TaskList archlist = null; //archive views
	
	//if list is null, create a new one, otherwise return list.
	static public TaskList getTaskList(){
		if (tasklist == null){
			try {
				tasklist = TaskListManager.getManager().loadTaskList();
				tasklist.addListener(new Listener(){
					@Override
					public void update(){
						saveTaskList();
					}
				});
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("could not deserialize tasklist from tasklistmanager");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("could not deserialize tasklist from tasklistmanager");
			}
			//tasklist = new TaskList();
		}
		return tasklist;
	}
	
	static public void saveTaskList(){
		try {
			TaskListManager.getManager().saveTaskList((getTaskList()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("could not deserialize tasklist from tasklistmanager");
		}
		
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
