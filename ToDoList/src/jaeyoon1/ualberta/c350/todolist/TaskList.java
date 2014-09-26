package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;

import jaeyoon1.ualberta.c350.todolist.Task;

public class TaskList {
	
	//protected ArrayList<Task> TaskArchList;
	protected ArrayList<Task> TaskArrayList;
	protected ArrayList<Listener> listeners;
	
	public TaskList() {
		TaskArrayList = new ArrayList<Task>();
		//TaskArchList = new ArrayList<Task>();
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
	
	
	// Returns Tasklist/Archlist respectively 
	
	public Collection<Task> getTasks() {
		// TODO Auto-generated method stub
		return TaskArrayList;
	}
	/*
	public Collection<Task> getArchives(){
		return TaskArchList;
	}
	*/
	public boolean contains(Task task){
		return TaskArrayList.contains(task);
	}
	
	public int getIndex(Task task){
		int a = TaskArrayList.indexOf(task);
		return a;
	}
	
	public int getSize(){
		return TaskArrayList.size();
	}
	/*
	public int getArchSize(){
		return TaskArchList.size();
	}
	*/
	public Task getTask(int i){
		return TaskArrayList.get(i);
	}
	
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		TaskArrayList.add(task);
		notifyListeners();
	}
	
	public void removeTask(int i){
		TaskArrayList.remove(i);
		notifyListeners();
	}
	/*
	public void addArchive(Task task){
		TaskArchList.add(task);
		task.setArchive(true);
		notifyListeners();
	}
	
	public void removeArchive(int i){
		Task task = TaskArrayList.get(i);
		task.setArchive(false);
		notifyListeners();
	}
	*/
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
