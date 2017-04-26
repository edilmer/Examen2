package com.edilmer.examen.Parser;

import com.edilmer.examen.Models.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edil ch on 26/04/2017.
 */

public class Json {
    //obtener datos
    public static List<User> getData(String content) throws Exception {
        JSONArray myArray = new JSONArray(content);
        List<User> myPost = new ArrayList<>();
        for (int i=0; i<myArray.length(); i++){
            JSONObject item = myArray.getJSONObject(i);
            User user = new User();
            user.setName(item.getString("name"));
            user.setUsername(item.getString("username"));
            user.setEmail(item.getString("email"));
            myPost.add(user);
        }
        return myPost;
    }
}
