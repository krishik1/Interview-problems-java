package MultiThreadingANDSynchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalex {
	
	private static ThreadLocal<String> defaultDob = ThreadLocal.withInitial(() -> {
        
        String threadName = Thread.currentThread().getName();
        return "01/01/" + (2000 + threadName.hashCode() % 100); 
    });
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		List<User> users = new ArrayList<>();
		for(int i=0;i<100;i++) {
			users.add(new User(i,null));
		}
		
		for(int i=0;i<100;i++) {
			final int userId=i;
			es.submit(()-> {
				users.get(userId).setDob(defaultDob.get());
				System.out.println(users.get(userId));
			});
		}
		
	}
}
