package jaeyoon1.ualberta.c350.todolist;

import java.util.ArrayList;
import java.util.Collection;
import jaeyoon1.ualberta.c350.todolist.R;
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

public class ArchiveScreenActivity extends Activity {

	//same as MainActivity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.archive_screen);
		
        ListView listView = (ListView) findViewById(R.id.tasklist_archive);
        Collection<Task> Tasks = TaskListController.getArchList().getTasks();
        final ArrayList<Task> list = new ArrayList<Task>(Tasks);
        final ArrayAdapter<Task> taskAdapter = new ArrayAdapter<Task>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(taskAdapter);
        
        TaskListController.getArchList().addListener(new Listener(){
    	public void update(){
    		list.clear();
    		Collection<Task> Tasks = TaskListController.getArchList().getTasks();
    		list.addAll(Tasks);
    		taskAdapter.notifyDataSetChanged();
    	}});
        
        //remove single archive item upon holding item
        listView.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
					Toast.makeText(ArchiveScreenActivity.this,list.get(position).toString()+"ArchiveDeleted",Toast.LENGTH_SHORT).show();
					list.remove(position);
					TaskListController.getArchList().removeTask(position);
				return true;
			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.archive_screen, menu);
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
