package com.example.jgspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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




}

}
