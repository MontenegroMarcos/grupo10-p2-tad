package Entities;

import ClasesAuxiliares.NodoBrewery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SistemaCentral {


    public NodoBrewery[] PrimerConsulta(NodoBrewery[] Hashdeentrada, String anio) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date fecha = sdf.parse(anio);
        //Long milis = fecha.getTime(); //Este es el anio introducido en milisegundos
        // Tener en cuenta que un anio en milis son 3.154e+10


        NodoBrewery[] entrada = {Hashdeentrada[0],Hashdeentrada[1],Hashdeentrada[2],Hashdeentrada[3],Hashdeentrada[4],
                Hashdeentrada[5],Hashdeentrada[6],Hashdeentrada[7],Hashdeentrada[8],Hashdeentrada[9]};

        NodoBrewery[] resultados = new NodoBrewery[10];;

        //Estructura de Control para que solo cuente los nodos con el anio correcto



        /*for (int i = 0; i < 9; i++) {
            if(true){ //Fixme controlar el anio en que se hizo esto
                entrada[i] = Hashdeentrada[i];
                resultados = QuickSort(entrada,0,9);

            }

        } */
            //resultados = QuickSort(entrada,0,9);

        for (int i = 9; i < Hashdeentrada.length; i++) {
            if(true && Hashdeentrada[i] != null &&
                    entrada[9].getCantidad_de_resenias() <= Hashdeentrada[i].getCantidad_de_resenias()){ //Fixme controlar el anio en que se hizo esto y si el ultimo elemento es menor a otro de la tabla
                entrada[9] = Hashdeentrada[i];
                resultados = QuickSort(entrada, 0 , 9);
            }

            resultados = QuickSort(entrada, 0 , 9);


        }

        //resultados = entrada;

        return resultados;
    }

    public NodoBrewery[] QuickSort(NodoBrewery[] entrada, int indiceBajo, int indiceAlto) {
        String[] resultados = new String[indiceAlto + 1];
        NodoBrewery[] entradas = entrada;

        if (indiceBajo >= indiceAlto) {
            return entradas;
        }

        int Pivot = 0;
        int primer_elemento = (entradas[0].getCantidad_de_resenias());
        int medio_elemento = (entradas[indiceAlto / 2].getCantidad_de_resenias());
        int ultimo_elemento = (entradas[indiceAlto].getCantidad_de_resenias());

        if (primer_elemento < medio_elemento && medio_elemento > ultimo_elemento) {
            Pivot = medio_elemento;
        } else if (primer_elemento > medio_elemento && primer_elemento < ultimo_elemento) {
            Pivot = primer_elemento;
        } else {
            Pivot = ultimo_elemento;
        }

        if (Pivot != ultimo_elemento && Pivot == primer_elemento) {
            IntercambiarNodos(entradas, indiceBajo, indiceAlto);
            /*entradas[14].getCantidad_de_resenias() = Pivot;
            entradas[0].getCantidad_de_resenias() = ultimo_elemento;*/
        } else if (Pivot != ultimo_elemento && Pivot == medio_elemento) {
            IntercambiarNodos(entradas, indiceAlto / 2, indiceAlto);
            /*entradas[14].getCantidad_de_resenias() = Pivot;
            entradas[7].getCantidad_de_resenias() = ultimo_elemento;*/
        }


        //Entonces despues de elegir nuestro candidato a Pivote
        int Pivote = entradas[indiceAlto].getCantidad_de_resenias();

        int posicionElementoIzquierdo = indiceBajo;
        int posicionElementoDerecho = indiceAlto;

        while (posicionElementoDerecho > posicionElementoIzquierdo) {
            while (entradas[posicionElementoIzquierdo].getCantidad_de_resenias() >= Pivote &&
                    posicionElementoDerecho > posicionElementoIzquierdo) {
                posicionElementoIzquierdo++;
            }
            while (entradas[posicionElementoDerecho].getCantidad_de_resenias() <= Pivote &&
                    posicionElementoDerecho > posicionElementoIzquierdo) {

                posicionElementoDerecho--;
            }
            IntercambiarNodos(entradas, posicionElementoIzquierdo, posicionElementoDerecho);
        }
        IntercambiarNodos(entradas, posicionElementoIzquierdo, indiceAlto);
        QuickSort(entradas, indiceBajo, posicionElementoIzquierdo - 1);
        QuickSort(entradas, posicionElementoIzquierdo, indiceAlto);

        return entradas;
    }

    public static void IntercambiarNodos(NodoBrewery[] entradas, int posicion1, int posicion2) {
        NodoBrewery dato = entradas[posicion1];
        entradas[posicion1] = entradas[posicion2];
        entradas[posicion2] = dato;


    }


    public int MedioDeTres(int[] entradas, int indiceInicial, int indiceFinal) {

        return 0;
    }



    /*for (int i = 0; i < entradas.length; i++) {
                if(entradas[posicionElementoIzquierdo].getCantidad_de_resenias() <= Pivote &&
                        posicionElementoDerecho > posicionElementoIzquierdo){
                    posicionElementoIzquierdo++;
                }

                if(entradas[posicionElementoDerecho].getCantidad_de_resenias() >= Pivote &&
                        posicionElementoDerecho > posicionElementoIzquierdo){
                    posicionElementoIzquierdo--;
                }*/


}
