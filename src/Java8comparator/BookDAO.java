package Java8comparator;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
 
	public List<Book> getBooks(){
		List<Book> books=new ArrayList<>();
		 books.add(new Book(101, "Core Java", "200"));
	        books.add(new Book(2300, "Angular", "400"));
	        books.add(new Book(105, "Spring Boot", "350"));
	        books.add(new Book(108, "Hibernate", "280"));
	        books.add(new Book(102, "Python", "450"));
	        books.add(new Book(205, "JavaScript", "320"));
	        books.add(new Book(110, "Microservices", "500"));
	        books.add(new Book(103, "React", "300"));
	        books.add(new Book(150, "Data Structures", "600"));
	        books.add(new Book(120, "SQL", "250"));

		return books;
	}
	

}
