package com.edilmer.examen.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edilmer.examen.Models.User;
import com.edilmer.examen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edil ch on 26/04/2017.
 */

//Adaptador de usuario
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User> myPost = new ArrayList<>();
    Context context;
    // Constructor de mi clase PostAdapter
    public UserAdapter(Context context, List<User> myPost) {
        this.myPost = myPost;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Vicular mi vista (item.xml) con la vista principal (activity_main.xml)
// Inyecta mi layout (item.xml) en la vista principal
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
// Crear un objeto de la subclase para manejar i asignar los componentes del
        layout (item.xml)
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// Lanza la vista en mi layout principal (activity_main)
// Establecer el valor de mi TextView con el valor del JSON
        holder.myText.setText(myPost.get(position).getUsername());
    }
    @Override
//Obtener conteo de elementos
    public int getItemCount() {
        return myPost.size();
    }
    // permite administrar mi vista en el RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView myImage;
        TextView myText;
        // Constructor de mi sub clase
        public ViewHolder(View item) {
            super(item);
            myImage = (ImageView) item.findViewById(R.id.logo);
            myText = (TextView) item.findViewById(R.id.txt_item);
        }
    }
}