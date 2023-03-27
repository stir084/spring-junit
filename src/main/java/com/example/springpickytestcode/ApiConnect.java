package com.example.springpickytestcode;

import org.springframework.stereotype.Component;

@Component
public class ApiConnect {

    public static Boolean connect(){
        System.out.println("머야");
        if(false){
            System.out.println("연결 성공");
            return true;
        } else {
            System.out.println("연결 실패");
            return false;
        }
    }

}
