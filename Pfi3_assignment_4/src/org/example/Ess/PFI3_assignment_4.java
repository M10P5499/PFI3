package org.example.Ess;


import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class PFI3_assignment_4 extends Activity implements OnClickListener, EssemmessListener {
/** Called when the activity is first created. */

Essemmess mServer;

@Override
public void onCreate (Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
mServer = EssemmessHelper.getServer(this);
mServer.addEssemmessEventListener(this);
Button Login= (Button) findViewById (R.id.button);
Login.setOnClickListener(this);
}

@Override
public void onClick(View v) {
EditText text1= (EditText) findViewById(R.id.editText1);
EditText text2= (EditText) findViewById(R.id.editText2);

String user = text2.getText().toString();
String pass = text1.getText().toString();

mServer.login(user, pass);
text1.setText ("");
text2.setText ("");
}
@Override
public void NewEssemmessPosts(EssemmessReadEvent evt) {
// TODO Auto-generated method stub

}
@Override
public void NewEssemmessLogin(EssemmessLoginEvent evt) {
// TODO Auto-generated method stub
if (evt.getLoggedin()){
Intent texting = new Intent(this, Send.class);
startActivity(texting);
finish();
} else {
	Log.i("Falflaflafl.", "Faflaflasf");
}

}
@Override
public void NewEssemmessPublish(EssemmessPublishEvent evt) {
// TODO Auto-generated method stub

}
}