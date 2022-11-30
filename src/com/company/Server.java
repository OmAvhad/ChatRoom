package com.company;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(6669);
            System.out.println("\t \t Server Started");

            Socket s=ss.accept();//establishes connection   
            System.out.println("\t \t New Joined !");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str1="", str2="";
            while(!str1.equals("STOP")){
                str2 = din.readUTF();
                System.out.println("\n");
                System.out.println("Client says > "+str2);
                System.out.println("\n");
                System.out.print("\t \t \t \t Reply > ");
                str1 = br.readLine();
                dout.writeUTF(str1);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}  