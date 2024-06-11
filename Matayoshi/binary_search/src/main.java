import java.util.Scanner;

public static void main(String[] args) {
    binary_search search = new binary_search();
    /*Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();*/
    search.setMaxRandom(7000);
    search.setArrayLength(1024);
    search.fillArray();
    search.sortArray();

    //search.reqNum(525); //número elegido arbitrariamente por el usuario
    //search.reqNum(search.showList()[525]); //número elegido por el usuario desde un índice de la lista
    //search.reqNum(search.showList()[(int) (Math.random() * 1024)]); //número elegido arbitrariamente desde un índice de la lista

    /*for(int n : search.showList()){
        System.out.println(n);
    }*/
    if (search.reqNum()>0) {
        if (search.binarySearch() != -1) {
            System.out.println(STR."El número \{search.reqNum} fue encontrado en la posicion \{search.mid}.");
        } else {
            System.out.println(STR."El número \{search.reqNum} no fue encontrado en la lista.");
        }
    }else{
        System.out.println(STR."Por favor intorduzca un número");
    }


    System.out.println(search.iterations);
}