package com.home.myapplication;

/**
 * Created by SONY on 10.01.2016.
 */
public class Operation {


    public double result;


    protected double add(String a, String b){

        result = Double.parseDouble(a) + Double.parseDouble(b);

        return result;
    }

    protected double multi(String a, String b) {

        result = Double.parseDouble(a) * Double.parseDouble(b);

        return  result;
    }

    protected double subtract(String a, String b){

        result = Double.parseDouble(a) - Double.parseDouble(b);

        return result;
    }

    protected double divide(String a, String b){

        result = Double.parseDouble(a) / Double.parseDouble(b);

        return result;
    }

    protected double percent(String a, String b){

        result = Double.parseDouble(a) * Double.parseDouble(b) / 100;

        return result;
    }

}
