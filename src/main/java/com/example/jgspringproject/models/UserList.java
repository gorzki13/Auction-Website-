package com.example.jgspringproject.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    public static int uid=0;
    static List<Userid>list;
    public static List<Userid> getList() {
        return list;
    }

    public static void setList(List<Userid> list) {
        UserList.list = list;
    }

    public static int getUid() {
        return uid;
    }

    public static void setUid(int uid) {
        UserList.uid = uid;
    }


static {

   list = new ArrayList<>();

    Userid u1=new Userid(uid++,"aa","bb",LocalDate.now(),50.25f,"wiertarka","narzedzia",1);
    Userid u2=new Userid(uid++,"aa","bb", LocalDate.now(),50,"wiertarka","narzedzia",1);
    Userid u3=new Userid(uid++,"aa","bb",LocalDate.now(),50,"wiertarka","narzedzia",1);

    list.add(u1);
    list.add(u2);
    list.add(u3);
}

}
