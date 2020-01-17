package de.jamus.scheme;

public class SchemeBoolean extends StElem implements ISchemeBoolean {

	public SchemeBoolean(String s) {
		super(s);
	}

	@Override
	public SchemeBoolean not() {
		if (this.value == RunEnv.bTrue)
			return RunEnv.bFalse;
		else
			return RunEnv.bTrue;
	}

	@Override
	public ISchemeObject eval() {
		return this;
	}

	@Override
	public String sprint() {
		return pname;
	}

	@Override
	public void print() {
		System.out.print(sprint());
	}

}
