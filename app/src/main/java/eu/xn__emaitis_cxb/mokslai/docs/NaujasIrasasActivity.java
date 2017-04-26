package eu.xn__emaitis_cxb.mokslai.docs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
        final EditText textSiuntejas = (EditText) findViewById(R.id.siuntejas);
        final EditText textGavejas = (EditText) findViewById(R.id.gavejas);
        final EditText textAprasymas = (EditText) findViewById(R.id.aprasymas);
        final RadioGroup atsakymai = (RadioGroup) findViewById(R.id.atsakymas);
        final RadioButton[] atsakymas = new RadioButton[1];
 /*     CheckBox example
        final CheckBox atsakytiTaip = (CheckBox) findViewById(R.id.atsakytiTaip);
        final CheckBox atsakytiNe = (CheckBox) findViewById(R.id.atsakytiNe);*/

        Button saugoti = (Button) findViewById(R.id.siusti);

        saugoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Laukelių tikrinimas
                textRegistracijosNumeris.setError(null);
                textDokumentoNumeris.setError(null);
                textSiuntejas.setError(null);
                textGavejas.setError(null);
                textAprasymas.setError(null);
                if (TextUtils.isEmpty(textRegistracijosNumeris.getText().toString())) {
                    textRegistracijosNumeris.setError("Neįvestas registracijos numeris");
                }
                else if (TextUtils.isEmpty(textDokumentoNumeris.getText().toString())){
                    textDokumentoNumeris.setError("Neįvestas dokumento numeris");
                }
                else if (TextUtils.isEmpty(textSiuntejas.getText().toString())){
                    textSiuntejas.setError("Neįvestas siuntėjas");
                }
                else if (TextUtils.isEmpty(textGavejas.getText().toString())){
                    textGavejas.setError("Neįvestas gavėjas");
                }
                else if (TextUtils.isEmpty(textAprasymas.getText().toString())){
                    textAprasymas.setError("Neįvestas aprašymas");
                }
                else {
                    //get selected radio button from radioGroup
                    int selectedTipaiId = tipai.getCheckedRadioButtonId();
                    int selectedAtsakymaiId = atsakymai.getCheckedRadioButtonId();
                    //find radiobutton by returned id
                    tipas[0] = (RadioButton) findViewById(selectedTipaiId);
                    atsakymas[0] = (RadioButton) findViewById(selectedAtsakymaiId);
                    //public Dokumentas(String regNr, String numeris, String tipas, String aprasymas, String atsakymas)
                    Dokumentas irasas = new Dokumentas(textRegistracijosNumeris.getText().toString(),textDokumentoNumeris.getText().toString(),tipas[0].getText().toString(),textSiuntejas.getText().toString(),textGavejas.getText().toString(),textAprasymas.getText().toString(),atsakymas[0].getText().toString());

/*              CheckBox example
               StringBuffer atsakymai = new StringBuffer();
                if (atsakytiTaip.isChecked())
                {
                    atsakymai.append("Taip");
                };*/

                    Toast.makeText(NaujasIrasasActivity.this,
                            irasas.getRegNr() + "\n" +
                                    irasas.getNumeris() + "\n" +
                                    irasas.getTipas() + "\n" +
                                    irasas.getSiuntejas() + "\n" +
                                    irasas.getGavejas() + "\n" +
                                    irasas.getAprasymas() + "\n" +
                                    irasas.getAtsakymas() + "\n"
                            , Toast.LENGTH_SHORT).show();
                }


            }//onclick
        });//setonclick
    }//oncreate
}//class
