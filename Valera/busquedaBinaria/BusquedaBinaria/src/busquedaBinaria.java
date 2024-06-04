import java.util.Random;

public class busquedaBinaria {
    public static Random rd = new Random();
    private int maximoCant;
    private int maximoAleatorio;
    private int numBuscar;
    private int indiceFinal;
    private int[] numeros;
    private int iteraciones;
    public busquedaBinaria(){

    }
    public void ejecutarBusqueda(){
        iteraciones = 0;
        int i = 0;
        int f = maximoCant;
        while(true){
            iteraciones++;
            int r = i+((f-i)/2);
            if(numBuscar == numeros[r]) {
                indiceFinal = r;
                break;
            }
            else if(numBuscar > numeros[r]){
                i = r;
            }
            else if(numBuscar < numeros[r]){
                f = r;
            }
        }
    }

    public int getMaximoAleatorio() {
        return maximoAleatorio;
    }

    public int getMaximoCant() {
        return maximoCant;
    }

    public int getNumBuscar() {
        return numBuscar;
    }

    public void setMaximoAleatorio(int maximoAleatorio) {
        this.maximoAleatorio = maximoAleatorio;
    }

    public void setMaximoCant(int maximoCant) {
        this.maximoCant = maximoCant;
    }

    public void setNumBuscar(int numBuscar) {
        this.numBuscar = numBuscar;
    }

    public void llenarArray(){
        numeros = new int[maximoCant];
        for(int i = 1; i < 1001; i++){
            numeros[i-1] = rd.nextInt(1,maximoCant);
        }
    }
    public void ordenarArray(){
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiar elementos si están en el orden incorrecto
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
    }
    public void generarNumeroBusqueda(){
        numBuscar = numeros[rd.nextInt(0,1000)];
    }
    public void mostrarResultados(){
        System.out.println("Posición "+indiceFinal);
        System.out.println("Se tardo "+iteraciones+" iteraciones");
    }
}
