import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Damindu on 11/28/2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ReadFile file = new ReadFile();
        Inputs input = new Inputs(file);
        System.out.println("Need:");
        int[][] need = input.getNeed();
        for (int[] arr : need) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("\nStatus of the system: ");
        BankersAlgorithm banker = new BankersAlgorithm(input);
        banker.main();
    }
}
