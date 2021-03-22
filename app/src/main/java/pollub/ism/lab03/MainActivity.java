package pollub.ism.lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText messageOutgoing = null, messageIncoming = null;
    public static String MESSAGE_KEY= "Przekazywana informacja";
    public static int REQUEST_CODE = 123;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageOutgoing =  (EditText) findViewById(R.id.wiadomoscWysylanie);
        messageIncoming =  (EditText) findViewById(R.id.wiadomoscOdbieranie);

        messageIncoming.setEnabled(false);
    }

    public void startSecond(View view){

        String message = messageOutgoing.getText().toString();

        Intent intent = new Intent(this,DrugaAktywnosc.class);
        intent.putExtra(MESSAGE_KEY,message);
        this.startActivityForResult(intent,REQUEST_CODE);
    }

    public void startThird(View view){
        Intent intent = new Intent(this, TrzeciaAktywnosc.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == REQUEST_CODE){
            String message = data.getStringExtra(MESSAGE_KEY);
            messageIncoming.setText(message);
        }
    }
}