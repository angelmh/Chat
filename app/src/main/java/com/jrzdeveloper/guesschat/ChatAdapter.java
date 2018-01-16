package com.jrzdeveloper.guesschat;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 30/10/2017.
 */

public class ChatAdapter extends ArrayAdapter<Chat> {

    private ArrayList<Chat> chatList;
    private Context context;
    private int layoutId;

    public ChatAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Chat> objects) {
        super(context, resource, objects);

        this.context = context;
        this.layoutId = resource;
        chatList = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =  inflater.inflate(R.layout.chat_list_item,null);
            holder = new ViewHolder();

            holder.preguntaTextView = (TextView) convertView.findViewById(R.id.pregunta_txtView);
            holder.respuestaTextView = (TextView) convertView.findViewById(R.id.respuesta_txtView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Chat chat= chatList.get(position);
        holder.respuestaTextView.setText( chat.getRespuesta() );
        holder.preguntaTextView.setText( chat.getPregunta() );

        return convertView;
    }

    private class ViewHolder
    {
        public TextView respuestaTextView;
        public TextView preguntaTextView;
    }

}
