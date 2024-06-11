//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        busquedaBinaria busqueda = new busquedaBinaria();

        busqueda.setMaximoAleatorio(7000);
        busqueda.setMaximoCant(1024);

        busqueda.llenarArray();
        busqueda.ordenarArray();
        busqueda.generarNumeroBusqueda();
        busqueda.ejecutarBusqueda();
        busqueda.mostrarResultados();
    }
}