package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("client partito...");
        Scanner scanner = new Scanner(System.in);
        Socket s= new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String operazione;
        String parola;
        String parolaFinale;
        do{
            System.out.println("inserisci l'operazione:");
            System.out.println("1: maiuscolo, 2:minuscolo, 3:inverso, 4:conta, 0:exit");
            operazione= scanner.nextLine();

            if(operazione.equals("0")){
                out.writeBytes(operazione+ '\n');
                s.close();

            }else{
                System.out.println("inserisci la parola:");
                parola= scanner.nextLine();
                out.writeBytes(operazione+ '\n');
                out.writeBytes(parola+ '\n');

                parolaFinale= in.readLine();
                System.out.println(parolaFinale);
            }
        
        }while(!operazione.equals("0"));

    }
}