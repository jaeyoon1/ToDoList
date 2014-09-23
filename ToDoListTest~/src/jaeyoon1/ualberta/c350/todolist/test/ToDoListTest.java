package jaeyoon1.ualberta.c350.todolist.test;

import junit.framework.TestCase;
import jaeyoon1.ualberta.c350.todolist.*;

public class ToDoListTest extends TestCase {
	public void testTask(){
		String taskName = "A Task";
		Task task = new Task(taskName);
		assertTrue("Task name is not equal", taskName.equals(task.getTask()));
	}
	
}
