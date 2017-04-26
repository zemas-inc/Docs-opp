package eu.xn__emaitis_cxb.mokslai.docs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private static final String REGISTER_URL = "http://mokslai.xn--emaitis-cxb.eu/opp/savarankiskas/mobile/register2.php";

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText naujasVardas = (EditText) findViewById(R.id.registerNew_vardas);
        final EditText naujasSlaptazodis = (EditText) findViewById(R.id.registerNew_slaptazodis);
        final EditText naujasElpastas = (EditText) findViewById(R.id.registerNew_elPastas);

        Button mygtuktasNaujVart = (Button) findViewById(R.id.buttonNewRegister);
        mygtuktasNaujVart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                naujasVardas.setError(null);
                naujasSlaptazodis.setError(null);
                naujasElpastas.setError(null);
                boolean cancel = false;
                View focusView = null;



                if (TextUtils.isEmpty(naujasVardas.getText().toString())) {
                    naujasVardas.setError(getResources().getString(R.string.error_invalid_username));
                } else if (TextUtils.isEmpty(naujasSlaptazodis.getText().toString())) {
                    naujasSlaptazodis.setError(getResources().getString(R.string.error_invalid_password));
                } else if (!checkEmail(naujasElpastas.getText().toString())) {
                    naujasElpastas.setError(getResources().getString(R.string.error_invalid_email));
                }

                else if (cancel){
                    focusView.requestFocus();

                } else {
                    //
                    // Be klasės
                    // patikrina ar viskas gerai suvesta ir tada i konstruktoriu
//                    NaujasVartotojas naujasUseris = new NaujasVartotojas(naujasVardas.getText().toString(),
//                            naujasSlaptazodis.getText().toString(), naujasElpastas.getText().toString());
//
//                    Toast.makeText(RegisterActivity.this,
//                            naujasUseris.getVardas() + "\n" +
//                                    naujasUseris.getSlaptazodis() + "\n" +
//                                    naujasUseris.getElPastas(),
//
//                            Toast.LENGTH_SHORT).
//                            show();
                    //Toliau naudojant klasę
                    Registracija naujaReg = new Registracija(naujasVardas.getText().toString(), naujasSlaptazodis.getText().toString(), naujasElpastas.getText().toString());
                    registerUser(naujaReg.getNaujasVardas(), naujaReg.getNaujasSlaptazodis(), naujaReg.getNaujasElpastas());
                    Toast.makeText(RegisterActivity.this, naujaReg.getNaujasVardas() + "\n" + naujaReg.getNaujasSlaptazodis() + "\n" + naujaReg.getNaujasElpastas(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }


            }
            /* vartotojo validacija*/


        });
    }
    private void registerUser(String username, String password, String email) {
        String urlSuffix = "?username="+username+"&password="+password+"&email="+email;
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Prašome palaukti",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    // byethost naudoja antibot sistema, todel reikia kiekvienam rankutėmis suvesti cookie turinį,
                    // kuris pas kiekviena bus skirtingas. kaip tai padaryti zemiau nuoroda
                    // http://stackoverflow.com/questions/31912000/byethost-server-passing-html-values-checking-your-browser-with-json-string
                    //con.setRequestProperty("Cookie", "__test=THE_CONTENT_OF_YOUR_COOKIE_HERE; expires=2038 m. sausio 1 d., penktadienis 01:55:55; path=/");
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }

    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }



}