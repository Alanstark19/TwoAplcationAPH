package com.example.twoaplcationaph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variable String para mostrar el mensaje en la consola
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    //mensaje mediante clave-valor, es public para poder usarla también en la SecondActivity
    public static final String EXTRA_MESSAGE = "com.example.twoaplicationaph.extra.MESSAGE";
    //Creamos variable de tipo EditText para guardar el msj que escriba el usuario
    private EditText mMessageEditText;
    //variable para saber cuando se reciba una respuesta
    public static final int TEXT_REQUEST = 1;
    //variables textView para el msj de respuesta
    private TextView mReplyHeaderTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtenemos lo que fue escrito en el EditText de la mainActivity
        // y lo guardamos en mMessageEditText
        mMessageEditText = findViewById(R.id.editText_main);
    //obtenemos lo que fue escrito en el EditText de la mainActivity
        // y lo guardamos en mReplyHeaderTextView y mReplyTextView
        mReplyHeaderTextView = findViewById(R.id.text_header_reply);
                                    //text_message_reply es el id de la caja de texto donde se
                                    //escribió el msj
        mReplyTextView = findViewById(R.id.text_message_reply);
    }//fin  del método onCreate

    /**
     * método que llamará el boton al darle clic
     * @param view objeto de tipo View
     */
    public void launchSecondActivity(View view) {
        //mandamos por la consola "Button clicked"
        Log.d(LOG_TAG, "Button clicked");
        //obtenemos la cadena de la variable mMessageEditText
        String message = mMessageEditText.getText().toString();
    //el intent nos ayudará a pasar de una activity a otra
     //clase  objeto    (this es la activity de la que parte)(a qué activity queremos ir+.class)
                                                                //dando el nombre del archivo de
                                                                //la parte lógica del activity al
                                                                // que queremos ir
        Intent intent = new Intent(this, SecondActivity.class);
 /*método que recibe una llave en String para identificar lo que le llegará a la otra activity*/
                             //objeto editText (message)/sacamos el msj que escribio el usuario
        intent.putExtra(EXTRA_MESSAGE, message);

        //método que lanza un activity; recibe un objeto intent para saber que activity ejecutar
        startActivityForResult(intent, TEXT_REQUEST);
    }//fin del método launchSecondActivity

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                mReplyHeaderTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}