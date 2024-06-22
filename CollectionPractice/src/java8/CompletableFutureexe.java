package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureexe {
	/**
	 * 1.Java 8 introduces new class java.util.concurrent.CompletableFuture focusing
	 * asynchronus programming and non-blocking code. it is extension to java's
	 * future Api which was introduced in java8. 2.This will run tasks on a separate
	 * thread than the main application thread and notifying the main thread about
	 * its progress ,completion or failure. This way your main thread does not
	 * block/wait for the completion of the task and it can execute other tasks in
	 * parallel. 3.CompletableFuture has below important methods that can be used
	 * for async programming. 1)runAsync() - Runs async in the background and will
	 * not return anything from the task. 2)supplyAsync() - Runs async in the
	 * background and will return the values from the task. 3)get() - it blocks the
	 * execution until the future is completed. 4)thenApply()/thenAccept() - For
	 * attaching a callback to the Completable Future.
	 * 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 **/
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		runAsync();
		supplyAsunc();
		thenApply();
		thenAccept();
		System.out.println("Main Thread");
	}

	private static void runAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> async = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Running in a seperate thread than the main thread.");
			} catch (Exception e) {
				throw new IllegalStateException();
			}
		});
		System.out.println("runAsync Blocking 1.");
		async.get();
		System.out.println("runAsync Blocking 2.");
	}

	private static void supplyAsunc() throws InterruptedException, ExecutionException {
		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException();
			}
			return "Eazy Bytes";
		});
		System.out.println("supplyAsync Blocking 1.");
		System.out.println(async.get());
		System.out.println("supplyAsync Blocking 2.");
	}

	private static void thenApply() throws InterruptedException, ExecutionException {
		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException();
			}
			return "Eazy";
		});
		System.out.println("Then Apply Middle Block.");
		CompletableFuture<String> future = async.thenApply(res -> {
			try {

			} catch (Exception e) {
				throw new IllegalStateException();
			}
			return res + " Bytes";
		});
		System.out.println("thenApply before Final Block.");
		System.out.println(future.get());
		System.out.println("thenApply after Final Block.");

	}

	private static void thenAccept() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> async = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				throw new IllegalStateException();
			}
			return "Eazy Bytes";
		}).thenAccept((res) -> {
			try {

			} catch (Exception e) {
				throw new IllegalStateException();
			}
			System.out.println("The Recieved Value is :" + res);
		});
		System.out.println("Then Accept non-blocking.");
		async.get();
	}

}
