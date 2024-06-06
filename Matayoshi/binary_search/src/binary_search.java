import java.util.Arrays;
public class binary_search {
//    public static void main(String[] args) {
//        int result=0;
//        int[] array = new int[1000];
//        for (int x=0;x<1000;x++)
//            array[x] = (int) (Math.random() * 1000) + 1;
//        /*System.out.println("Unsorted array");
//        for (int j : array) {
//            System.out.println(j);
//        }*/
//        Arrays.sort(array);
//        /*System.out.println(" ");
//        System.out.println("Sorted array");
//        for (int j : array) {
//            System.out.println(j);
//        }*/
//        //int reqNum = (int) (Math.random() * 20) + 1;
//        int reqNum = array[(int) (Math.random() * 999) + 1];
//        System.out.println(" ");
//        System.out.println("Required Number");
//        System.out.println(reqNum);
//
//        int ini = 0;
//        int fin = array.length;
//        int iterations = 0;
//
//        while(ini<=fin) {
//            int pos = (ini + fin) / 2;
//            if (array[pos] == reqNum)
//                result = pos;
//
//            if (array[pos] < reqNum)
//                ini = pos + 1;
//            else
//                fin = pos - 1;
//            iterations++;
//        }
//        System.out.println(" ");
//        System.out.println("Result");
//        if(array[result]==reqNum) {
//            System.out.println("The number '"+array[result]+"' was found!!");
//        }
//        else{
//            System.out.println("Number not found in list!!");
//        }
//        System.out.println(" ");
//        System.out.println("Number of iterations");
//        System.out.println(iterations);
//    }
    int ini = 0;
    int fin;
    int mid;
    int reqNum;
    int[] array;
    int iterations = 0;
    int max;
    int length;

    public void reqNum(int reqNum) {
        this.reqNum = reqNum;
    }
    public void setMaxRandom(int max) {this.max = max;}
    public void setArrayLength(int length) {this.length = length;this.array=new int[length];}
    public void fillArray(){
        for (int x=0;x<length;x++)
            array[x] = (int) (Math.random() * max) + 1;
    }
    public void sortArray(){
        Arrays.sort(array);
    }
    int binarySearch()
    {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (array[mid] == reqNum)
                return array[mid];

            if (array[mid] < reqNum)
                low = mid + 1;

            else
                high = mid - 1;

            iterations++;
        }

        return -1;
    }
    public int reqNum(){
        return reqNum;
    }
    public int showResults(){
        return iterations;
    }
    public int[] showList(){
        return array;
    }
}