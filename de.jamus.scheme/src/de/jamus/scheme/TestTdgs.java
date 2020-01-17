package de.jamus.scheme;

import java.io.File;

public class TestTdgs {

	public static void main(String[] args) throws Exception {
		RunEnv.init();
		System.out.println("Scheme-Interpreter (rudimentaer):");
		File textFile = new File("TDGSScheme/tcgdatgtest.lsp");
		// File textFile=new File("Scheme/input5.lsp");
		// File textFile=new File("Scheme/input1n.lsp");
		try {
			RunEnv.interpreter_file(textFile);
			System.out.println("Syntaxanalyse fertig!");
			RunEnv.root = ((Pair) RunEnv.root).reverse();
			((Pair) RunEnv.root).treeeval(true);
		} catch (Exception e) {
		}

		// Pair p0 = (Pair)RunEnv.intern("nil");
		/*
		 * SchemeNumber n1 = new SchemeNumber(1); Pair p2= p0.cons(new
		 * SchemeNumber(2)); p2= p2.cons(n1); p2=
		 * p2.cons(RunEnv.intern("Function","+")); SchemeObject root = p2;
		 * //Wurzel des Syntaxbaumes root.print(); System.out.println();
		 * SchemeObject value = root.eval(); value.print();
		 */
	}

}

/*
 * Test:
 * 
 * C:\WorkStation\J\Scheme>java UseScheme (+ . (1 . (2 . NIL)))
 * C:\WorkStation\J\Scheme>
 */
