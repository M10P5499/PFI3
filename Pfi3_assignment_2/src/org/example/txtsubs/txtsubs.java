package org.example.txtsubs;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class txtsubs extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button Submit;
        Submit = (Button) findViewById(R.id.button1);
        Submit.setOnClickListener(this);
       
        
  
    }

	@Override
	public void onClick (View v) {
		
		EditText text = (EditText) findViewById(R.id.editText1);
		
		EditText text1 = (EditText) findViewById(R.id.editText2);
		
		String msg = "Blackmail. " + text.getText().toString();
		String tag = "Tag. " + text1.getText().toString();
		
		Toast t = Toast.makeText(this, msg+"\n"+tag, Toast.LENGTH_LONG);
		t.show();
		text.setText("");
		text1.setText("");
	}}