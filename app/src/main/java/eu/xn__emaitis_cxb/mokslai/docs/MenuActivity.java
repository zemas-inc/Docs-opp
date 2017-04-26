package eu.xn__emaitis_cxb.mokslai.docs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button naujasIrasas=(Button) findViewById(R.id.naujasIrasas);
        naujasIrasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuActivity.this, "Paspaustas naujas įrašas mygtukas", Toast.LENGTH_SHORT).show();
                Intent goToMenuActivity = new Intent(MenuActivity.this, NaujasIrasasActivity.class);
                startActivity(goToMenuActivity);
            }

        });
        Button perziuretiIrasus=(Button) findViewById(R.id.perziuretiIrasus);
        perziuretiIrasus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuActivity.this, "Paspaustas peržiūrėti įrašus mygtukas", Toast.LENGTH_SHORT).show();
                Intent goToMenuActivity = new Intent(MenuActivity.this, SearchActivity.class);
                startActivity(goToMenuActivity);
            }

        });
    }
}
