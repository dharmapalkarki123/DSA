package Array;

public class StringBuilderExample {
    public static void main(String[] args) {
        // Creating a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        // Appending text
        sb.append(" World");
        System.out.println("After append: " + sb);

        // Inserting text at a specific position
        sb.insert(5, " Java");
        System.out.println("After insert: " + sb);

        // Replacing text within a range
        sb.replace(6, 10, "Program");
        System.out.println("After replace: " + sb);

        // Deleting characters within a range
        sb.delete(6, 13);
        System.out.println("After delete: " + sb);

        // Reversing the string
//        sb.reverse();
//        System.out.println("After reverse: " + sb);
        
        
        
        for(int i=0;i<sb.length()/2;i++) {
        	
        	int  front=i;
        	int back=sb.length()-1-i;
        	
        	char frontChar=sb.charAt(front);
        	Character backChar =sb.charAt(back);
        	
        	sb.setCharAt(front, backChar);
        	sb.setCharAt(back, frontChar);
        	
        }
        
        System.out.println(sb);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}

