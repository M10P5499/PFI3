package org.example.Ess;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;


public class Send extends Activity implements OnClickListener, EssemmessListener{
/** Called when the activity is first created. */
Essemmess mServer = EssemmessHelper.getServer(this);


public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main2);

Button button = (Button) findViewById(R.id.button1);
button.setOnClickListener(this);
Button button2 = (Button) findViewById(R.id.button2);
button2.setOnClickListener(this);

}

public void onClick (View v) {
switch (v.getId()){
case R.id.button1:

EditText text1= (EditText) findViewById(R.id.editText1);
EditText text2= (EditText) findViewById(R.id.editText2);

String msg = text1.getText().toString();
String tag = text2.getText().toString();

mServer.post(msg, tag);

Toast t = Toast.makeText(this, "Posted", Toast.LENGTH_LONG);
t.show ();
text1.setText ("");
text2.setText ("");

break;

case R.id.button2:

Intent view = new Intent (this, Read.class);
startActivity(view);
finish();
break;
}

}

@Override
public void NewEssemmessPosts(EssemmessReadEvent evt) {
// TODO Auto-generated method stub

}

@Override
public void NewEssemmessLogin(EssemmessLoginEvent evt) {
// TODO Auto-generated method stub

}

@Override
public void NewEssemmessPublish(EssemmessPublishEvent evt) {
// TODO Auto-generated method stub

}
}