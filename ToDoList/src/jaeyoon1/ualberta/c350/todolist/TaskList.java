package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;

import jaeyoon1.ualberta.c350.todolist.Task;

public class TaskList {
	protected ArrayList<Task> TaskArrayList;
	protected ArrayList<Listener> listeners;
	
	//Constructor
	public TaskList() {
		TaskArrayList = new ArrayList<Task>();
		listeners = new ArrayList<Listener>();
	}
	
	//Listener Methods
	public void notifyListeners(){
		for(Listener listener : listeners){
			listener.update();
		}
	}
	public void addListener (Listener l){
		listeners.add(l);
	}
	public void removeListener (Listener l){
		listeners.remove(l);
	}
	
	
	// Returns Collection of Tasks
	public Collection<Task> getTasks() {
		// TODO Auto-generated method stub
		return TaskArrayList;
	}
	
	// Returns true if List contains task
	public boolean contains(Task task){
		return TaskArrayList.contains(task);
	}
	
	
	public int getIndex(Task task){
		int a = TaskArrayList.indexOf(task);
		return a;
	}
	
	//Size of Task
	public int getSize(){
		return TaskArrayList.size();
	}

	//Get Task from index
	public Task getTask(int i){
		return TaskArrayList.get(i);
	}
	
	//Adds task
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		TaskArrayList.add(task);
		notifyListeners();
	}
	
	//removes task from index
	public void removeTask(int i){
		TaskArrayList.remove(i);
		notifyListeners();
	}

	//calls setChecked method in tasks from index
	public void checkTask(int i){
		Task task = TaskArrayList.get(i);
		task.setChecked(true);
		notifyListeners();
	}
	public void uncheckTask(int i){
		Task task = TaskArrayList.get(i);
		task.setChecked(false);
		notifyListeners();
	}
	
	//iterates over the list and checks if each task is checked or not.
	//increment count if true
	public int numChecked(){
		int count = 0;
		for (Task task : TaskArrayList){
			if (task.isChecked() == true){
				count = count+1;
			}
		}
		return count;
	}
}
