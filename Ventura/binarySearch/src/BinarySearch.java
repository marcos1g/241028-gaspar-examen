import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    private int sizeArray;
    private int maxRandomNumber;
    private int[] numbers;
    private int iterations;

    private int numSearch;

    public BinarySearch() {
    }

    public void setMaxRandom(int maxRandom){
        this.maxRandomNumber = maxRandom;
    }

    public void setSizeArray(int sizeArray){
        this.sizeArray = sizeArray;
    }

    public int getIterations(){
        return this.iterations;
    }

    public void sortArray(){
        for (int i = 0; i < this.numbers.length - 1; i++)
            for (int j = 0; j < this.numbers.length - i - 1; j++)
                if (this.numbers[j] > this.numbers[j + 1]) {
                    int temporary = this.numbers[j];
                    this.numbers[j] = this.numbers[j + 1];
                    this.numbers[j + 1] = temporary;
                }
    }
    
    public void fillArray() {
        this.numbers = new Random().ints(sizeArray, 1, maxRandomNumber + 1).toArray();
    }

    public void numberToSearch(int numSearch){
        this.numSearch = numSearch;
    }

    public int binarySearch() {
        int left = 0;
        int right = this.numbers.length - 1;
        this.iterations = 0;

        while (left <= right) {
            this.iterations++;
            int mid = left + (right - left) / 2;
            if (this.numbers[mid] == this.numSearch) {
                return mid;
            }
            if (this.numbers[mid] < this.numSearch) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
