import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* Estrategia Encriptada
*   A: PIEDRA   B: PAPEL    C: TIJERA
*
* opcion a elegir
*   x: piedra   y: papel    z: tijera
* puntos eleccion de mano:
*   1 piedra    2 papel     3 tijera
* puntos de victoria:
*   0 derrota   3 empate    6 victoria
*
*
*
* */

public class dia2 {
    public static void main(String[] args) {
        dia2 d2 = new dia2();
        d2.lectura();
    }
    public void lectura(){
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("C:\\Users\\hack_\\Documents\\cursos\\Advent of code\\2022\\DiA2\\dia2.txt");

            if(archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                int suma=0;
                while ((cadena=lector.readLine()) !=null){
                    if (cadena.isEmpty()){
                        //suma=0;
                    }else{

                        cadena = cadena.toLowerCase();
                        String[] opciones=cadena.split(" ");

                        if (opciones[1].equals("x")){
                            suma+=1;
                            if (opciones[0].equals("a")){
                                suma+=3;
                            }
                            if (opciones[0].equals("b")){
                                suma+=0;
                            }
                            if (opciones[0].equals("c")){
                                suma+=6;
                            }
                        }
                        if (opciones[1].equals("y")){
                            suma+=2;
                            if (opciones[0].equals("a")){
                                suma+=6;
                            }
                            if (opciones[0].equals("b")){
                                suma+=3;
                            }
                            if (opciones[0].equals("c")){
                                suma+=0;
                            }
                        }
                        if (opciones[1].equals("z")){
                            suma+=3;
                            if (opciones[0].equals("a")){
                                suma+=0;
                            }
                            if (opciones[0].equals("b")){
                                suma+=6;
                            }
                            if (opciones[0].equals("c")){
                                suma+=3;
                            }
                        }


                    }

                }
                System.out.println(suma);
            }else{
                System.out.println("El archivo aun no esta listo para su lectura");
            }


        }catch (Exception e){
            System.out.println("Ocurrio un Error,cierre el archivo si lo tiene abierto");
        }
    }

}
