package BitWiseOperation;

public class CountSetBit {
    public static void main(String[] args) {
        int num = 29; // Binary: 11101
        int count = countSetBits(num);
        System.out.println("Number of set bits in " + num + " is: " + count);
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1); // Drop the lowest set bit
            count++;
        }
        return count;
    }
}

