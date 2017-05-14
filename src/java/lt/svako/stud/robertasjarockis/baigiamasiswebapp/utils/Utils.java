/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.utils;

import com.google.gson.*;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vartotojas;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vieta;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.VartotojasManager;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author User1
 */
public class Utils {

    public static List<Vartotojas> authenticate(String user, String pass) {
        VartotojasManager vm = new VartotojasManager();
        List<Vartotojas> list = null;
        list = vm.getVartotojas(user);
        if (pass.equals(list.get(0).getSlaptazodis())) {
            return list;
        } else {
            return null;
        }
    }

    public static Vartotojas parseVartotojas(String parse) {
        Gson gson = new Gson();
        return gson.fromJson(parse, Vartotojas.class);
    }

    public static Vieta parseVieta(String parse) {
        GsonBuilder builder = new GsonBuilder();
       GsonHelper gh = new GsonHelper();
// Adapter to convert a Unix Long Time in Json to a java.util.Date object
        builder.registerTypeAdapter(byte[].class, new JsonDeserializer<byte[]>() {
            public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return Base64.decodeBase64(json.getAsJsonPrimitive().getAsString());
            }
        });

// Adapter to convert byte[] in a Java Object to a String in Json for UI to display image properly
        builder.registerTypeAdapter(byte[].class, new JsonSerializer<byte[]>() {
            public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(Base64.encodeBase64String(src));
            }
        });

        Gson gson = builder.create();
       // gson = new Gson();
        return gson.fromJson(parse, Vieta.class);
    }
}
