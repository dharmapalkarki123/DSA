package BitWiseOperation;

public class SetBit {
	

	public static void main(String[] args) {
		 int n=5;
		 
		 int pos=1;
		 
		 int BitMask=1<<pos;
		 
		 int newBitMask=BitMask|n;
		 
		 System.out.println(newBitMask);
		
		
	}

}
