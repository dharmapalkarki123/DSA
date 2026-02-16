package Stack;

import java.util.Stack;

public class PushAtButtom {
	
	public static void pushAtButtom1(int data, Stack<Integer> s) {
		
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		
		int top=s.pop();
		pushAtButtom1(data, s);
		s.push(top);
		
		
	}

	public static void main(String[] args) {
	   Stack<Integer> s=new Stack<>();
	   
	   s.push(1);
	   s.push(2);
	   s.push(3);
	   
	   pushAtButtom1(4,s);
	   
	   while (!s.isEmpty()) {

			System.out.println(s.peek());
			s.pop();

		}

	}

}
