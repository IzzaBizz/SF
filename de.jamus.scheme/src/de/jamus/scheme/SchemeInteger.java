package de.jamus.scheme;

import java.io.BufferedWriter;

public class SchemeInteger extends SchemeNumber implements ISchemeInteger {
	// public class SchemeInteger extends SchemeDouble implements SchemeObject

	/** the saved integer value */
	int ivalue;

	public SchemeInteger() {
		super();
		ivalue = 0;
	}

	public int getIValue() {
		return ivalue;
	}

	public double getDValue() {
		return ivalue;
	}

	public SchemeInteger(int x) {
		super();
		ivalue = x;
	}

	public SchemeInteger(Integer x) {
		super();
		ivalue = x.intValue();
	}

	@Override
	public SchemeBoolean eqp(ISchemeObject o) {
		if ((o instanceof SchemeInteger)
				&& (this.ivalue == ((SchemeInteger) o).ivalue))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public SchemeBoolean equalp(ISchemeObject o) {
		if ((o instanceof SchemeInteger)
				&& (this.ivalue == ((SchemeInteger) o).ivalue))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	/*
	 * public SchemeObject write(){ System.out.print(value);
	 * System.out.println(""); return RunEnv.nilval; }
	 */

	@Override
	public String sprint() {
		return String.valueOf(ivalue);
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
	public SchemeBoolean integerp() {
		return RunEnv.bTrue;
	}

	@Override
	public SchemeString numberstring() {
		String x = String.valueOf(ivalue);
		return new SchemeString("\"" + x + "\"");
	}

	@Override
	public ISchemeBoolean positivep() {
		if (this.ivalue > 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean zerop() {
		if (this.ivalue == 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean negativep() {
		if (this.ivalue < 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

}
