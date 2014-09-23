package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;

import jaeyoon1.ualberta.c350.todolist.Task;

public class TaskList {
	
	protected ArrayList<Task> TaskArrayList;
	
	public TaskList() {
		TaskArrayList = new ArrayList<Task>();
	}
	
	public Collection<Task> getTasks() {
		// TODO Auto-generated method stub
		return TaskArrayList;
	}
	
	public boolean contains(Task task){
		return TaskArrayList.contains(task);
	}
	
	public Task getTask(int i){
		return TaskArrayList.get(i);
	}
	
	public int getIndex(Task task){
		int a = TaskArrayList.indexOf(task);
		return a;
	}
	
	public int getSize(){
		return TaskArrayList.size();
	}
	
	public void addTask(Task sampleTask) {
		// TODO Auto-generated method stub
		TaskArrayList.add(sampleTask);
	}
	
	public void removeTask(int i){
		TaskArrayList.remove(i);
	}
	
	public void archiveTask(int i){
		Task task = TaskArrayList.get(i);
		task.setArchive(true);
	}
	
	public void unarchiveTask(int i){
		Task task = TaskArrayList.get(i);
		task.setArchive(false);
	}
	
	public void selectTask(int i){
		Task task = TaskArrayList.get(i);
		task.setSelected(true);
	}
	
	public void deselectTask(int i){
		Task task = TaskArrayList.get(i);
		task.setSelected(false);
	}
	
	public void checkTask(int i){
		Task task = TaskArrayList.get(i);
		task.setChecked(true);
	}
	
	public void uncheckTask(int i){
		Task task = TaskArrayList.get(i);
		task.setChecked(false);
	}
}
