public static void main(String[] args) {
    binary_search search = new binary_search();

    search.setMaxRandom(7000);
    search.setArrayLength(1024);
    search.fillArray();
    search.sortArray();
    //search.reqNum(525); //número elegido arbitrariamente por el usuario
    search.reqNum(search.showList()[266]); //número elegido por el usuario desde un índice de la lista
    for(int n : search.showList()){
        System.out.println(n);
    }
    if (search.binarySearch()!=-1) {
        System.out.println(STR."El número \{search.reqNum} fue encontrado.");
    }else{
        System.out.println(STR."El número \{search.reqNum} no fue encontrado en la lista.");
    }



    System.out.println(search.showResults());
}