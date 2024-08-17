package MultiThreading.semephore;

import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
	int maxSize;
	//ArrayList<Object> display;
	ConcurrentLinkedDeque  display;

	public ConcurrentLinkedDeque getDisplay() {
		return display;
	}

	public void setDisplay(ConcurrentLinkedDeque display) {
		this.display = display;
	}

	public Store(int maxSize) {
		this.maxSize = maxSize;
		this.display = new ConcurrentLinkedDeque<>();
	}
	void addItem(Object o) {
        display.add(o);
    }

    void removeItem() {
        display.remove(display.size()-1); 
    }

    int getMaxSize() {
        return this.maxSize;
    }

    int setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return maxSize;
    }

    int getDisplaySize() {
        return this.display.size();
    }

	
	
}
