import java.util.Arrays;
public class Busqueda {
    int[]numeros;
    int TamanoArray;
    int MaxAleatorio;
    int Contador=0;
    int Buscado;
    int BuscadoValor;
    boolean Encontrado=true;
    public  Busqueda(){}


    public void setTamanoArray(int tamaño){
        this.TamanoArray=tamaño;
    }
    public void setMaxAleatorio(int max){
        this.MaxAleatorio=max;
    }
    public void llenarArray(){
        this.numeros= new int[this.TamanoArray];
        for (int i=0;i<TamanoArray-1;i++){
            this.numeros[i]= (int)(Math.random()*MaxAleatorio);
        }
    }
    public void ordenarArray(){
        Arrays.sort(this.numeros);
    }
    public void generarNumeroBusqueda(){
        this.Buscado= (int)(Math.random()*1024);
        this.BuscadoValor=this.numeros[this.getBuscado()];
    }
    public int getBuscado(){
        return this.Buscado;
    }
    public void ejecutarBusqueda(){

        int posicionI=0;
        int posicionF=this.TamanoArray;
        while(this.Encontrado){
            int posicionM=((posicionF+posicionI)/2);
            if (numeros[this.Buscado]<numeros[posicionM]){
                posicionF=posicionM-1;
                this.Contador++;
            }
            if (numeros[this.Buscado]>numeros[posicionM]){
                posicionI=posicionM+1;
                this.Contador++;
            }
            if (numeros[this.Buscado]==numeros[posicionM]){
                posicionI=posicionM+1;
                this.Encontrado=false;

            }
        }
    }
    public void mostrarResultados(){
        System.out.println("Se encontro el numero "+this.getBuscado()+" y se hicieron "+this.Contador+" repeticiones");
    }
}
