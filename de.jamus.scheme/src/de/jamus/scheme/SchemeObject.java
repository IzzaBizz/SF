/**
 * 
 */
package de.jamus.scheme;

import java.io.BufferedWriter;

/**
 * This class
 * 
 * @author Angelos Drossos
 * 
 */
public abstract class SchemeObject implements ISchemeObject {
	Object value;

	@Override
	public ISchemeObject expand() {
		return this;
	}

	@Override
	public ISchemeObject expandall() {
		return this;
	}

	@Override
	public ISchemeObject eval() {
		return this;
	}

	@Override
	public Pair cons(ISchemeObject e) {
		return new Pair(e, this);
	}

	@Override
	public String sprint() {
		return "<#object>";
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
			System.err.println("Error(SchemeObject.printp)::" + e.getMessage());
		}
		return RunEnv.nilval;
	}

	@Override
	public ISchemeBoolean eqp(ISchemeObject o) {
		if (this.equals(o))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public ISchemeBoolean equalp(ISchemeObject o) {
		if (this.equals(o))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public boolean nullp() {
		return false;
	}
}
