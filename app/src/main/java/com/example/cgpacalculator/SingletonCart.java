package com.example.cgpacalculator;

import java.util.ArrayList;

public class SingletonCart
{
    public ArrayList<ModelOrder> arr;
    private static SingletonCart ob=null;

    private SingletonCart()
    {
        arr=new ArrayList<>();
    }

    public static SingletonCart getInstance()
    {
        if(ob==null)
            ob=new SingletonCart();
        return ob;
    }
}
