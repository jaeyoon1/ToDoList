package jaeyoon1.ualberta.c350.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class StatusScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status_screen);
		
		TextView itemschecked = (TextView) findViewById(R.id.stat_checked);
		TextView itemsunchecked = (TextView) findViewById(R.id.stat_unchecked);
		TextView itemsarchived = (TextView) findViewById(R.id.stat_archived);
		TextView itemsarchchecked = (TextView) findViewById(R.id.stat_archchecked);
		TextView itemsarchunchecked = (TextView) findViewById(R.id.stat_archunchecked);
		
		itemschecked.setText("ItemsChecked"+Integer.toString(0));
		itemsunchecked.setText("ItemsUnchecked"+Integer.toString(0));
		itemsarchived.setText("ItemsArchived"+Integer.toString(0));
		itemsarchchecked.setText("ArchivedItemsChecked"+Integer.toString(0));
		itemsarchunchecked.setText("ArchivedItemsUnchecked"+Integer.toString(0));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status_screen, menu);
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
