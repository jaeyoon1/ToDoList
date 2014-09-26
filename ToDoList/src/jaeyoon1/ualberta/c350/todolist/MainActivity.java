package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;

import jaeyoon1.ualberta.c350.todolist.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Based on Prof.Abram Hindle's StudentPicker app tutorial.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TaskListManager.initManager(this.getApplicationContext());
        
    	ListView listView = (ListView) findViewById(R.id.tasklist_main);
        Collection<Task> Tasks = TaskListController.getTaskList().getTasks();
        final ArrayList<Task> list = new ArrayList<Task>(Tasks);
        final ArrayAdapter<Task> taskAdapter = new ArrayAdapter<Task>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(taskAdapter);
        
        TaskListController.getTaskList().addListener(new Listener(){
        	public void update(){
        		list.clear();
        		Collection<Task> Tasks = TaskListController.getTaskList().getTasks();
        		list.addAll(Tasks);
        		taskAdapter.notifyDataSetChanged();
        	}
        });
        
        //Tap item to check item
        listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				//Toast.makeText(MainActivity.this,"Checked",Toast.LENGTH_SHORT).show();
				Task task = TaskListController.getTaskList().getTask(position);
				if (task.isChecked()==true){
					TaskListController.getTaskList().getTask(position).setChecked(false);
				} else{
					TaskListController.getTaskList().getTask(position).setChecked(true);
				}
				taskAdapter.notifyDataSetChanged();
			}
        });
        
        //Hold item to archive single item
        listView.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				//do nothing if item is already archived
				if(TaskListController.getArchList().getTasks().contains(TaskListController.getTaskList().getTask(position))){
					Toast.makeText(MainActivity.this,"Item is already Archived",Toast.LENGTH_SHORT).show();
				} else {
				//otherwise add selected item to archlist
				Toast.makeText(MainActivity.this,"'"+list.get(position).toString().substring(8,list.get(position).toString().length())+"' Archived",Toast.LENGTH_SHORT).show();
				TaskListController.getArchList().addTask(TaskListController.getTaskList().getTask(position));
				}
				return true;// setting to true prevents onItemClick from being triggered when onItemLongClick is triggered.
		}});
    }

    //Inflate screens when button pressed from menu
    public void archiveScreen(MenuItem menu){
    	Toast.makeText(this,"ArchiveScreen",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this,ArchiveScreenActivity.class);
    	startActivity(intent);
    }
    
    public void deleteScreen(MenuItem menu){
    	Toast.makeText(this,"DeleteScreen",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this,DeleteScreenActivity.class);
    	startActivity(intent);
    }
    
    public void statusScreen(MenuItem menu){
    	Toast.makeText(this,"statusScreen",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this,StatusScreenActivity.class);
    	startActivity(intent);
    }
    
    public void mailScreen(MenuItem menu){
    	Toast.makeText(this,"MailScreen",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this,MailScreenActivity.class);
    	startActivity(intent);
    }
    
    //AddTask Button
    public void addTask(View view){
    	//Toast.makeText(this,"AddButton",Toast.LENGTH_SHORT).show();
    	TaskListController tc = new TaskListController();
    	EditText textview = (EditText) findViewById(R.id.main_textfield_add);
    	String text = textview.getText().toString();
    	if (text.length() <= 0){
    		Toast.makeText(this,"Empty Input",Toast.LENGTH_SHORT).show();
    	} else {
    		tc.addTask(new Task(text));
    	}
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
