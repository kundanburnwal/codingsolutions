package com.kundan.tp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {

	public static void main(String[] args) {
		try {
			new CompletableFutureExample().demo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class CompletableFutureExample {
	public String demo() throws Exception {
		long start = System.currentTimeMillis();
		System.out.println("Start thread="+Thread.currentThread().getId()+" timeTaken="+(System.currentTimeMillis()-start));

		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(stringWithDelaySupplier("A"));
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(stringWithDelaySupplier("B"));
		
		CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
		f.complete(null);		
		try {
			String resA = f1.get();
			String resB = f2.get();
			String res = resA+resB;
			System.out.println("Response="+res+" thread="+Thread.currentThread().getId()+" timeTaken="+(System.currentTimeMillis()-start));
			return res;
		} catch (InterruptedException | ExecutionException e) {
			System.err.println(e);
			throw e;
		}
	}
	
	Supplier<String> stringWithDelaySupplier(String input) {
		return () -> {
			System.out.println("Thread with "+input+" thread="+Thread.currentThread().getId());
			long start = System.currentTimeMillis();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e);
			} 
			System.out.println("Thread with "+input+" thread="+Thread.currentThread().getId()+" timeTaken="+(System.currentTimeMillis()-start));
			return input;
		};
	}
}