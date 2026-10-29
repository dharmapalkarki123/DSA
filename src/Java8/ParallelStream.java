package Java8;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {

	public static void main(String[] args) {
		/*
		 * long start=0; long end=0;
		 * 
		 * 
		 * start=System.currentTimeMillis(); IntStream.range(1,
		 * 100).forEach(System.out::println); end=System.currentTimeMillis();
		 * 
		 * System.out.println("Total time: " +(end-start));
		 * 
		 * System.out.println("===========================");
		 * 
		 * 
		 * start=System.currentTimeMillis();
		 * 
		 * IntStream.range(1, 100).parallel().forEach(System.out::println);
		 * 
		 * end =System.currentTimeMillis();
		 * 
		 * System.out.println("Total time for parallel stream: " +(end-start));
		 * 
		 * 
		 */

		/*
		 * 
		 * IntStream.range(1, 10).forEach(x->{ System.out.println("Thread "
		 * +Thread.currentThread().getName()+":" +x); });
		 * 
		 * IntStream.range(1, 10).parallel().forEach(x->{ System.out.println("Thread"
		 * +Thread.currentThread().getName()+":" +x); });
		 * 
		 */

		long start = 0;
		long end = 0;

		List<EmployeeMap> employee = EmployeeMapDatabase.getParelleEmployee();

		// NORMAL STREAM

		start = System.currentTimeMillis();
		double normal = employee.stream().map(EmployeeMap::getSalary).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();

		System.out.println("Using Normal Stream: " + (end - start));
		
		//Using parallel stream
		start = System.currentTimeMillis();
		double withParalleStream=employee.parallelStream().map(EmployeeMap::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		
		System.out.println("Using Parallel Stream: " + (end - start));
	}

}
