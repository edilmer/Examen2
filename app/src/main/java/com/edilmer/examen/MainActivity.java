package com.edilmer.examen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.edilmer.examen.Adapters.PostAdapter;
import com.edilmer.examen.Adapters.UserAdapter;
import com.edilmer.examen.Models.User;
import com.edilmer.examen.Parser.Json;

import java.io.IOException;
import java.net.URL;
import java.util.List;

//Actividad principal
public class MainActivity extends AppCompatActivity {
    ProgressBar cargador;
    Button boton;
    //List<Post> myPost;
    List<User> myPost;
    RecyclerView recyclerView;
    PostAdapter adapter;
    UserAdapter adapterUser;
    @Override
//En crear
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargador = (ProgressBar) findViewById(R.id.cargador);
        boton = (Button) findViewById(R.id.boton);
        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
// Permite manegar los componentes en un RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
// Establecer la orientacion en vertical
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
// Asignar a orientacion a mi RecyclerView
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    //está en línea
    public Boolean isOnLine(){
        ConnectivityManager connec = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connec.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }
    }
    //cuando en el botón de clic
    public void onClickButton(View view){
        if (isOnLine()){
            MyTask task = new MyTask();
            task.execute("https://jsonplaceholder.typicode.com/users");
        }else {
            Toast.makeText(this, "Sin conexión", Toast.LENGTH_SHORT).show();
        }
    }
    public void cargarDatos(){
// Crear un objeto de tipo "PostAdapter" y retorna el item de mi layout
        (item.xml)
//adapter = new PostAdapter(getApplicationContext(), myPost);
                adapterUser = new UserAdapter(getApplicationContext(), myPost);
// inyectar el item en mi RecyclerView
        recyclerView.setAdapter(adapterUser);
    }
    //my tarea tarea asincrona
    private class MyTask extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            cargador.setVisibility(View.VISIBLE);
        }
        @Override
//hace en el fondo
        protected String doInBackground(String... params) {
            String content = null;
            try {
                content = HttpManager.getData(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }
        @Override
//Sobre la actualización del progreso
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
        @Override
//En la ejecución posterior
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                myPost = Json.getData(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cargarDatos();
            cargador.setVisibility(View.GONE);
        }
    }
}
