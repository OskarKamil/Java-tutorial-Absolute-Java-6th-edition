package chapter8;
// this is an abstract class for EU students currently in UK

public class Sub2ba extends Sub2b {

	protected int calculateResidency() {
		return age;
	}
	
}

/* Its immediate parent Sub2b doesn't define an abstract class so this derived class must define it. If its immediate parent had defined an abstract method, then simply this class would have had inherited it. */