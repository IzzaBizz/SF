package de.jamus.scheme;

import java.io.BufferedWriter;

public abstract class SchemeNumber extends SchemeObject implements
		ISchemeNumber {
	int value;

	public SchemeNumber() {
		value = 0;
	}

	public SchemeNumber(Integer x) {
		value = x.intValue();
	}

	@Override
	public SchemeBoolean eqp(ISchemeObject o) {
		if ((o instanceof SchemeNumber)
				&& (this.value == ((SchemeNumber) o).value))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public SchemeBoolean equalp(ISchemeObject o) {
		if ((o instanceof SchemeNumber)
				&& (this.value == ((SchemeNumber) o).value))
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
		return String.valueOf(value);
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
	public ISchemeObject eval() {
		return this;
	}

	@Override
	public SchemeBoolean numberp() {
		return RunEnv.bTrue;
	}

	@Override
	public SchemeString numberstring() {
		String x = String.valueOf(value);
		System.out.println(x);
		return new SchemeString("\"" + x + "\"");
	}

	@Override
	public ISchemeBoolean positivep() {
		if (this.value > 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean zerop() {
		if (this.value == 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean negativep() {
		if (this.value < 0)
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	static ISchemeNumber minus(ISchemeNumber... numbers) {
		if (numbers.length < 1)
			return new SchemeInteger();

		if (numbers.length == 1) {
			if (numbers[0] instanceof SchemeInteger) {
				SchemeInteger i = (SchemeInteger) numbers[0];
				return new SchemeInteger(-i.getIValue());
			} else if (numbers[0] instanceof SchemeDouble) {
				SchemeDouble i = (SchemeDouble) numbers[0];
				return new SchemeDouble(-i.getDValue());
			} else {
				// there are more number types who are not implemented here!
				assert (false);
				return new SchemeInteger();
			}
		}

		assert (numbers.length > 1);
		for (ISchemeNumber number : numbers) {
			if (number instanceof SchemeInteger) {

			} else if (number instanceof SchemeDouble) {

			}
		}
		return new SchemeInteger();
	}
}
