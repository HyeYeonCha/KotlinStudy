package com.example.kotlinstudy.exception;

import com.example.kotlinstudy.KotlinThrow;

import java.io.IOException;

public class JavaThrow {

    public void throwIOException () throws IOException {
        throw new IOException("체크드 익셉션인 IOException 발생");
    }

    public static void main(String[] args) throws IOException {
//        JavaThrow javaThrow = new JavaThrow();
//        try {
//            javaThrow.throwIOException();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // try catch 없어도 사용가능
        KotlinThrow kotlinThrow = new KotlinThrow();
        kotlinThrow.throwIOException();
    }
}
