package dta.tgoudouneix.threads;

public class CompteurConcurrent {
	private int cpt = 0; 
	
	public int getValue () { 
		return cpt ; 
	} 
	
	public String toString () { 
		return "" + cpt ; 
	}

	synchronized	 public	void incremente () { 
		cpt++;
	}
	
	synchronized public void incremente ( int i ) 
	{ 
		cpt = cpt + i ;
	}
}
