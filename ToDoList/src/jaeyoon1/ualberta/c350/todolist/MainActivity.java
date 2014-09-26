package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;

import jaeyoon1.ualberta.c350.todolist.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
        
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this,"Checked",Toast.LENGTH_SHORT).show();
				Task task = TaskListController.getTaskList().getTask(position);
				if (task.isChecked()==true){
					TaskListController.getTaskList().getTask(position).setChecked(false);
				} else{
					TaskListController.getTaskList().getTask(position).setChecked(true);
				}
				taskAdapter.notifyDataSetChanged();
			}
        });
        
        listView.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				if(TaskListController.getTaskList().getTasks().contains(TaskListController.getTaskList().getTask(position))){
					Toast.makeText(MainActivity.this,"Item already Archived",Toast.LENGTH_SHORT).show();
				} else {
				Toast.makeText(MainActivity.this,list.get(position).toString()+"Archived",Toast.LENGTH_SHORT).show();
				TaskListController.getArchList().addTask(TaskListController.getTaskList().getTask(position));
				}
				// TODO Auto-generated method stub
				return true;
		}});
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
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
    
    public void addTask(View view){
    	Toast.makeText(this,"AddButton",Toast.LENGTH_SHORT).show();
    	TaskListController tc = new TaskListController();
    	EditText textview = (EditText) findViewById(R.id.main_textfield_add);
    	tc.addTask(new Task(textview.getText().toString()));
    	//Toast.makeText(this,textview.getText().toString(),Toast.LENGTH_SHORT).show();
    	//Toast.makeText(this,Integer.toString(tc.getSize()),Toast.LENGTH_SHORT).show();
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
