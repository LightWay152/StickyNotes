package com.example.android.stickynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {

    // EditText field
    private EditText etEditItem; //currently null
    // private <type> <id>;
    private TextView tvLabel; // null
    int position=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Views are created in the layout
        // Find reference to those view
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        // <id> = <type> findViewById(R.id.<id>);
        tvLabel = (TextView) findViewById(R.id.tvLabel);
        String content="";
        content=getIntent().getStringExtra("content");
        position= getIntent().getIntExtra("position",-1);
        etEditItem.setText(content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSave(View view) {
        // Get the value from the text field (whatever was typed into the text field)
        String fieldValue = etEditItem.getText().toString();
        // Set the value into the label
        tvLabel.setText(fieldValue);
        // Display the value as a quick alert
        Toast.makeText(this, fieldValue, Toast.LENGTH_SHORT).show();
        // closes the activity and returns to first screen
        Intent data= new Intent();
        data.putExtra("content",fieldValue);
        data.putExtra("position",position);
        setResult(RESULT_OK,data);

        this.finish();
    }
}
