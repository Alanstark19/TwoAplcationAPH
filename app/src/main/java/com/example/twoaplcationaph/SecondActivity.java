package com.example.twoaplcationaph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    //mensaje mediante clave-valor, es public para poder usarla también en la MainActivity
    public static final String EXTRA_REPLY = "com.example.twoaplicationaph.extra.REPLAY";
    //Creamos variable de tipo EditText para guardar el msj que escriba el usuario
    private EditText mReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // creamos un objeto intent y usamos el método getIntent que nos devolvera un intent
        // si es que hay alguno creado
        Intent intent = getIntent();
        //Obtenemos mediante la primera activity el mensaje de nuestra variable clave-valor
        // el cual es el id del mensaje adicional
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
                                        //text_message es el id de la caja de texto donde se
                                        //escribirá el msj recibido de la MainActivity
        TextView textView = findViewById(R.id.text_message);
        //asignamos la variable con el msj recuperado con el método .set
        textView.setText(message);
                                //editText_second es el id de la caja de texto donde se
                                //escribió el msj de respuesta
        mReplay = findViewById(R.id.editText_second);
    }//fin del método onCreate

    /**
     * Método para regresar a la MainActivity
     * @param view objeto de tipo View
     */
    public void returnReply(View view) {
        //obtenemos la cadena de la variable mReply
        String reply = mReplay.getText().toString();
        //el intent nos ayudará a pasar de una activity a otra
        Intent replyIntent = new Intent();
        /*método que recibe una llave en String para identificar lo que le llegará a la otra activity*/
                                //objeto editText(reply)/sacamos el msj que escribio el usuario
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();//cerramos la activity
    }//fin del método returnReply
}//fin de la clase SecondActivity