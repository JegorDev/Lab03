package pollub.ism.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TrzeciaAktywnosc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trzecia_aktywnosc);
    }

    public void viewPage(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://tomasznowicki.gitbook.io/ism/"));

        try{
            startActivity(intent);
        }catch (ActivityNotFoundException exception){
            Toast.makeText(this,"Brak przeglądarki",Toast.LENGTH_LONG).show();
        }
    }

    public void call(View view){

        Intent intent = new Intent(Intent.ACTION_DIAL);

        intent.setData(Uri.parse("tel:" + 226952900));

        try{
            startActivity(intent);
        }catch (ActivityNotFoundException exception){
            Toast.makeText(this,"Brak możliwości dzwonienia",Toast.LENGTH_LONG).show(); 
        }
    }
}