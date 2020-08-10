import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Stream;

public class SortAlgorithm {

    public static void sort(Integer[] array) {
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(Arrays.toString(array));
    }

    public static void streamSort(Integer[] array) {
        Arrays.sort(array);
        Stream<Integer> stream = Stream.of(array);
        stream.sorted(Collections.reverseOrder()).forEach( i -> {
            System.out.print(i+" ");
        });
    }

    public static Integer[] quickSort(Integer[] array, int left, int right) {
        int pl = left;
        int pr = right;
        int x = array[(pl+pr)/2];

        do{
            while (array[pl] > x) pl++;
            while (array[pr] < x) pr--;
            if (pl <= pr)
                swap(array,pl++,pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(array,left,pr);
        if (pl < right) quickSort(array,pl,right);

        return array;
    }

    private static void swap(Integer[] array, int pl, int pr) {
        int temp = array[pr];
        array[pr] = array[pl];
        array[pl] = temp;
    }

    protected static Integer[] randomArrays() {
        Random random = new Random();
        Integer randomNumber = random.nextInt(100)+1;
        Integer[] array = new Integer[randomNumber];
        for(Integer i=0; i<randomNumber; i++){
            array[i] = random.nextInt(100)+1;
        }
        return array;
    }
}
