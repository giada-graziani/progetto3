package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread {
    Socket s;

    public MioThread(Socket s){
        this.s=s;
    }
    public void run(){
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String operazione;
            String parola;
            String parolaFinale;
            do{
                
                operazione= in.readLine();
                if(operazione.equals("0")){
                    s.close();
                    
                    System.out.println("...server terminato");
                }else{
                    parola= in.readLine();
                    switch (operazione) {
                        case "1":
                            parolaFinale=parola.toUpperCase();
                            out.writeBytes(parolaFinale + "\n");
                            break;

                        case "2":
                            parolaFinale=parola.toLowerCase();
                            out.writeBytes(parolaFinale + "\n");
                        break;

                        case "3":
                            StringBuilder parolaRovesciata= new StringBuilder(parola);
                            parolaRovesciata.reverse();
                            out.writeBytes(parolaRovesciata + "\n");
                        break;

                        case "4":
                            parolaFinale= "" + parola.length();
                            out.writeBytes(parolaFinale + "\n");
                        
                        break;
                    
                        default:
                            System.out.println("ERRORE");
                            break;
                    }
                }
                
            }while(!operazione.equals("0"));




        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
}
