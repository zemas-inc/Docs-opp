package eu.xn__emaitis_cxb.mokslai.docs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(LoginActivity.this, "Paspaustas prisijungti mygtukas", Toast.LENGTH_SHORT).show();
                Intent goToMenuActivity = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(goToMenuActivity);
            }

        });
        Button register=(Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(LoginActivity.this, "Paspaustas registruotis mygtukas", Toast.LENGTH_SHORT).show();
                Intent goToMenuActivity = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(goToMenuActivity);
            }

        });
    }
}
