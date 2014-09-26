package jaeyoon1.ualberta.c350.todolist;

import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MailScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mail_screen);
		TaskListManager.initManager(this.getApplicationContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail_screen, menu);
		return true;
	}
	
	
	//taken from http://stackoverflow.com/questions/4404084/find-if-a-value-exists-in-arraylist
	//grabs the currently added tasks and send mail after adding them into a string
	public void mailAll(View view){
		EditText mailtext = (EditText) findViewById(R.id.emailaddr);
		String address = mailtext.getText().toString();
		String body = "";
		
		//Append Tasks into single string
		Collection<Task> Tasks  = TaskListController.getTaskList().getTasks();
		Collection<Task> ArchTasks  = TaskListController.getArchList().getTasks();
		for (Task task : Tasks){
			body = body+task.getTask()+"\n";
		}
		for (Task task : ArchTasks){
			body = body+task.getTask()+"\n";
		}
		
		Intent mail = new Intent(Intent.ACTION_SEND);
		mail.setType("message/rfc822");
		mail.putExtra(Intent.EXTRA_EMAIL  , address);
		mail.putExtra(Intent.EXTRA_SUBJECT, "jaeyoon1-list");
		mail.putExtra(Intent.EXTRA_TEXT   ,body);
		try {
			Toast.makeText(MailScreenActivity.this, "Sending mail to..."+address, Toast.LENGTH_SHORT).show();
		    startActivity(Intent.createChooser(mail, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(MailScreenActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void mailTask(View view){
		EditText mailtext = (EditText) findViewById(R.id.emailaddr);
		String address = mailtext.getText().toString();
		String body = "";
		
		//Append Tasks into single string
		Collection<Task> Tasks  = TaskListController.getTaskList().getTasks();
		for (Task task : Tasks){
			body = body+task.getTask()+"\n";
		}		
		Intent mail = new Intent(Intent.ACTION_SEND);
		mail.setType("message/rfc822");
		mail.putExtra(Intent.EXTRA_EMAIL  , address);
		mail.putExtra(Intent.EXTRA_SUBJECT, "jaeyoon1-list");
		mail.putExtra(Intent.EXTRA_TEXT   ,body);
		try {
			Toast.makeText(MailScreenActivity.this, "Sending mail to..."+address, Toast.LENGTH_SHORT).show();
		    startActivity(Intent.createChooser(mail, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(MailScreenActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}

	public void mailArch(View view){
		EditText mailtext = (EditText) findViewById(R.id.emailaddr);
		String address = mailtext.getText().toString();
		String body = "";
		
		//Append Tasks into single string
		Collection<Task> ArchTasks  = TaskListController.getArchList().getTasks();
		for (Task task : ArchTasks){
			body = body+task.getTask()+"\n";
		}
		
		Intent mail = new Intent(Intent.ACTION_SEND);
		mail.setType("message/rfc822");
		mail.putExtra(Intent.EXTRA_EMAIL  , address);
		mail.putExtra(Intent.EXTRA_SUBJECT, "jaeyoon1-list");
		mail.putExtra(Intent.EXTRA_TEXT   ,body);
		try {
			Toast.makeText(MailScreenActivity.this, "Sending mail to..."+address, Toast.LENGTH_SHORT).show();
		    startActivity(Intent.createChooser(mail, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(MailScreenActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
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
