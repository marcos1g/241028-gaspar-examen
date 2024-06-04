public static void main(String[] args) {
    binary_search search = new binary_search();

    search.setMaxRandom(7000);
    search.setArrayLength(1024);
    search.fillArray();
    search.sortArray();
    search.reqNum(535);
    if (search.binarySearch()!=-1) {
        System.out.println(search.binarySearch());
    }else{
        System.out.println("Not found");
    }

    System.out.println(search.showResults());
}