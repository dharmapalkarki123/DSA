package Java8comparator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {
	
	public List<Book> getAllBook(){
		
		List<Book> books=new BookDAO().getBooks();
		//using direct lamda function
		Collections.sort(books,(o1,o2)->{
			return o1.getName().compareTo(o2.getName());
		});
		
//		Collections.sort(books,new Comparator<Book>() {
//
//			@Override
//			public int compare(Book o1, Book o2) {
//				return o2.getName().compareTo(o1.getName());
//				
//			}
//		});
		return books;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new BookService().getAllBook());
	}



//class MyComparator implements Comparator<Book>{
//
//	@Override
//	public int compare(Book o1, Book o2) {
//		
//		return o1.getName().compareTo(o2.getName());
//	}

}