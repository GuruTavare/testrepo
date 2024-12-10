
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyThread extends Thread {

//	static HashMap m = new HashMap();

	static ConcurrentHashMap m = new ConcurrentHashMap();

	public void run()throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("child thread updating map");
			m.put(103, "C");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			System.out.println("child thread updating map");
//			m.put(103, "C");
//		}
	}

	public static void main(String[] args) throws InterruptedException {

		m.put(101, "A");
		m.put(102, "B");

		MyThread t = new MyThread();
		t.start();

		Set s = m.keySet();

		Iterator itr = s.iterator();

		while (itr.hasNext()) {

			Integer i1 = (Integer) itr.next();
			System.out.println("main thread iterating and current entry is :" + i1 + "..." + m.get(i1));
			Thread.sleep(3000);
		}
		System.out.println(m);
	}

}