package com.epam.Products;

import com.epam.Exceptions.MyIOEforstring;
import com.epam.Exceptions.MyIOException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by User on 11.11.2015.
 */
public class IOStreams {
    static Scanner in = new Scanner(System.in);
    public static int scanNumbers ()throws MyIOException{
        try{
        int number = in.nextInt();
        return number;}catch (Exception e){
            throw new MyIOException();
        }

    }


    public static String scanMessage () throws MyIOEforstring {
        in.nextLine();
        try {
            String message = in.nextLine();
            return message;
        }catch (Exception e){
            throw new MyIOEforstring();
        }
    }
    public static double scanDouble(){

        double number = in.nextDouble();
        return number;
    }


    public static void close() {
        Scanner in = new Scanner(System.in);
        in.close();
    }
}
