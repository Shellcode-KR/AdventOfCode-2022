
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class dia5 {
    private ArrayList<Deque<String>> pilas = new ArrayList<Deque<String>>();
    //para definir una matriz primero van las filas y despues las columnas
    private int[] matriz = {8,9};
    public static void main(String[] args) {
        dia5 d5 = new dia5();
        d5.creacionPilas();
        d5.lectura();
    }

    public void lectura(){
        FileReader archivo;
        BufferedReader lector;

        int linea=0;
        try {
            archivo = new FileReader("C:\\Users\\hack_\\Documents\\cursos\\Advent of code\\2022\\DiA5\\dia5.txt");

            if(archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                int suma=0;
                int indiceCaracter=1;

                while ((cadena=lector.readLine()) !=null){
                    if (cadena.isEmpty()){

                    }else{
                        if (linea<matriz[0]) {

                            for (int i = 0; i <matriz[1] ; i++) {
                                if(cadena.charAt(indiceCaracter)==' '){

                                }else{
                                    pilas.get(i).add(String.valueOf(cadena.charAt(indiceCaracter)));
                                }

                                indiceCaracter+=4;
                            }
                            indiceCaracter=1;
                        }else if (linea> matriz[0]){
                            String[] partes= cadena.split(" ");
                            int cuantos = Integer.parseInt(partes[1]);
                            int origen = ( Integer.parseInt(partes[3]) )-1;
                            int destino =( Integer.parseInt(partes[5]) )-1;

                            for (int i = 0; i < cuantos; i++) {
                                if (!pilas.get(origen).isEmpty()){
                                    String aux = pilas.get(origen).pop();
                                    pilas.get(destino).push(aux);
                                }else{
                                    break;
                                }

                            }
                        }
                        linea++;

                    }

                }


                imprimircabezas(pilas);
                imprimirPilas(pilas);

                //System.out.println(suma);
            }else{
                System.out.println("El archivo aun no esta listo para su lectura");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void creacionPilas(){
        for (int i = 0; i <matriz[1] ; i++) {
            pilas.add(new ArrayDeque<String>());
        }
    }
    public void imprimircabezas(ArrayList<Deque<String>> pilas){
        for (int j = 0; j <matriz[1] ; j++) {
            if (!pilas.get(j).isEmpty()){
                System.out.print("["+ pilas.get(j).peek() +"] ");
            }
            else{
                System.out.print("[ ] ");
            }


        }
        System.out.println("\n ");
    }
    public void imprimirPilas(ArrayList<Deque<String>> pilas){
        int numMax = recalcularFilas(pilas);
        while (numMax>0){
            for (int j = 0; j <matriz[1] ; j++) {
                if ( pilas.get(j).size()==numMax ){
                    System.out.print("["+ pilas.get(j).pop() +"] " );
                }else{
                    System.out.print("    ");
                }
            }
            System.out.println("");
            numMax--;
        }
    }
    public int recalcularFilas(ArrayList<Deque<String>> pilas){
        ArrayList<Integer> filas = new ArrayList<Integer>();
        for (int i = 0; i <matriz[1]; i++) {
            filas.add(pilas.get(i).size());
        }
        return Collections.max(filas);
    }
}
