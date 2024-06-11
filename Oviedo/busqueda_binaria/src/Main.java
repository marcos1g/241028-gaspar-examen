public class Main {
    public static void main(String[] args) {

        BusquedaBinaria busqueda = new BusquedaBinaria();

        busqueda.setMaxAleatorio(7000);
        busqueda.setlongitudArray(5);

        busqueda.llenarArray();
        busqueda.mostrarArrayNoOrdenado();
        System.out.println(" ");
        busqueda.ordenarArray();
        busqueda.mostrarArrayOrdenado();
        System.out.println(" ");
        busqueda.generarNumeroBusqueda();
        busqueda.ejecutarBusqueda();
        System.out.println(" ");
        busqueda.mostrarResultados();

    }
}

