/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.morse;

/**
 *
 * @author Cristhian Guti
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class CodigoMorse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String abecedario[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N","O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String morse[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..","----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};

        boolean fin = false;
        Scanner s = new Scanner(System.in);
        int opc = 0;
        System.out.println("Bienvendio al traductor morse");

        do {
            System.out.println("Ingrese una de las opciones");
            System.out.println("1) traducir español a morse");
            System.out.println("2)traducir morse a español ");
            System.out.println("3) salir");
            opc = pruebadato(s, 1, 3);
            s.nextLine();
            fin = procesaropcion(opc, s, abecedario, morse);

        } while (!fin);
    }

    public static boolean procesaropcion(int opc, Scanner s, String[] abecedario, String[] morse) {
      
        if (opc==1) {
            System.out.println("ingrese la frase a traducir");
            String frase = s.nextLine();
            String fraseATraducir = frase.toUpperCase();
            String mensajetraducido = frasemorse(fraseATraducir,abecedario,morse);
            System.out.println("Traduccion del mensaje a codigo morse: ");
            System.out.println(mensajetraducido);

        } else if (opc==2) {
            System.out.println("ingrese la frase a traducir en morse");
            String frase = s.nextLine();
            String mensajetraducido = morseFrase(frase,abecedario,morse);
            System.out.println("Traducion al español: ");
            System.out.println(mensajetraducido);
        } else if (opc==3) {
            return true;
        }
        return false;
    }
    public static String  morseFrase(String fraseATraducir, String[] abecedario, String[] morse){
        String mensajeEspañol="";
        String caracterMorse= "";
        int i= 0;
        do{
            boolean terminaCaracter = false;
            do{
               if(Character.toString(fraseATraducir.charAt(i)).equals(" ")){
                   terminaCaracter =true;
               }else{
                   caracterMorse+=Character.toString(fraseATraducir.charAt(i));
                   i++;
           
              }  
            }while((!terminaCaracter)&&(i<fraseATraducir.length()));
            
            int j = 0;
            boolean termina = false;
       
                do {
                    if(caracterMorse.equals(morse[j])){
                        mensajeEspañol += abecedario[j];
                        termina = true;
                    }
                    j++;
                    if(j==morse.length) {
                        if(!termina) {
                            termina=true;
                        }
                    }
                }while(!termina);
                  
            caracterMorse="";
            i++;
            try{
            if(Character.toString(fraseATraducir.charAt(i)).equals(" ")){
                if(Character.toString(fraseATraducir.charAt(i+1)).equals(" ")){
                mensajeEspañol += "   ";
                i+=2;
            }
            }
            }catch(StringIndexOutOfBoundsException e){
                
            }catch (Exception e){
                
            }
        }while(i<fraseATraducir.length());
        
        return mensajeEspañol;
        
        
    }
        
      public static String frasemorse(String fraseATraducir, String[] abecedario, String[] morse) {
        String mensajemorse = "";
            for (int i = 0; i < fraseATraducir.length();i++) {
            int j = 0;
            boolean termina = false;
            if (Character.toString(fraseATraducir.charAt(i)).equals(" ")) {
                mensajemorse += " ";
            } else {
                do {
       if (Character.toString(fraseATraducir.charAt(i)).equals(abecedario[j])){
                   mensajemorse += morse[j] +"  ";
                     termina = true;
                    }
                    j++;
                    if (j==abecedario.length) {
                        if (!termina) {
                            termina = true;
                        }
                    }
                }while(!termina);
            }
            
        }
        return mensajemorse;
        
        
    }

    public static int pruebadato(Scanner s, int min, int max) {
        int valor = 0;
        boolean error = false;
        do {
            error = false;
            try {
                valor = s.nextInt();
                if (!((valor >= min) && (valor <= max))) {
                    System.out.println("valor mal ingresado");
                    System.out.println("El valor debe estar entre" + min + "y" + max);
                    error = true;

                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de dato mal ingresado. Se esperaba un numero");
                error = true;
                s.nextLine();
           
           } 
            catch (Exception e){
                System.out.println("Erro inesperado" + e);
                error = true;

            }
        } while (error);
        return valor;

    }
    }

  
    