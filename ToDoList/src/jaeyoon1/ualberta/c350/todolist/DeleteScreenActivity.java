package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class DeleteScreenActivity extends Activity {

	//same as MainActivity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.del_screen);
		
        ListView listView = (ListView) findViewById(R.id.tasklist_delete);
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
        
        listView.setOnItemLongClickListener(new OnItemLongClickListener(){
        	
        //Ask to delete single item if held down
		@Override
		public boolean onItemLongClick(AdapterView<?> adapterView, View view,
			int position, long id) {
				Toast.makeText(DeleteScreenActivity.this,list.get(position).toString()+"TaskDeleted",Toast.LENGTH_SHORT).show();
				list.remove(position);
				TaskListController.getTaskList().removeTask(position);
				return false;
			}
        });
	}
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete_screen, menu);
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
