package jaeyoon1.ualberta.c350.todolist.test;

import java.util.Collection;

import junit.framework.TestCase;
import jaeyoon1.ualberta.c350.todolist.*;

public class TaskListTest extends TestCase {
	public void testTaskList(){
		TaskList taskList = new TaskList();
		Collection<Task> tasks = taskList.getTasks();
		assertTrue("Empty Task List",tasks.size() == 0);
		
	}

	public void testAddRemoveTask(){
		TaskList taskList = new TaskList();
		String taskname = "A task ;w;";
		Task sampleTask = new Task(taskname);
		taskList.addTask(sampleTask);
		Collection<Task> tasks = taskList.getTasks();
		assertTrue("Empty Task List",tasks.size() == 1);
		assertTrue("Empty Task List",tasks.contains(sampleTask));
		taskList.removeTask(taskList.getIndex(sampleTask));
		assertTrue("Empty Task List",tasks.size() == 0);
	}
	
	public void testArchiveTask(){
		TaskList taskList = new TaskList();
		String taskname = "A task ;w;";
		Task sampleTask = new Task(taskname);
		taskList.addTask(sampleTask);
		Collection<Task> tasks = taskList.getTasks();
		assertTrue("Empty Task List",tasks.size() == 1);
		assertTrue("Empty Task List",tasks.contains(sampleTask));
		taskList.archiveTask(0);
		Task uwaa = taskList.getTask(0);
		assertTrue("not archived",uwaa.isArchived());
	}
	
	public void testSize(){
		TaskList taskList = new TaskList();
		String taskname = "A task ;w;";
		Task sampleTask = new Task(taskname);
		taskList.addTask(sampleTask);
		assertTrue("Wrong Size",taskList.getSize() == 1);
	}
}
