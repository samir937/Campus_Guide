package com.example.FoodStore;

import android.app.Activity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.ArrayList;

public class Payment implements PaymentResultListener
{
    String uname,uaddress,uphone;

    public Payment(String uname, String uaddress, String uphone) {
        this.uname = uname;
        this.uaddress = uaddress;
        this.uphone = uphone;
    }

    public void startPayment(Activity av)
    {
        PlaceOrder();
        Checkout checkout = new Checkout();
        final Activity activity = av;
        try
        {
            JSONObject options = new JSONObject();
            options.put("name", "Sachin");
            options.put("description", "Testing");
            options.put("currency", "INR");
            /*
              Amount is always passed in currency subunits
              Eg: "500" = INR 5.00
            */
            options.put("amount", "1000");
            checkout.open(activity, options);
        }
        catch(Exception e)
        {
            System.out.print("Error");
        }
    }

    @Override
    public void onPaymentSuccess(String s)
    {

    }

    @Override
    public void onPaymentError(int i, String s)
    {

    }

    public void PlaceOrder()
    {
        DatabaseReference data_ref= FirebaseDatabase.getInstance().getReference("Orders");
        ArrayList<ModelOrder> arr=SingletonCart.getInstance().arr;
        for(int i=0;i<arr.size();i++)
        {
            ModelOrder ob=arr.get(i);
            ob.setUname(uname);
            ob.setUphone(uphone);
            ob.setUaddress(uaddress);
            String uploadid=data_ref.push().getKey();
            data_ref.child(uploadid).setValue(ob);
        }
    }
}
