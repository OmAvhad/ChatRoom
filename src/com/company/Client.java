package com.company;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6669);
            System.out.println("\t \t Connected !");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str1="",str2="";

            while(!str1.equals("STOP")){
                System.out.println("\n");
                System.out.print("\t \t \t \tReply >");
                str1 = br.readLine();
                System.out.println("\n");
                dout.writeUTF(str1);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server says >"+str2);
            }
            dout.close();
            s.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}  