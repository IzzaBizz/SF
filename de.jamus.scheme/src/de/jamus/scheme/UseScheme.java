package de.jamus.scheme;

import java.io.File;

public class UseScheme {

	/*
	 * alt public static void main(String []args) throws Exception{
	 * RunEnv.init(); System.out.println("Scheme-Interpreter (rudimentaer):");
	 * //File textFile=new File("Scheme/input4.lsp"); //File textFile=new
	 * File("Scheme/input5.lsp"); //File textFile=new File("Scheme/input1.lsp");
	 * File textFile=new File("Scheme/" + args[0]); try{
	 * RunEnv.interpreter(textFile);
	 * System.out.println("Syntaxanalyse fertig!"); RunEnv.root =
	 * ((Pair)RunEnv.root).reverse(); //((Pair)RunEnv.root).treeeval(true);
	 * }catch(Exception e){ } }
	 */

	public static void main(String[] args) throws Exception {

		System.out.println("");
		System.out
				.println("---------------------------------------------------------------------------");
		System.out
				.println("     Jamus-Scheme-Interpreter     ( Jamus Projekt - HTW Dresden 2013 )                   ");
		System.out
				.println("---------------------------------------------------------------------------");

		System.out.println();
		// System.out.println("load RunEnvironment..");
		if (RunEnv.init())
			System.out.println("... RunEnvironment loaded successfully.");
		else
			System.out.println("   RunEnvironment loaded NOT successfully!");
		System.out.println();

		if (args.length > 0) {
			File textFile = new File(args[0]);
			try {
				RunEnv.interpreter_file(textFile);
				// System.out.println("Syntaxanalyse fertig!");
				// RunEnv.root = ((Pair)RunEnv.root).reverse();
				// ((Pair)RunEnv.root).treeeval(true);
			} catch (Exception e) {
			}
		} else {
			RunEnv.interpreter_dialog();
			// System.out.println("Syntaxanalyse fertig!");
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
