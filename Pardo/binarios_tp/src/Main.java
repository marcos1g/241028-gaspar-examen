import javax.swing.*;
import java.util.Arrays;
import java.util.Random;




class Arra {


    int largo;
    int mayor;

    public int setLargo(int l) {
        return this.largo = l;
    }

    public int setMayor(int m) {
        return this.mayor = m;
    }

    public void llanar() {
        int[] a = new int[this.largo];
    }


}
 public class Main {
    public  void main(String[] args) {
        Random random=new Random();
        Arra a=new Arra();
        a.setLargo(12);
        a.setMayor(10);
        a.llenar();
        a.ordenar();


        a.busquedaBinaria(a.a,a.generarNumeroBusqueda());




    }






    static class Resultado {
        int indice;
        int iteraciones;


        Resultado(int indice, int iteraciones) {
            this.indice = indice;
            this.iteraciones = iteraciones;
        }
    }
    static class Arra
    {
        int[] a;
        int largo;
        int mayor;
        Random r=new Random();
        public void setLargo(int l)
        {
            this.largo=l;
        }
        public void setMayor(int m)
        {
            this.mayor=m;
        }
        public int getLargo()
        {
            return this.largo;
        }
        public int getMayor()
        {
            return this.mayor;
        }
        public void llenar()
        {
            a = new int[getLargo()];
            for (int i = 0; i < a.length; i++) {
                a[i] = r.nextInt(getMayor()) + 1;
            }


        }
        public void ordenar()
        {
            Arrays.sort(a);
        }
        public int generarNumeroBusqueda()
        {
            int numero = 333;




            int posicionAleatoria = r.nextInt(a.length);
            return a[posicionAleatoria] = numero;
        }
        public Resultado busquedaBinaria(int[] array, int x) {
            int primero = 0;
            int _final = array.length - 1;
            int medio;
            int iteraciones =0;


            while (primero <= _final) {
                iteraciones++;
                medio = (primero + _final) / 2;
                if (array[medio] < x) {
                    primero = medio + 1;
                } else if (array[medio] > x) {
                    _final = medio - 1;
                } else {
                    return new Resultado(medio,iteraciones);
                }
            }


            return new Resultado(-1,iteraciones);
        }
        public void MOstrar()
        {
            int e=generarNumeroBusqueda();
            Resultado resultado = busquedaBinaria(a, e);
            if (resultado.indice != -1) {
                System.out.println("El número " + e + " se encuentra en el índice " + resultado.indice);
            } else {
                System.out.println("El número " + e + " no se encuentra en el array.");
            }
            System.out.println("Número de iteraciones: " + resultado.iteraciones);
        }


    }
}


