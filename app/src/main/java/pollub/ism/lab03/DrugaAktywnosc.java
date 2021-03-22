package pollub.ism.lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DrugaAktywnosc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga_aktywnosc);

        if(savedInstanceState == null) {

            Intent intent = getIntent();
            String message = intent.getStringExtra(MainActivity.MESSAGE_KEY);

            EditText textField = (EditText) findViewById(R.id.wiadomoscOdbieranie1);
            textField.setText(message);
            textField.setEnabled(false);
        }
    }

    public void goBack(View view){

        EditText textField = (EditText) findViewById(R.id.wiadomoscWysylanie1);
        String message = textField.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(MainActivity.MESSAGE_KEY,message);

        setResult(MainActivity.REQUEST_CODE, intent);

        finish();
    }


}