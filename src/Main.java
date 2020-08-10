import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Sort
        Integer[] array = SortAlgorithm.randomArrays();
        SortAlgorithm.sort(array);
        SortAlgorithm.streamSort(array);
        String result = Arrays.toString(SortAlgorithm.quickSort(array, 0, array.length - 1));
        System.out.println(result);

        // Consonant
        String str = "우리나라 만세";
        ConsonantAlgorithm.consonant(str);
    }
}
