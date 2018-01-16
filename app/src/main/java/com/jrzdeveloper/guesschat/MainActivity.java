package com.jrzdeveloper.guesschat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Chat> chatList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView chatListView = (ListView) findViewById(R.id.chat_ListView);
        final Button btn = (Button)findViewById(R.id.enviar_btn);
        final EditText msj = (EditText) findViewById(R.id.mensaje_edit_text);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( (msj.getText().toString().trim().length() !=0) )
                {
                    if( msj.getText().toString().contains("¿") && msj.getText().toString().contains("?") )
                    {
                        final Respuesta res = new Respuesta();
                        final Chat chat = new Chat(msj.getText().toString(),res.getRespuesta());
                        chatList.add(chat);
                        ChatAdapter eaAdapter = new ChatAdapter(MainActivity.this, R.layout.chat_list_item, chatList);
                        chatListView.setAdapter(eaAdapter);
                        eaAdapter.notifyDataSetChanged();
                        msj.setText("");
                    }
                    else
                        Toast.makeText(MainActivity.this,"No envio pregunta",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class Respuesta {
        private String respuesta;
        private HashMap<Integer,String> map;

        public Respuesta() {
            map = new HashMap<Integer, String>();
            map.put(1,"Si");
            map.put(2,"No");
            map.put(3,"Pregunta de nuevo");
            map.put(4,"Es muy probable");
            map.put(5,"No lo creo");
        }

        public String getRespuesta() {
            Random random = new Random();
            int max=5, min=1;
            return ( map.get(random.nextInt(max - min + 1) + min) );
        }
    }
}
