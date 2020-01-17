package de.jamus.scheme;

import java.io.BufferedWriter;

public class Symbol extends StElem implements ISchemeSymbol {

	public Symbol(String pname) {
		super(pname);
	}

	/*
	 * public Object getValue(){ return value; }
	 */

	public void setValue(ISchemeObject e) {
		value = e;
	}

	/*
	 * public SchemeObject eval(){ return this.getValue(); }
	 */

	@Override
	public SchemeBoolean symbolp() {
		return (RunEnv.bTrue);
	}

	public SchemeBoolean stringle(SchemeString s) {
		if (this.equals(s))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public String sprint() {
		return pname;
	}

	@Override
	public void print() {
		System.out.print(sprint());
	}

	@Override
	public ISchemeObject printp(BufferedWriter open_buffer_writer) {
		try {
			open_buffer_writer.write(sprint());
		} catch (Exception e) {
			System.err.println("Error(Symbol.printp)::" + e.getMessage());
		}
		return RunEnv.nilval;
	}

}
