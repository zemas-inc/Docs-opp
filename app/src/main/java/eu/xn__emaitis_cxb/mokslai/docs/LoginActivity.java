package eu.xn__emaitis_cxb.mokslai.docs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsernameView;
    private EditText mPasswordView;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);

        Button register=(Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(LoginActivity.this, "Paspaustas 'Sukurti' mygtukas", Toast.LENGTH_SHORT).show();
                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);
            }

        });

        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                mUsernameView.setError(null);
                mPasswordView.setError(null);

                username =mUsernameView.getText().toString();
                password =mPasswordView.getText().toString();

                //Toast.makeText(LoginActivity.this, username+" "+password,
                //Toast.LENGTH_LONG).show();
                boolean cancel = false;
                View focusView = null;
                if (!isValid(username)) {
                    mUsernameView.setError(getString(R.string.error_invalid_username));
                    focusView=mUsernameView;
                    cancel=true;
                }
                if (!isValid(password)){
                    mPasswordView.setError(getString(R.string.error_invalid_password));
                    focusView=mPasswordView;
                    cancel = true;
                }
                if (cancel) {
                    focusView.requestFocus();
                } else {
                    Toast.makeText(LoginActivity.this, "Paspaustas prisijungti mygtukas", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }

        });
    }//oncreate

    private boolean isValid(String credentials) {
    final String CREDENTIALS_PATTERN = "^([0-9a-zA-z]{3,15})+$";
            Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

            Matcher matcher = pattern.matcher(credentials);
            return matcher.matches();

    }
}
