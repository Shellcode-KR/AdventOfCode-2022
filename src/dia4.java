import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class dia4 {

    public static void main(String[] args) {
        System.out.println("Hola");
        dia4 d4 = new dia4();
        d4.lectura();
    }
    public void lectura(){
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("C:\\Users\\hack_\\Documents\\cursos\\Advent of code\\2022\\DiA4\\dia4.txt");

            if(archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                int suma=0;
                while ((cadena=lector.readLine()) !=null){
                    if (cadena.isEmpty()){



                    }else{
                        boolean contieneSala =superponen(separarCadena(cadena));
                        if(contieneSala){
                            suma+=1;
                        }

                    }

                }
                System.out.println(suma);
            }else{
                System.out.println("El archivo aun no esta listo para su lectura");
            }


        }catch (Exception e){
            System.out.println("Ocurrio un Error");
        }
    }
    public int[] separarCadena(String cadena){
        String[] parUno = cadena.split(",");

        String[] duendeUno = parUno[0].split("-");
        String[] duendeDos = parUno[1].split("-");

        int[] areas = new int[4];
        areas[0]= Integer.parseInt(duendeUno[0]);
        areas[1]= Integer.parseInt(duendeUno[1]);
        areas[2]= Integer.parseInt(duendeDos[0]);
        areas[3]= Integer.parseInt(duendeDos[1]);

        return areas;
    }
    public boolean contieneAsignacion(int[] areas){
        boolean contiene=false;

        if(areas[0]>=areas[2] && areas[1]<=areas[3]){
            contiene=true;
        }
        if(areas[2]>=areas[0] && areas[3]<=areas[1]){
            contiene=true;
        }

        return contiene;
    }
    public boolean superponen(int[] areas){
        boolean contiene=false;

        if(areas[1]>=areas[2] && areas[0]<=areas[3]){
            contiene=true;
        }


        return contiene;
    }
}
