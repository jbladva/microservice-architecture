package com.jb.school.exception;

public class SchoolNotFoundException extends RuntimeException{

    SchoolNotFoundException(){
        super();
    }

    public SchoolNotFoundException(String message){
        super(message);
    }
}
