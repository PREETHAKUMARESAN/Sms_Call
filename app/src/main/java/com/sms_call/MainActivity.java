package com.sms_call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phone, name;
    Button call, msg;
    String number,the_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.editText3);
        number=phone.getText().toString();
        Log.d("tag","gth"+number);

        name = (EditText) findViewById(R.id.editText2);
        the_name=name.getText().toString();
        call = (Button) findViewById(R.id.call);
        msg=(Button)findViewById(R.id.message);


        //Call a specific contact
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag",phone.getText().toString());
                Log.d("tag","gthh"+the_name);
                Toast.makeText(MainActivity.this,"gth"+number,Toast.LENGTH_LONG).show();
                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(call);
            }
        });
        //msg a contact
        msg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,send_message.class);
                i.putExtra("phone",phone.getText().toString());
                startActivity(i);
            }
        });

    }
}
