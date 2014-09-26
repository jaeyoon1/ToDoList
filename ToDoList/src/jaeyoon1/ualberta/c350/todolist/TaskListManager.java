package jaeyoon1.ualberta.c350.todolist;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

//Based on Abram Hindle's Student Picker App

public class TaskListManager {
	static String prefFile = "TaskList";
	static String tlKey = "taskList";
	Context context;
	
	static private TaskListManager taskListManager = null;
	
	public static void initManager(Context context){
		if(taskListManager == null) {
			if (context == null){
				throw new RuntimeException("missing context");
			}
			taskListManager = new TaskListManager(context);
		}
	}
	
	public static TaskListManager getManager(){
		if(taskListManager==null){
			throw new RuntimeException("Did not initialize Manager");
		}
		return taskListManager;
	}
	
	public TaskListManager(Context context){
		this.context = context;
	}
	
	public TaskList loadTaskList() throws StreamCorruptedException, ClassNotFoundException, IOException{
		SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
		String taskListData = settings.getString(tlKey, "");
		if (taskListData.equals("")){
			return new TaskList();
		} else {
			return taskListFromString(taskListData);
		}
	}
	
	public void saveTaskList(TaskList tl) throws IOException{
		SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
		Editor editor = settings.edit();
		editor.putString(tlKey, taskListToString(tl));
		editor.commit();
	}
	
	private TaskList taskListFromString(String taskListData) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(taskListData, Base64.DEFAULT));
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (TaskList) oi.readObject();
	}

	private String taskListToString(TaskList tl) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(tl);
		oo.close();
		byte bytes[] = bo.toByteArray();
		return Base64.encodeToString(bytes,Base64.DEFAULT);
	}
	
}
