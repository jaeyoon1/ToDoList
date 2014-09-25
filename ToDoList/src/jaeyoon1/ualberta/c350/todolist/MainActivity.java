package jaeyoon1.ualberta.c350.todolist;

import jaeyoon1.ualberta.c350.todolist.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
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
