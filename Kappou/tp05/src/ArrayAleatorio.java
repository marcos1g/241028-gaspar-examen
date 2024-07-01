
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayAleatorio{
    public static ArrayList crearArray() {
        ArrayList array = new ArrayList<>();
        Random r = new Random();
        int max = 7000;
        int min = 1;
        int rango = 0;
        for (int i = 0; i < 1000; i++){
            array.add(r.nextInt(rango, rango+7));
            rango += 7;
        }
        return array;
    }

}