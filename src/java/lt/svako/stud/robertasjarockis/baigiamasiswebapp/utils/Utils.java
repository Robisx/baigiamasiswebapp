/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.utils;

import com.google.gson.Gson;
import java.util.List;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vartotojas;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers.VartotojasManager;

/**
 *
 * @author User1
 */
public class Utils {
    public static List<Vartotojas> authenticate(String user,String pass){
        VartotojasManager vm = new VartotojasManager();
        List<Vartotojas> list = null;
        list = vm.getVartotojas(user);
        if (pass.equals(list.get(0).getSlaptazodis())){
            return list;
        }else {
            return null;
        }
    }
    public static Vartotojas parseVartotojas(String parse){
        Gson gson = new Gson();
        return gson.fromJson(parse, Vartotojas.class);
    
}
}
