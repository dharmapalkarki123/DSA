package BitWiseOperation;

public class SwapEvenOddBit {
    public static void main(String[] args) {
        int num = 23; // Binary: 0001 0111
        int swapped = swapBits(num);
        System.out.println("Number after swapping even and odd bits: " + swapped);
    }

    public static int swapBits(int num) {
        int evenBits = num & 0xAAAAAAAA; // Mask for even bits
        int oddBits = num & 0x55555555;  // Mask for odd bits
        
        evenBits >>= 1; // Shift even bits right
        oddBits <<= 1;  // Shift odd bits left

        return (evenBits | oddBits); // Combine
    }
}
