package BitWiseOperation;

public class GetBit {

	public static void main(String[] args) {
		int n=5;
		
		int pos=3;
		
		int bitMask=1<<pos;
		
		int newBitMask=bitMask&n;
		
		if(newBitMask==0) {
			System.out.println("number is zero");
		}else {
			System.out.println("nuber is one");
		}

	}

}
