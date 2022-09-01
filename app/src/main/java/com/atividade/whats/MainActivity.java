package com.atividade.whats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout Number_Input_Layout;
    private TextInputLayout MessageInputLayout;

    private TextInputEditText Number_Input_Edit_Text;
    private TextInputEditText MessageInputEditText;

    private android.widget.Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number_Input_Layout = findViewById(R.id.Number_Input_Layout);
        MessageInputLayout = findViewById(R.id.Messege_Input_Layout);

        Number_Input_Edit_Text = findViewById(R.id.Number_Input_Edit_Text);
        MessageInputEditText = findViewById(R.id.Messege_Input_Edit_Text);

        Button = findViewById(R.id.Button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage ("https://wa.me/5541998541436?text=I'm%20interested%20in%20your%20car%20for%20sale");
            }
        });
    }

public void openWebPage(String url){
    Uri webpage = Uri.parse(url);
    Intent intent = new Intent(getApplicationContext(),
            MainActivity.class);
        startActivity(intent);
    }
}

