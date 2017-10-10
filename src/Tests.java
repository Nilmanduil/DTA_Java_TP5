import dta.tgoudouneix.threads.*;

public class Tests {
	public static void main(String[] args) {
		DTAThread thread1 = new DTAThread("Bonjour !", 10, 1);
		DTAThread thread2 = new DTAThread("Salut !", 5, 2);
		
		thread1.start();
		thread2.start();
		
		
	}
}
