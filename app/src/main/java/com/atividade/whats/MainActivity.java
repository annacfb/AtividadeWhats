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
                String telefone = Number_Input_Edit_Text.getText().toString();
                String texto = MessageInputEditText.getText().toString();

                String url = formatoUrl(telefone, texto);

                enviar(url);
            }

            public String formatoUrl(String telefone, String texto) {
                texto = texto.replace(" ", " %20");

                String link = "https://wa.me/+55" + telefone + "?text=" + texto;
                return link;
            }

            public void enviar(String url) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
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

