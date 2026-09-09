package MixOfAll;

public class ArrayMax {
    public static void main(String[] args) {
        // Step 1: Define the MixOfAll.array
        int[] arr = {-1000, -100, 33, 99, 77, 25, 86, 66, 54, 87};
        int maxSum = 0;
        int[] bestTriplet = new int[3];
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] > arr[i]) {
                    for (int k = j + 1; k < n;k++) {
                        if (arr[k] > arr[j]) {
                            int currSum = arr[i]*arr[j]*arr[k];
                            if (currSum > maxSum) {
                                maxSum = currSum;
                                bestTriplet[0] = arr[i];
                                bestTriplet[1] = arr[j];
                                bestTriplet[2] = arr[k];
                            }
                        }
                    }
                }
            }
        }

        // Step 4: Print result
        if (maxSum > 0) {
            System.out.println("Triplet with maximum sum in increasing order: "
                    + bestTriplet[0] + ", "
                    + bestTriplet[1] + ", "
                    + bestTriplet[2]);
            System.out.println("Maximum sum: " + maxSum);
        } else {
            System.out.println("No increasing triplet found.");
        }
    }
}
