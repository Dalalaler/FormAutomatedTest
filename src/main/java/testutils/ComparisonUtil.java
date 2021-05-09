package testutils;

public class ComparisonUtil {
    public static void dataCompare(String inputtedData, String receivedData) {
        System.out.printf("Expected data: ");
        System.out.println(inputtedData);
        System.out.printf("Received data: ");
        System.out.println(receivedData);
        if (inputtedData.equals(receivedData)) {
            System.out.println("The data matched\n");
        } else {
            System.out.println("The data didn't match\n");
        }
    }
}
