package eu.xn__emaitis_cxb.mokslai.docs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class NaujasIrasasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naujas_irasas);
        final EditText textRegistracijosNumeris=(EditText) findViewById(R.id.registracijosNumeris);
        final EditText textDokumentoNumeris=(EditText) findViewById(R.id.dokumentoNumeris);
        final RadioGroup tipai = (RadioGroup) findViewById(R.id.tipas);
        final RadioButton[] tipas = new RadioButton[1];
        final CheckBox atsakytiTaip = (CheckBox) findViewById(R.id.atsakytiTaip);
        final CheckBox atsakytiNe = (CheckBox) findViewById(R.id.atsakytiNe);

        Button saugoti = (Button) findViewById(R.id.siusti);

        saugoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get selected radio button from radioGroup
                int selectedId = tipai.getCheckedRadioButtonId();
                //find radiobutton by returned id
                tipas[0] = (RadioButton) findViewById(selectedId);

                StringBuffer atsakymai = new StringBuffer();
                atsakymai.append("Taip")
                        .append(atsakytiTaip.isChecked());
                atsakymai.append("Ne")
                        .append(atsakytiNe.isChecked());

                Toast.makeText(NaujasIrasasActivity.this,
                        textRegistracijosNumeris.getText() + "\n" +
                                textDokumentoNumeris.getText() + "\n" +
                                atsakymai.toString() +
                                tipas[0].getText(), Toast.LENGTH_SHORT).show();
            }//onclick
        });//setonclick
    }//oncreate
}//class
