package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WhyNotFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	 ExecutorService service =Executors.newFixedThreadPool(10);
	Future<List<Integer>> future=  service.submit(()->{
		//suppose you are doing api call
		System.out.println("Thread"  +Thread.currentThread().getName());
		delay(1);
		
		return Arrays.asList(1,23,4,5,7);
	 });
	
	List<Integer> list=future.get();
	System.out.println(list);
	
	//creating completablefuture

	CompletableFuture<String> completableFuture=new CompletableFuture<String>();
	completableFuture.get();
	completableFuture.complete("return some dummy data");
	
	

	}
	
	private static void delay(int min) {
		try {
			
			TimeUnit.MINUTES.sleep(min);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}

}
