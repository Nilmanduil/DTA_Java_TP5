package dta.tgoudouneix.threads;

import java.util.ArrayList;
import java.util.Iterator;

public class SplitSearcher<T> {
	private ArrayList<T> data;
	private T value;
	
	private CompteurConcurrent count;
	
	private class SearchAgent<T> extends Thread {
		private ArrayList<T> data;
		private T value;
		
		private Integer number = 0;
		
		public SearchAgent(ArrayList<T> data) {
			this.data = data;
			this.value = (T) SplitSearcher.this.value;
		}
		
		public void run() {
			Iterator<T> iterator = data.iterator();
			
			while(iterator.hasNext()) {
				if(iterator.next() == this.value) {
					SplitSearcher.this.count.incremente();
				}
			}
		}
	}
	
	public SplitSearcher(ArrayList<T> data, T value) {
		this.data = data;
		this.value = value;
	}
	
	public Integer search() {
		ArrayList<T> half1 = (ArrayList<T>) this.data.subList(0, this.data.size() / 2);
		ArrayList<T> half2 = (ArrayList<T>) this.data.subList(this.data.size() / 2, this.data.size() - 1);

		SearchAgent<T> sa1 = new SearchAgent(half1);
		SearchAgent<T> sa2 = new SearchAgent(half2);
		
		sa1.start();
		sa2.start();
		
		try {
			sa1.join();
			sa2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.count.getValue();
	}
}
