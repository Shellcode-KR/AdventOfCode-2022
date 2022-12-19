import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class dia3 {
    Map<Character, Integer> alphabetValues = new HashMap<>();
    public static void main(String[] args) {

        dia3 d3 = new dia3();
        d3.asignarValores();
        d3.lectura();
    }
    public void lectura(){
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("C:\\Users\\hack_\\Documents\\cursos\\Advent of code\\2022\\DiA3\\dia3.txt");

            if(archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                String a="";
                String b="";
                String c="";
                int numduende=1;
                int suma=0;
                while ((cadena=lector.readLine()) !=null){
                    if (cadena.isEmpty()){
                        //suma=0;
                    }else{
                        if (numduende==1){

                            a=cadena;
                        }
                        if (numduende==2){

                            b=cadena;
                        }
                        if (numduende==3){
                            numduende=0;
                            c=cadena;

                            int valoree = calcularError(findErrorCadenas(a,b,c));
                            suma+=valoree;
                        }
                        numduende++;




                    }

                }
                System.out.println(suma);
            }else{
                System.out.println("El archivo aun no esta listo para su lectura");
            }


        }catch (Exception e){
            System.out.println("Ocurrio un Error,cierre el archivo si lo tiene abierto");
            e.printStackTrace();
        }
    }
    public char findError(String cadena){
        //dividir la cadena en dos partes iguales
        char error='.';
            int mitad = (int)cadena.length()/2;
            String[] compartimientos = new String[2];
            compartimientos[0]=cadena.substring(0,mitad);
            compartimientos[1]=cadena.substring(mitad,cadena.length());
        //ver que caracter esta en el los dos compartimientos
        for (int i = 0; i <compartimientos[0].length() ; i++) {
            char c =compartimientos[0].charAt(i);
            if (error!='.'){
                break;
            }
            for (int j = 0; j <compartimientos[1].length() ; j++) {
                if ( c==compartimientos[1].charAt(j) ) {
                    error=c;
                    break;
                }
            }
        }

        return error;
    }
    public char findErrorCadenas(String primer,String segundo, String tercer){
        char insignia = '.';

        for (int i = 0; i <primer.length() ; i++) {
            char c =primer.charAt(i);
            if (insignia!='.'){
                break;
            }
            for (int j = 0; j <segundo.length() ; j++) {
                if ( c==segundo.charAt(j) ) {
                    for (int k = 0; k < tercer.length(); k++) {
                        if (c==tercer.charAt(k)){
                            insignia=c;

                        }
                    }
                }
            }


        }
        return insignia;
    }
    public int calcularError(char error){

        int valorerror = alphabetValues.get(error);
        return valorerror;
    }
    public void asignarValores(){

        alphabetValues.put('a', 1);
        alphabetValues.put('b', 2);
        alphabetValues.put('c', 3);
        alphabetValues.put('d', 4);
        alphabetValues.put('e', 5);
        alphabetValues.put('f', 6);
        alphabetValues.put('g', 7);
        alphabetValues.put('h', 8);
        alphabetValues.put('i', 9);
        alphabetValues.put('j', 10);
        alphabetValues.put('k', 11);
        alphabetValues.put('l', 12);
        alphabetValues.put('m', 13);
        alphabetValues.put('n', 14);
        alphabetValues.put('o', 15);
        alphabetValues.put('p', 16);
        alphabetValues.put('q', 17);
        alphabetValues.put('r', 18);
        alphabetValues.put('s', 19);
        alphabetValues.put('t', 20);
        alphabetValues.put('u', 21);
        alphabetValues.put('v', 22);
        alphabetValues.put('w', 23);
        alphabetValues.put('x', 24);
        alphabetValues.put('y', 25);
        alphabetValues.put('z', 26);

        alphabetValues.put('A', 27);
        alphabetValues.put('B', 28);
        alphabetValues.put('C', 29);
        alphabetValues.put('D', 30);
        alphabetValues.put('E', 31);
        alphabetValues.put('F', 32);
        alphabetValues.put('G', 33);
        alphabetValues.put('H', 34);
        alphabetValues.put('I', 35);
        alphabetValues.put('J', 36);
        alphabetValues.put('K', 37);
        alphabetValues.put('L', 38);
        alphabetValues.put('M', 39);
        alphabetValues.put('N', 40);
        alphabetValues.put('O', 41);
        alphabetValues.put('P', 42);
        alphabetValues.put('Q', 43);
        alphabetValues.put('R', 44);
        alphabetValues.put('S', 45);
        alphabetValues.put('T', 46);
        alphabetValues.put('U', 47);
        alphabetValues.put('V', 48);
        alphabetValues.put('W', 49);
        alphabetValues.put('X', 50);
        alphabetValues.put('Y', 51);
        alphabetValues.put('Z', 52);
    }
}
