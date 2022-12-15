import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class dia1 {
    ArrayList<Integer> duentes = new ArrayList<Integer>();
    ArrayList<Integer> duentesCopia;
    int[] tresconmascomidakc = new int[3];



    public void lectura(){
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("C:\\Users\\hack_\\Documents\\cursos\\Advent of code\\2022\\DiA1\\dia1.txt");

            if(archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                int suma=0;
                while ((cadena=lector.readLine()) !=null){
                    if (cadena.isEmpty()){
                        duentes.add(suma);
                        suma=0;


                    }else{
                        suma+= Integer.parseInt(cadena);

                    }

                }
                duentesCopia = (ArrayList<Integer>)duentes.clone();
            }else{
                System.out.println("El archivo aun no esta listo para su lectura");
            }


        }catch (Exception e){
            System.out.println("Ocurrio un Error");
        }
    }
    public void calculoMayor(){
        int dCaloriasMaximas = Collections.max(duentes);
        for (int i=0;i<duentes.size();i++) {
            if( duentes.get(i)==dCaloriasMaximas ){
                System.out.println("El duende "+(i+1)+" tiene mas comida");
                System.out.println("La cantidad de comida que tiene es "+dCaloriasMaximas);
                System.out.println("");
            }
        }
    }
    public void Calculo3Mayores(){

        //ordenar de mayor a menor la lista
        duentesCopia.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //los primeros 3 mas grandes se guardaran aqui
        for (int i = 0; i <3 ; i++) {
            tresconmascomidakc[i]=duentesCopia.get(i);
        }

        System.out.println("Se listaran los duentes con mas comida");
        for (int i = 0; i <3 ; i++) {
            for (int j=0;j<duentes.size();j++) {
                if( duentes.get(j)==tresconmascomidakc[i] ){
                    System.out.print("Duende numero "+(j+1));
                    System.out.println(" ;kc totales "+tresconmascomidakc[i]);
                }
            }
        }
        int sumacalorias3mayores =(tresconmascomidakc[0]+tresconmascomidakc[1]+tresconmascomidakc[2]);
        System.out.println("La suma de sus calorias son: "+sumacalorias3mayores);
    }
    public static void main(String[] args) {
        dia1 l1 = new dia1();
        l1.lectura();
        l1.Calculo3Mayores();

    }
}
