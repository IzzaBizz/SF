package de.jamus.scheme;

import java.io.BufferedWriter;

public class SchemeDouble extends SchemeNumber implements ISchemeDouble {
	double dvalue;

	public SchemeDouble(Double x) {
		super();
		dvalue = x.doubleValue();
	}

	public SchemeDouble() {
		super();
		dvalue = 0.0;
	}

	public double getDValue() {
		return dvalue;
	}

	@Override
	public SchemeBoolean eqp(ISchemeObject o) {
		if ((o instanceof SchemeDouble)
				&& (this.dvalue == ((SchemeDouble) o).dvalue))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public SchemeBoolean equalp(ISchemeObject o) {
		if ((o instanceof SchemeDouble)
				&& (this.dvalue == ((SchemeDouble) o).dvalue))
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
		return String.valueOf(dvalue);
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
		if (this.dvalue == (Math.round(this.dvalue)))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public SchemeBoolean realp() {
		return RunEnv.bTrue;
	}

	@Override
	public SchemeBoolean numberp() {
		return (RunEnv.bTrue);
	}

	@Override
	public SchemeString numberstring() {
		String x = String.valueOf(dvalue);
		return new SchemeString("\"" + x + "\"");
	}

	@Override
	public ISchemeBoolean positivep() {
		if (this.dvalue > 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean zerop() {
		if (this.dvalue == 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean negativep() {
		if (this.dvalue < 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}
}
