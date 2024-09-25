package es.carrillo.myfisrtapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //muestra mensaje de log
        Log.i("Ciclo de vida", "Ha entrado en el método onCreate");

        EditText etName = findViewById(R.id.etname);
        EditText etSurName = findViewById(R.id.etsurname);
        Button btnSend = findViewById(R.id.buttonSend);
        Button btnClean = findViewById(R.id.buttonClean);


        //asignamos un evento al boton

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Para navegar a otra activity necesitamos crear un intent(contextActitvity)
                //ponemos primero la clase actual y a cual queremos navegar

                Intent intentDetailActivity = new Intent(MainActivity.this,DetailsActivity.class);

                intentDetailActivity.putExtra("name",etName.getText().toString());
                intentDetailActivity.putExtra("surname",etSurName.getText().toString());

                //log para ver si se han enviado bien los valores
                Log.i("Valores", "Nombre: "+etName.getText()+" Apellido: "+etSurName.getText());


                //metodo para abrir otra activity
                startActivity(intentDetailActivity);


            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cuando pulsemos el boton el texto de los edittext se borrara
                etName.setText("");
                etSurName.setText("");

            }
        });
    }

    @Override
    protected void onStart(){

        super.onStart();
        Log.i("Ciclo de vida", "Ha entrado en el método onStart");
    }

    @Override
    protected void onResume(){

        super.onResume();
        Log.i("Ciclo de vida", "Ha entrado en el método onResume");
    }

    @Override
    protected void onPause(){

        super.onPause();
        Log.i("Ciclo de vida", "Ha entrado en el método onPause");
    }

    @Override
    protected void onStop(){

        super.onStop();
        Log.i("Ciclo de vida", "Ha entrado en el método onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida","Ha entrado en el metodo onDestroy");
    }
}