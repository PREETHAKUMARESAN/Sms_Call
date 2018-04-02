package com.sms_call;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class send_message extends AppCompatActivity {

    Button sendBtn;
    EditText txtMessage; String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        Log.e("myTag","entered into msg");

        sendBtn = (Button) findViewById(R.id.button);
        txtMessage = (EditText) findViewById(R.id.editText);

        number=getIntent().getExtras().getString("phone");

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }
    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        Log.e("myTag","send msg");
        String message = txtMessage.getText().toString();
       Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:"));
         smsIntent.setType("vnd.android-dir/mms-sms");
         smsIntent.putExtra("address" , getIntent().getExtras().getString("phone"));
         smsIntent.putExtra("sms_body" ,message);

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {

        }
}}

