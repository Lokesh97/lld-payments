package com.payment.model;

public class OutputPrinter {

    public void printMsg(String msg){
        System.out.println(msg);
    }
    public void success(){
        System.out.println("Success !!");
    }

    public void failure(){
        System.out.println("Failure !!");
    }
}
