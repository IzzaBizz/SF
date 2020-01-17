package de.jamus.scheme;

import java.io.BufferedWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import de.jamus.scheme.StElem.modeType;


/**
 * Class Pair in Scheme.
 */
public class Pair extends SchemeObject implements ISchemePair, ISchemeBoolean {
	static boolean closurestatus = false;
	static Symbol definesym;
	ISchemeObject car;
	ISchemeObject cdr;

	/**
	 * Creates an empty pair object.
	 * 
	 * An empty pair object is in scheme syntax: () or NIL.
	 * 
	 * @see nullp(), nullpp(), car(), cdr(), setcar(), setcdr()
	 */
	public Pair() {
		this.car = null;
		this.cdr = null;
	}

	/**
	 * Creates a pair object with the given car object and cdr object.
	 * 
	 * @note If the cdr object is another pair, this pair object is a list. All
	 *       car objects in the list are the elements of the list.
	 * 
	 * @warning Pay attention when building Cyclic Linked Lists.
	 * 
	 * @param car
	 *            the car object (left child of pair)
	 * @param cdr
	 *            the cdr object (right child of pair)
	 * 
	 * @see nullp(), nullpp(), car(), cdr(), setcar(), setcdr()
	 */
	public Pair(ISchemeObject car, ISchemeObject cdr) {
		this.car = car;
		this.cdr = cdr;
	}

	@Override
	public SchemeBoolean equalp(ISchemeObject o) {
		if (this.nullp() && o instanceof ISchemePair) {
			if (((ISchemePair) o).nullp())
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		}

		if (o instanceof Pair) {
			Pair pairo = (Pair) o;

			if ((car().equalp(pairo.car())) == RunEnv.bTrue
					&& (cdr().equalp(pairo.cdr())) == RunEnv.bTrue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		}

		if (this.equals(o))
			return RunEnv.bTrue;

		return RunEnv.bFalse;
	}

	public Pair append(Pair l) {
		if (this.nullp())
			return l;
		else
			return (((Pair) this.cdr()).append(l)).cons(this.car());
	}

	public Pair member(ISchemeObject e) {
		if (this.nullp())
			return RunEnv.nilval;
		else if ((e instanceof SchemeNumber)
				&& (this.car() instanceof SchemeNumber)) {
			ISchemeObject n1 = e;
			ISchemeObject n2 = this.car();
			if (n1 instanceof SchemeInteger)
				if (n2 instanceof SchemeInteger)
					if (((SchemeInteger) n1).ivalue == ((SchemeInteger) n2).ivalue)
						return this;
					else
						return ((Pair) this.cdr()).member(e);
				else if (((SchemeInteger) n1).ivalue == ((SchemeDouble) n2).dvalue)
					return this;
				else
					return ((Pair) this.cdr()).member(e);
			else if (n2 instanceof SchemeInteger)
				if (((SchemeDouble) n1).dvalue == ((SchemeInteger) n2).ivalue)
					return this;
				else
					return ((Pair) this.cdr()).member(e);
			else if (((SchemeDouble) n1).dvalue == ((SchemeDouble) n2).dvalue)
				return this;
			else
				return ((Pair) this.cdr()).member(e);
		} else if ((e instanceof Pair) && (this.car() instanceof Pair))
			if ((((Pair) this.car()).equalp(e)) == RunEnv.bTrue) // instead of
																	// equals
				return this;
			else
				return ((Pair) this.cdr()).member(e);
		else if (this.car().equals(e))
			return this;
		else
			return ((Pair) this.cdr()).member(e);

	}

	public Pair remove(ISchemeObject e) {
		if (this.nullp())
			return RunEnv.nilval;
		else if (this.car().equals(e))
			return ((Pair) this.cdr()).remove(e);
		else
			return ((Pair) this.cdr()).remove(e).cons(this.car());
	}

	public Pair reverse() {
		if (this.nullp())
			return RunEnv.nilval;
		else
			return ((Pair) this.cdr()).reverse().append(
					RunEnv.nilval.cons(this.car()));
	}

	public ISchemeObject assoc(ISchemeObject e) {
		if (this.nullp())
			return RunEnv.bFalse; // frueher RunEnv.nilval;
		else if // (((Pair)this.car()).car().equals(e))
		((((Pair) this.car()).car().equalp(e)) == RunEnv.bTrue)
			return this.car();
		else
			return ((Pair) this.cdr()).assoc(e);
	}

	public Pair remdup(Pair l) {
		if (this.nullp())
			return RunEnv.nilval;
		else if ((((Pair) this.cdr()).member(this.car())).nullp())
			if ((l.member(this.car())).nullp())
				return (((Pair) this.cdr()).remdup(l)).cons(this.car());
			else
				return ((Pair) this.cdr()).remdup(l);
		else
			return ((Pair) this.cdr()).remdup(l);
	}

	public Pair remdup2(Symbol l) { // fuer (lambda x (...)...)
		if (this.nullp())
			return RunEnv.nilval;
		else if ((((Pair) this.cdr()).member(this.car())).nullp())
			if (((Symbol) this.car()).getPname().equals(l.getPname())) {
				return ((Pair) this.cdr()).remdup2(l);
			} else
				return ((Pair) this.cdr()).remdup2(l).cons(this.car());
		else
			return ((Pair) this.cdr()).remdup2(l);
	}

	public ISchemeObject car() {
		return this.car;
	}

	public ISchemeObject cdr() {
		return cdr;
	}

	public ISchemeObject caar() {
		return ((Pair) this.car()).car;
	}

	public ISchemeObject cadr() {
		return ((Pair) this.cdr()).car;
	}

	public ISchemeObject cddr() {
		return ((Pair) this.cdr()).cdr;
	}

	public ISchemeObject cdar() {
		return ((Pair) this.car()).cdr;
	}

	public ISchemeObject c_r(String ad) {
		System.out.println("recursive function: c" + ad + "r");

		if (ad.length() == 0 || ad == null)
			return this;

		if (ad.endsWith("d")) {
			if (ad.length() == 1)
				return this.cdr;
			assert (this.cdr() instanceof Pair);
			return ((Pair) this.cdr()).c_r(ad.substring(0, ad.length() - 1));
		} else if (ad.endsWith("a")) {
			if (ad.length() == 1)
				return this.car;
			assert (this.car() instanceof Pair);
			return ((Pair) this.car()).c_r(ad.substring(0, ad.length() - 1));
		}

		// error
		System.err.println("Error(Pair.c_r)::unknown character found: "
				+ ad.charAt(ad.length() - 1));
		assert (false) : "unknown character found in Scheme.Pair.c_r(" + ad
				+ ")!";
		return this;
	}

	public Pair setcar(ISchemeObject x) {
		this.car = x;
		return this;
	}

	public Pair setcdr(ISchemeObject x) {
		this.cdr = x;
		return this;
	}

	public Pair rplaca(ISchemeObject x) {
		return setcar(x);
	}

	public Pair rplacd(ISchemeObject x) {
		return setcdr(x);
	}

	public Pair list() {
		return this;
	}

	@Override
	public boolean nullp() {
		return ((this instanceof Pair) && (car() == null));
	}

	@Override
	public SchemeBoolean nullpp() {
		if ((this instanceof Pair) && (car() == null))
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	@Override
	public SchemeBoolean pairp() {
		if ((this instanceof Pair) && (car() == null))
			return (RunEnv.bFalse);
		else
			return (RunEnv.bTrue);
	}

	@Override
	public SchemeBoolean listp() {
		if ((this instanceof Pair) && (car() == null))
			return (RunEnv.bTrue);
		else {
			if (cdr instanceof Pair) {
				if (!(((Pair) cdr()).car == null))
					return ((Pair) cdr()).listp();
				else
					return (RunEnv.bTrue);
			} else {
				return (RunEnv.bFalse);
			}
		}
	}

	@Override
	public SchemeBoolean not() {
		if ((this instanceof Pair) && (car() == null))
			return (RunEnv.bTrue);
		else
			return (RunEnv.bFalse);
	}

	public SchemeNumber iplus() {
		Pair x = this;
		SchemeNumber res = new SchemeInteger(0);
		while (!x.nullp()) {
			ISchemeObject nu = x.car();
			if (res instanceof SchemeInteger)
				if (nu instanceof SchemeInteger)
					res = new SchemeInteger(new Integer(
							((SchemeInteger) res).ivalue
									+ ((SchemeInteger) nu).ivalue));
				else
					res = new SchemeDouble(new Double(
							((SchemeInteger) res).ivalue
									+ ((SchemeDouble) nu).dvalue));
			else if (nu instanceof SchemeInteger)
				res = new SchemeDouble(new Double(((SchemeDouble) res).dvalue
						+ ((SchemeInteger) nu).ivalue));
			else
				res = new SchemeDouble(new Double(((SchemeDouble) res).dvalue
						+ ((SchemeDouble) nu).dvalue));
			x = (Pair) x.cdr();
		}
		return res;
	}

	public SchemeNumber itimes() {
		Pair x = this;
		SchemeNumber res = new SchemeInteger(new Integer(1));
		while (!x.nullp()) {
			ISchemeObject nu = x.car();
			if (res instanceof SchemeInteger)
				if (nu instanceof SchemeInteger)
					res = new SchemeInteger(new Integer(
							((SchemeInteger) res).ivalue
									* ((SchemeInteger) nu).ivalue));
				else
					res = new SchemeDouble(new Double(
							((SchemeInteger) res).ivalue
									* ((SchemeDouble) nu).dvalue));
			else if (nu instanceof SchemeInteger)
				res = new SchemeDouble(new Double(((SchemeDouble) res).dvalue
						* ((SchemeInteger) nu).ivalue));
			else
				res = new SchemeDouble(new Double(((SchemeDouble) res).dvalue
						* ((SchemeDouble) nu).dvalue));
			x = (Pair) x.cdr();
		}
		return res;
	}

	public SchemeBoolean eq() {
		Pair x = this;
		ISchemeObject n1 = x.car();
		ISchemeObject n2 = ((Pair) x.cdr()).car();
		if (n1 instanceof SchemeInteger)
			if (n2 instanceof SchemeInteger)
				if (((SchemeInteger) n1).ivalue == ((SchemeInteger) n2).ivalue)
					return RunEnv.bTrue;
				else
					return RunEnv.bFalse;
			else if (((SchemeInteger) n1).ivalue == ((SchemeDouble) n2).dvalue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		else if (n2 instanceof SchemeInteger)
			if (((SchemeDouble) n1).dvalue == ((SchemeInteger) n2).ivalue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		else if (((SchemeDouble) n1).dvalue == ((SchemeDouble) n2).dvalue)
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	public SchemeBoolean lt() {
		Pair x = this;
		ISchemeObject n1 = x.car();
		ISchemeObject n2 = ((Pair) x.cdr()).car();
		if (n1 instanceof SchemeInteger)
			if (n2 instanceof SchemeInteger)
				if (((SchemeInteger) n1).ivalue < ((SchemeInteger) n2).ivalue)
					return RunEnv.bTrue;
				else
					return RunEnv.bFalse;
			else if (((SchemeInteger) n1).ivalue < ((SchemeDouble) n2).dvalue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		else if (n2 instanceof SchemeInteger)
			if (((SchemeDouble) n1).dvalue < ((SchemeInteger) n2).ivalue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		else if (((SchemeDouble) n1).dvalue < ((SchemeDouble) n2).dvalue)
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	public SchemeBoolean gt() {
		Pair x = this;
		ISchemeObject n1 = x.car();
		ISchemeObject n2 = ((Pair) x.cdr()).car();
		if (n1 instanceof SchemeInteger)
			if (n2 instanceof SchemeInteger)
				if (((SchemeInteger) n1).ivalue > ((SchemeInteger) n2).ivalue)
					return RunEnv.bTrue;
				else
					return RunEnv.bFalse;
			else if (((SchemeInteger) n1).ivalue > ((SchemeDouble) n2).dvalue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		else if (n2 instanceof SchemeInteger)
			if (((SchemeDouble) n1).dvalue > ((SchemeInteger) n2).ivalue)
				return RunEnv.bTrue;
			else
				return RunEnv.bFalse;
		else if (((SchemeDouble) n1).dvalue > ((SchemeDouble) n2).dvalue)
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	public SchemeString stringappend(SchemeString s) {
		return s;
	};

	public SchemeBoolean stringle() {
		// Strings identisch ?
		int x = ((SchemeString) car()).value
				.compareTo(((SchemeString) (((Pair) cdr()).car())).value);
		if (x <= 0)
			return RunEnv.bTrue;
		else {
			return RunEnv.bFalse;
		}
	}

	/**
	 * Subtraction function.
	 * 
	 * @return no param: 0; one param: -param; two or more params: param1 -
	 *         param2 - ...
	 */
	public SchemeNumber iminus() {
		// Subtraktion (mind. 1 Parameter)
		// (falls 2 Parameter: Ergebnis = Parameter1 - Parameter2,
		// falls mehr als 2 Parameter verfuegbar sind:
		// Ergebnis = Arg1 - Arg2 - Arg3 - ...,
		// falls nur 1 Parameter: Ergebnis = Negation des Parameters,
		// falls kein Parameter uebergeben, wird vorerst 0 zurueckgegeben,
		// bis Fehler anders abgefangen wird)
		SchemeNumber res; // Returnwert
		if (!nullp()) {
			SchemeNumber minuend = ((SchemeNumber) car());
			Pair x = (Pair) cdr(); // Rest der Liste
			if (!x.nullp()) {
				// mehr als 1 Parameter uebergeben ?
				while (!x.nullp()) {
					ISchemeObject nu = x.car();
					if (minuend instanceof SchemeInteger)
						if (nu instanceof SchemeInteger)
							minuend = new SchemeInteger(new Integer(
									((SchemeInteger) minuend).ivalue
											- ((SchemeInteger) nu).ivalue));
						else
							minuend = new SchemeDouble(new Double(
									((SchemeInteger) minuend).ivalue
											- ((SchemeDouble) nu).dvalue));
					else if (nu instanceof SchemeInteger)
						minuend = new SchemeDouble(new Double(
								((SchemeDouble) minuend).dvalue
										- ((SchemeInteger) nu).ivalue));
					else
						minuend = new SchemeDouble(new Double(
								((SchemeDouble) minuend).dvalue
										- ((SchemeDouble) nu).dvalue));
					x = (Pair) x.cdr(); // Rest der Liste
				}
			} else {
				// falls nur 1 Argument vorhanden
				if (minuend instanceof SchemeInteger)
					minuend = new SchemeInteger(new Integer(-1
							* ((SchemeInteger) minuend).ivalue)); // Negation
				else
					minuend = new SchemeDouble(new Double(-1
							* ((SchemeDouble) minuend).dvalue)); // Negation
			}
			if (minuend instanceof SchemeInteger)
				res = new SchemeInteger(new Integer(
						((SchemeInteger) minuend).ivalue));
			else
				res = new SchemeDouble(new Double(
						((SchemeDouble) minuend).dvalue));
		} else {
			// falls kein Parameter uebergeben wurde
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	public SchemeNumber idivision() {
		// Division (mind. 1 Parameter)
		// (falls 2 Parameter: Ergebnis = Parameter1 / Parameter2,
		// falls mehr als 2 Parameter verfuegbar sind:
		// Ergebnis = Arg1 / Arg2 / Arg3 / ...
		// falls nur 1 Parameter: Ergebnis = 1 / Parameterwert,
		// falls kein Parameter uebergeben, wird vorerst 0 zurueckgegeben,
		// bis Fehler anders abgefangen wird)
		// (bei Division durch Null wird 0 zurueckgegeben)
		SchemeNumber res; // Returnwert
		double divisor_i;
		if (!nullp()) {
			SchemeNumber divident, divisor;
			divident = ((SchemeNumber) car());
			Pair x = (Pair) cdr(); // Rest der Liste
			if (!x.nullp()) // mehr als 1 Parameter uebergeben ?
			{
				while (!x.nullp()) {
					divisor = ((SchemeNumber) x.car());

					if (divisor instanceof SchemeInteger)
						divisor_i = ((SchemeInteger) divisor).ivalue;
					else
						divisor_i = ((SchemeDouble) divisor).dvalue;

					if (divisor_i != 0) {
						if (divident instanceof SchemeInteger)
							if (divisor instanceof SchemeInteger) {
								divident = new SchemeDouble(
										new Double(
												(double) ((SchemeInteger) divident).ivalue
														/ (double) ((SchemeInteger) divisor).ivalue)); // wenn
																										// beide
																										// Zahlen
																										// int
																										// dann
																										// (double)
																										// notwendig
																										// sonst
																										// falsche
																										// Ergebnis

								// ganzzahligkeit pruefen
								if (((SchemeDouble) divident).dvalue == (Math
										.round(((SchemeDouble) divident).dvalue)))
									divident = new SchemeInteger(
											new Integer(
													(new Double(
															((SchemeDouble) divident).dvalue)
															.intValue())));
							} else
								divident = new SchemeDouble(
										new Double(
												((SchemeInteger) divident).ivalue
														/ ((SchemeDouble) divisor).dvalue));
						else if (divisor instanceof SchemeInteger)
							divident = new SchemeDouble(new Double(
									((SchemeDouble) divident).dvalue
											/ ((SchemeInteger) divisor).ivalue));
						else
							divident = new SchemeDouble(new Double(
									((SchemeDouble) divident).dvalue
											/ ((SchemeDouble) divisor).dvalue));
						x = (Pair) x.cdr();
					} else // Division durch Null
					{
						divident = new SchemeInteger(new Integer(0));
						break; // Berechnung (while) abbrechen
					}
				}
			} else // falls nur 1 Parameter uebergeben wurde
			{
				if (divident instanceof SchemeInteger)
					if (((SchemeInteger) divident).ivalue != 0) {
						divident = new SchemeDouble(new Double((double) 1
								/ (double) ((SchemeInteger) divident).ivalue));

						// ganzzahligkeit pruefen
						if (((SchemeDouble) divident).dvalue == (Math
								.round(((SchemeDouble) divident).dvalue))) {
							divident = new SchemeInteger(new Integer(
									(new Double(
											((SchemeDouble) divident).dvalue)
											.intValue())));
						}
					} else // Division durch Null
					{
						divident = new SchemeInteger(new Integer(0));
					}
				else if (((SchemeDouble) divident).dvalue != 0) {
					divident = new SchemeDouble(new Double(
							1 / ((SchemeDouble) divident).dvalue));
				} else // Division durch Null
				{
					divident = new SchemeInteger(new Integer(0));
				}
			}
			if (divident instanceof SchemeInteger)
				res = new SchemeInteger(new Integer(
						((SchemeInteger) divident).ivalue));
			else
				res = new SchemeDouble(new Double(
						((SchemeDouble) divident).dvalue));
		} else // falls kein Parameter uebergeben wurde
		{
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	public SchemeNumber iexpt() {
		// x hoch y (mind. 2 Parameter)
		// (falls 2 Parameter: Ergebnis = Parameter1 "hoch" Parameter2,
		// falls mehr als 2 Parameter verfuegbar sind:
		// Ergebnis = ((Arg1 "hoch" Arg2) "hoch" Parameter3) "hoch" ...,
		// falls kein oder nur 1 Parameter verfuegbar ist,
		// wird 0 zurueckgegeben)
		SchemeNumber res; // Returnwert
		if (!nullp()) {
			SchemeNumber basis, exponent; // , tmp;
			basis = ((SchemeNumber) car());
			Pair x = (Pair) cdr(); // Rest der Liste
			if (!x.nullp()) // mind. 2 Parameterwerte verfuegbar ?
			{
				while (!x.nullp()) {
					exponent = (SchemeNumber) x.car();

					if (basis instanceof SchemeInteger)
						if (exponent instanceof SchemeInteger) {
							basis = new SchemeDouble(new Double(Math.pow(
									(((SchemeInteger) basis).ivalue),
									(((SchemeInteger) exponent).ivalue))));
							if (((SchemeDouble) basis).dvalue == (Math
									.round(((SchemeDouble) basis).dvalue)))
								basis = new SchemeInteger(new Integer(
										(new Double(
												((SchemeDouble) basis).dvalue)
												.intValue())));
						} else
							basis = new SchemeDouble(new Double(Math.pow(
									(((SchemeInteger) basis).ivalue),
									(((SchemeDouble) exponent).dvalue))));
					else if (exponent instanceof SchemeInteger)
						basis = new SchemeDouble(new Double(Math.pow(
								(((SchemeDouble) basis).dvalue),
								(((SchemeInteger) exponent).ivalue))));
					else
						basis = new SchemeDouble(new Double(Math.pow(
								(((SchemeDouble) basis).dvalue),
								(((SchemeDouble) exponent).dvalue))));

					x = (Pair) x.cdr();
				}
			} else // falls nur 1 Parameterwert verfuegbar
			{
				basis = new SchemeInteger(new Integer(0));
			}
			if (basis instanceof SchemeInteger)
				res = new SchemeInteger(new Integer(
						((SchemeInteger) basis).ivalue));
			else
				res = new SchemeDouble(
						new Double(((SchemeDouble) basis).dvalue));
		} else
			// falls kein Parameter uebergeben wurde
			res = new SchemeInteger(new Integer(0));
		return res;
	}

	public SchemeNumber quotient() {
		SchemeNumber res; // Returnwert
		double divisor_i;
		if (!nullp()) {
			SchemeNumber divident, divisor;
			SchemeInteger quotient;
			divident = ((SchemeNumber) car());
			Pair x = (Pair) cdr(); // Rest der Liste
			if (!x.nullp()) // mehr als 1 Parameter uebergeben ?
			{
				divisor = ((SchemeNumber) x.car());

				if (divisor instanceof SchemeInteger)
					divisor_i = ((SchemeInteger) divisor).ivalue;
				else
					divisor_i = ((SchemeDouble) divisor).dvalue;

				if (divisor_i != 0) {
					if (divident instanceof SchemeInteger)
						if (divisor instanceof SchemeInteger)
							quotient = new SchemeInteger(new Integer(
									((SchemeInteger) divident).ivalue
											/ ((SchemeInteger) divisor).ivalue));
						else
							quotient = new SchemeInteger(
									new Integer(
											new Double(
													((SchemeInteger) divident).ivalue
															/ ((SchemeDouble) divisor).dvalue)
													.intValue()));
					else if (divisor instanceof SchemeInteger)
						quotient = new SchemeInteger(new Integer(
								new Double(((SchemeDouble) divident).dvalue
										/ ((SchemeInteger) divisor).ivalue)
										.intValue()));
					else
						quotient = new SchemeInteger(new Integer(
								new Double(((SchemeDouble) divident).dvalue
										/ ((SchemeDouble) divisor).dvalue)
										.intValue()));
				} else // Division durch Null
				{
					System.out.print("Fehler: (quotient ");
					System.out.print(divident);
					System.out.println(" 0)");
					quotient = new SchemeInteger(new Integer(0));
				}
			} else // falls nur 1 Parameter uebergeben wurde
			{
				System.out.println("Fehler: Falsche Anzahl Paramter");
				quotient = new SchemeInteger(new Integer(0));
			}
			res = new SchemeInteger(new Integer(quotient.ivalue));
		} else // falls kein Parameter uebergeben wurde
		{
			System.out.println("Fehler: Falsche Anzahl Paramter");
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	public SchemeNumber remainder() {
		SchemeNumber res; // Returnwert
		double divisor_i;
		if (!nullp()) {
			SchemeNumber divident, divisor, quotient;
			divident = ((SchemeNumber) car());
			Pair x = (Pair) cdr(); // Rest der Liste
			if (!x.nullp()) // mehr als 1 Parameter uebergeben ?
			{
				divisor = ((SchemeNumber) x.car());

				if (divisor instanceof SchemeInteger)
					divisor_i = ((SchemeInteger) divisor).ivalue;
				else
					divisor_i = ((SchemeDouble) divisor).dvalue;

				if (divisor_i != 0) {
					if (divident instanceof SchemeInteger)
						if (divisor instanceof SchemeInteger)
							quotient = new SchemeInteger(new Integer(
									((SchemeInteger) divident).ivalue
											% ((SchemeInteger) divisor).ivalue));
						else
							quotient = new SchemeDouble(
									new Double(
											new Double(
													((SchemeInteger) divident).ivalue
															% ((SchemeDouble) divisor).dvalue)
													.intValue()));
					else if (divisor instanceof SchemeInteger)
						quotient = new SchemeDouble(new Double(
								new Double(((SchemeDouble) divident).dvalue
										% ((SchemeInteger) divisor).ivalue)
										.intValue()));
					else
						quotient = new SchemeDouble(new Double(
								new Double(((SchemeDouble) divident).dvalue
										% ((SchemeDouble) divisor).dvalue)
										.intValue()));
				} else // Division durch Null
				{
					System.out.print("Fehler: (remainder ");
					System.out.print(divident);
					System.out.println(" 0)");
					quotient = new SchemeInteger(new Integer(0));
				}
			} else // falls nur 1 Parameter uebergeben wurde
			{
				System.out.println("Fehler: Falsche Anzahl Paramter");
				quotient = new SchemeInteger(new Integer(0));
			}
			if (quotient instanceof SchemeInteger)
				res = new SchemeInteger(new Integer(
						((SchemeInteger) quotient).ivalue));
			else
				res = new SchemeDouble(new Double(
						((SchemeDouble) quotient).dvalue));
		} else // falls kein Parameter uebergeben wurde
		{
			System.out.println("Fehler: Falsche Anzahl Paramter");
			res = new SchemeInteger(0);
		}
		return res;
	}

	public SchemeNumber min() {
		Pair x = (Pair) this.car();
		SchemeNumber res = new SchemeInteger(new Integer(Integer.MAX_VALUE));

		while (!x.nullp()) {
			ISchemeObject nu = x.car();
			if (res instanceof SchemeInteger) {
				if (nu instanceof SchemeInteger) {
					if ((((SchemeInteger) nu).ivalue) < (((SchemeInteger) res).ivalue))
						res = new SchemeInteger(new Integer(
								((SchemeInteger) nu).ivalue));
				} else if ((((SchemeDouble) nu).dvalue) < (((SchemeInteger) res).ivalue)) {
					res = new SchemeDouble(new Double(
							((SchemeDouble) nu).dvalue));
				}
			} else {
				if (nu instanceof SchemeInteger)
					if ((((SchemeInteger) nu).ivalue) < (((SchemeDouble) res).dvalue))
						res = new SchemeInteger(new Integer(
								((SchemeInteger) nu).ivalue));
					else if ((((SchemeDouble) nu).dvalue) < (((SchemeDouble) res).dvalue))
						res = new SchemeDouble(new Double(
								((SchemeDouble) nu).dvalue));
			}
			x = ((Pair) x.cdr());
		}
		return res;
	}

	public SchemeNumber max() {
		Pair x = (Pair) this.car();
		SchemeNumber res = new SchemeInteger(new Integer(Integer.MIN_VALUE));

		while (!x.nullp()) {
			ISchemeObject nu = x.car();
			if (res instanceof SchemeInteger) {
				if (nu instanceof SchemeInteger) {
					if ((((SchemeInteger) nu).ivalue) > (((SchemeInteger) res).ivalue))
						res = new SchemeInteger(new Integer(
								((SchemeInteger) nu).ivalue));
				} else if ((((SchemeDouble) nu).dvalue) > (((SchemeInteger) res).ivalue)) {
					res = new SchemeDouble(new Double(
							((SchemeDouble) nu).dvalue));
				}
			} else {
				if (nu instanceof SchemeInteger)
					if ((((SchemeInteger) nu).ivalue) > (((SchemeDouble) res).dvalue))
						res = new SchemeInteger(new Integer(
								((SchemeInteger) nu).ivalue));
					else if ((((SchemeDouble) nu).dvalue) > (((SchemeDouble) res).dvalue))
						res = new SchemeDouble(new Double(
								((SchemeDouble) nu).dvalue));
			}
			x = ((Pair) x.cdr());
		}
		return res;
	}

	public SchemeNumber length() {
		SchemeNumber res; // Returnwert
		if (!nullp()) {
			int anzahl = 0;
			Pair x = (Pair) car(); // Rest der Liste

			if (!x.nullp()) // mehr als 1 Parameter uebergeben ?
			{
				while (!x.nullp()) {
					anzahl = anzahl + 1;
					x = (Pair) x.cdr();
				}
			}
			res = new SchemeInteger(new Integer(anzahl));
		} else // falls kein Parameter uebergeben wurde
		{
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	public SchemeNumber abs() {
		SchemeNumber res; // Returnwert
		if (!nullp()) {
			SchemeNumber wert;
			wert = (SchemeNumber) car();

			if (wert instanceof SchemeInteger)
				res = new SchemeInteger(new Integer(
						Math.abs(((SchemeInteger) wert).ivalue)));
			else
				res = new SchemeDouble(new Double(
						Math.abs(((SchemeDouble) wert).dvalue)));
		} else // falls kein Parameter uebergeben wurde
		{
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	public SchemeNumber exactinexact() {
		SchemeNumber res; // Returnwert
		if (!nullp()) {
			SchemeNumber wert;
			wert = (SchemeNumber) car();

			if (wert instanceof SchemeInteger)
				res = new SchemeDouble(
						new Double(((SchemeInteger) wert).ivalue));
			else
				res = new SchemeDouble(new Double(((SchemeDouble) wert).dvalue));
		} else // falls kein Parameter uebergeben wurde
		{
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	public SchemeNumber inexactexact() {
		SchemeNumber res; // Returnwert
		if (!nullp()) {
			SchemeNumber wert;
			wert = (SchemeNumber) car();

			if (wert instanceof SchemeInteger)
				res = new SchemeInteger(new Integer(
						((SchemeInteger) wert).ivalue));
			else
				res = new SchemeInteger(new Integer(
						(int) Math.round(((SchemeDouble) wert).dvalue)));
		} else // falls kein Parameter uebergeben wurde
		{
			res = new SchemeInteger(new Integer(0));
		}
		return res;
	}

	/* *********************** Closure ********************************* */

	public Pair closure() {
		// System.out.println("+++ in closure");
		// System.out.println("");

		Pair freevars;
		if (((Pair) this.cdr()).car() instanceof Symbol) {
			// System.out.println("+++ in case of form (lambda x ...)");
			freevars = fv2(((Symbol) ((Pair) this.cdr()).car()),
					((Pair) ((Pair) this.cdr()).cdr()));
		} else {
			// fv(Parameterliste, Lambda-Koerper)
			// System.out.println("+++ in case of form (lambda (...)...)");
			freevars = fv(((Pair) ((Pair) this.cdr()).car()),
					((Pair) ((Pair) this.cdr()).cdr()));
		}
		// aus freevars werden die Namen funktionaler Objekte und von
		// Expandierungen jetzt entfernt!
		Pair mem = freevars.member(definesym);
		if ((!mem.nullp())
				&& (freevars.member(definesym).car()).equals(definesym)) {
			freevars = freevars.remove(definesym);
			// freevars.write();
		}
		Pair ubvv = freevars.searchgb(); // liefert Liste der Werte
											// Werte wurden zusaetzlich
											// gequotet!
		// System.out.println("Liste der Werte der freien Variablen:");
		// freevars.print();
		// System.out.println();
		// ubvv.print();
		// System.out.println();
		// Pair ubvvv = ubvv.ubvcdr(); // Liste der Werte
		// ubvvv.print();
		// System.out.println();
		Pair w = RunEnv.nilval;
		Pair u = ((Pair) ((Pair) this.cdr()).cdr());
		u = u.cons(RunEnv.nilval);
		u = u.cons(RunEnv.interns("lambda"));
		u = RunEnv.nilval.cons(u);
		u = RunEnv.nilval.cons(u);
		Pair uu = RunEnv.nilval.cons(RunEnv.interns("xxx"));
		// Speichern Variablen
		// Pair arg=RunEnv.nilval.cons((SchemeObject)RunEnv.interns("xx"));
		// arg=arg.cons((SchemeObject)RunEnv.interns("car"));
		uu = fc2(freevars, RunEnv.nilval.cons(RunEnv.interns("xx"))).append(uu);
		// uu.print();
		// System.out.println();

		uu = uu.cons(RunEnv.nilval.cons(RunEnv.interns("xxx")));
		uu = uu.cons(RunEnv.interns("lambda"));
		u = u.cons(uu);
		u = RunEnv.nilval.cons(u);
		u = u.cons(freevars.append((RunEnv.nilval).cons(RunEnv.interns("xx"))));
		u = u.cons(RunEnv.interns("lambda"));
		w = w.cons(ubvv.cons(u));
		if (((Pair) this.cdr()).car() instanceof Symbol) {
			w = w.cons((((Pair) this.cdr()).car()));
		} else {
			w = w.cons((((Pair) this.cdr()).car()));
		}
		w = w.cons(RunEnv.interns("lambda"));

		// Pair lam = ((Pair)((Pair)((Pair)((Pair)w).cdr()).cdr()).car());
		Pair lam = ((Pair) ((Pair) w.cdr()).cdr());
		((Pair) lam.car()).fc3(freevars, lam);
		// lam.print();
		// w.print();
		return w;
	}

	private Pair fc2(Pair fvars, Pair befarg) {
		if (fvars.nullp())
			return RunEnv.nilval;
		else {
			Pair bef = RunEnv.nilval;
			// bef=bef.cons(fvars.car());
			bef = bef.cons(RunEnv.nilval.cons((fvars.car())).cons(
					(RunEnv.interns("valact"))));
			Pair befarg1 = befarg.cons(RunEnv.interns("cdr"));
			bef = bef.cons(befarg1);
			bef = bef.cons(RunEnv.interns("rplaca"));
			befarg1 = RunEnv.nilval.cons(befarg1);
			return fc2((Pair) fvars.cdr(), befarg1).cons(bef);
		}
	}

	private void fc3(Pair fvars, Pair l) {
		if (fvars.nullp())
			this.rplacd(l);
		else {
			((Pair) (this.cdr())).fc3((Pair) fvars.cdr(), l);
		}
	}

	private Pair fv(Pair vars, Pair body) {
		Pair ubv = (Pair) searchv(body);
		// ubv.print();
		ubv = ubv.remdup(vars);
		// ubv.print();
		// ubv = (Pair) ubv.searchb(RunEnv.stack);
		ubv = body.remlocallambdas(ubv);
		ubv = remfunctions(ubv);
		return ubv;
	}

	private Pair fv2(Symbol var, Pair body) {
		Pair ubv = (Pair) searchv(body);
		// ubv.print();
		ubv = ubv.remdup2(var);
		// ubv.print();
		// ubv = (Pair) ubv.searchb(RunEnv.stack);
		ubv = body.remlocallambdas(ubv);
		ubv = remfunctions(ubv);
		return ubv;
	}

	private Pair remfunctions(Pair vars) {
		if (vars.nullp())
			return vars;
		else if ((((Symbol) vars.car()).getValue() instanceof SchemeFunction)
				|| (((Symbol) vars.car()).getPname().equals("quote"))
				|| (((Symbol) vars.car()).getPname().equals("set!"))
				|| (((Symbol) vars.car()).getPname().equals("if"))
				|| (((Symbol) vars.car()).getPname().equals("lambda"))
				|| (((Symbol) vars.car()).getPname().equals("letrec")))
			return remfunctions((Pair) vars.cdr());
		else
			return remfunctions((Pair) vars.cdr()).cons(vars.car());
	}

	private ISchemeObject searchv(ISchemeObject l) {
		if (l instanceof Pair)
			if (l.nullp())
				return l;
			else
				return ((Pair) searchv((((Pair) l).cdr()))).
				// cons(searchv(((Pair)l).car()));
						append(((Pair) searchv(((Pair) l).car())));
		else if (l instanceof Symbol)
			// if (!((((Symbol)l).getMode().equals("assigned"))||
			// (((Symbol)l).getMode().equals("implemented"))))
			if (!(((Symbol) l).isModeSetTo(modeType.IMPLEMENTED)))
				return RunEnv.nilval.cons(l);
			else
				return RunEnv.nilval;
		else
			return RunEnv.nilval;
	}

	private Pair searchgb() {
		if (this.nullp())
			return RunEnv.nilval;
		else {
			Pair t = (((Pair) this.cdr()).searchgb());
			if (((Symbol) this.car()).isModeSetTo(modeType.ASSIGNED)) {
				ISchemeObject searchval = ((ISchemeObject) ((Symbol) this.car())
						.getValue());
				return t.cons(RunEnv.nilval.cons(searchval).cons(
						RunEnv.interns("quote")));
				// alt: return ((Pair)t).cons( searchval);
			} else
				// return ((Pair)t).cons(RunEnv.nilval);
				return t.cons(RunEnv.unbound);
		}
	}

	private Pair searchb(Stack s) {
		if (s.empty())
			return RunEnv.nilval;
		else {
			Pair elem = (Pair) s.top();
			// elem.print();
			s.pop();
			if ((this.member(elem.car())).equals(RunEnv.nilval))
				return this.searchb(s);
			else
				return (this.searchb(s)).cons(elem);
		}
	}

	public Pair ubvcdr() { // nicht benoetigt!
		if (nullp())
			return RunEnv.nilval;
		else
			return ((Pair) cdr()).ubvcdr().cons(((Pair) car()).cdr());
	}

	public Pair remlocallambdas(Pair frees) {
		if (nullp())
			return frees;
		else {
			if ((car() instanceof Pair)
					&& (((Pair) car()).car() instanceof Pair)
					&& (((Symbol) ((Pair) ((Pair) car()).car()).car())
							.getPname().equals("lambda"))) {
				frees = frees.removel((Pair) ((Pair) ((Pair) ((Pair) car())
						.car()).cdr()).car());
				// rekursiv im Koerper:
				frees = ((Pair) ((Pair) ((Pair) ((Pair) this.car()).car())
						.cdr()).cdr()).remlocallambdas(frees);
				// rekursiv in den aktuellen Parametern:
				frees = ((Pair) ((Pair) this.car()).cdr())
						.remlocallambdas(frees);
				frees = ((Pair) this.cdr()).remlocallambdas(frees);
			} else if ((car() instanceof Pair)
					&& (((Symbol) ((Pair) car()).car()).getPname()
							.equals("lambda"))) {
				frees = frees.removel((Pair) ((Pair) ((Pair) car()).cdr())
						.car());
				frees = ((Pair) ((Pair) ((Pair) this.car()).cdr()).cdr())
						.remlocallambdas(frees);
				frees = ((Pair) this.cdr()).remlocallambdas(frees);
			} else
				frees = ((Pair) this.cdr()).remlocallambdas(frees);
			return frees;
		}
	}

	public Pair removel(Pair li) {
		// entfernen aller in li enthaltenen Namen aus der Liste der freien
		// Variablen
		if (li.nullp())
			return this;
		else {
			Pair z = this.remove(li.car());
			return z.removel((Pair) li.cdr());
		}
	}

	/* ************************ Apply ********************************* */

	private ISchemeObject apply_function(SchemeFunction op)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// test variables
		// System.out.println("Pair.apply_intern:");
		// System.out.println("   type:  " + op.getType());
		// System.out.println("   class: " + op.getClassn());
		// System.out.println("   pname: " + op.getPname());
		// System.out.println("   params: " + op.getParams());
		// System.out.println("   value: " + op.getValue());
		// System.out.println("   car: " + this.car());

		switch (op.getType()) {

		case EXTERN: {
			// System.out.println("+ apply: extern gefunden: "+
			// ((SchemeFunction)op).getPname());
			// Object ob = Class.forName(((SchemeFunction)op).
			// getClassn()).newInstance();
			// System.out.println("+ apply: Instanz erzeugt");

			// extract function (method)
			assert (op.getValue() instanceof Method);
			Method m = (Method) op.getValue();

			// get number of parameters of function
			int leng = op.getParams().length;
			// prepare parameters object for method invocation
			Pair al = this;
			Object[] pars;
			pars = new Object[leng];
			for (int i = 0; i < leng; i++) {
				pars[i] = al.car();
				al = (Pair) al.cdr();
			}
			// Object [] pars = {(Pair)this.car(),
			// (Pair)((Pair)this.cdr()).car()};

			// invoke method
			m.invoke(op.getInst(), pars);
			System.out.println("+ apply: nach dem externen Methodenaufruf");

			return RunEnv.nilval;
		}

		case EXPRp: {
			// (function? x) ==> x.function if exists, else return false
			// e.g. null?, integer? (ISchemeInteger), number? (ISchemeNumber)
			try {
				Object retobj = ((Method) op.getValue()).invoke(this.car(),
						(Object[]) op.getParams());
				assert (retobj instanceof ISchemeObject) : "Error(Scheme.Pair.apply_intern)::invoke return object is not a ISchemeObject!";
				return (ISchemeObject) retobj;
			} catch (IllegalArgumentException e) {
				// method not found ==
				// java.lang.IllegalArgumentException: object is not an instance
				// of declaring class
				return RunEnv.bFalse;
			}
		}

		case EXPR: {
			// (function x) ==> x.function()
			// e.g. car, cdr, null?
			if (((this.car() instanceof SchemeInteger) || (this.car() instanceof SchemeDouble))
					&& (op.getPname().equals("eval"))) {
				return this.car();
			} else {
				Object retobj = ((Method) op.getValue()).invoke(this.car(),
						(Object[]) op.getParams());
				assert (retobj instanceof ISchemeObject) : "Error(Scheme.Pair.apply_intern)::invoke return object is not a ISchemeObject!";
				return (ISchemeObject) retobj;
			}
		}

		case EXPR2: {
			// (function (x ...) ...) ==> x.function
			// e.g. cons, eq?, equal?
			Object[] par = { this.car() };
			return ((ISchemeObject) ((Method) op.getValue()).invoke(
					((Pair) this.cdr()).car(), par));
		}

		case EXPR2r: {
			// ...
			// e.g. append, set-car!, set-cdr!
			Object[] par = { ((Pair) this.cdr()).car() };
			return ((ISchemeObject) ((Method) op.getValue()).invoke(
					((Pair) this.car()), par));
		}

		case tEXPR: {
			if (((Boolean) ((Method) op.getValue()).invoke(this.car(),
					(Object[]) op.getParams())).booleanValue()) {
				return RunEnv.bTrue;
			} else {
				return RunEnv.bFalse;
			}
		}

		case CLOSURE: {
			ISchemeObject elem;
			// System.out.println("+ apply: closure gefunden: "+((SchemeFunction)op).getPname());
			Pair.closurestatus = true;
			// System.out.println("apply:closurestatus eingeschaltet");
			Pair opc = op.getBody();
			// System.out.println("vor bind Akt. Parameter: ");
			// this.print();
			// System.out.println();
			if (((Pair) opc.cdr()).car() instanceof Symbol) {
				RunEnv.bind1((Symbol) ((Pair) opc.cdr()).car(), this);
			} else {
				RunEnv.bind((Pair) ((Pair) opc.cdr()).car(), this);
			}
			// System.out.println("apply: auswerten des Lambda-Koerpers beginnt");
			// ((Pair)((Pair)((Pair)((Pair)opc).cdr()).cdr()).car()).car().print();
			// System.out.println();
			// System.out.println("1. Argument fuer freie Variable:");
			// ((Pair)((Pair)((Pair)((Pair)((Pair)opc).cdr()).cdr()).car()).cdr()).car().print();
			// System.out.println("2. Argument fuer freie Variable:");
			// ((Pair)((Pair)((Pair)((Pair)((Pair)((Pair)opc).cdr()).cdr()).car()).cdr()).cdr()).car().print();
			// System.out.println();
			Pair body = ((Pair) ((Pair) opc.cdr()).cdr());
			elem = RunEnv.nilval;
			while (!(body.nullp())) {
				elem = body.car().eval();
				// System.out.println("apply: Ausdruck im L-K ausgewertet:");
				// elem.print();
				// System.out.println();
				body = (Pair) body.cdr();
			}
			if (((Pair) opc.cdr()).car() instanceof Symbol) {
				RunEnv.unbind1((Symbol) ((Pair) opc.cdr()).car());
			} else {
				RunEnv.unbind((Pair) ((Pair) opc.cdr()).car());
			}
			Pair.closurestatus = false;
			// System.out.println("apply: closurestatus ausgeschaltet");
			return elem;
		}

		case LIST: {
			// this case is the default one
			return ((ISchemeObject) ((Method) op.getValue()).invoke(this,
					(Object[]) op.getParams()));
		}

		}

		// error
		assert (false) : "Error(Pair.apply_intern)::error case.";
		return RunEnv.nilval;
	}

	private ISchemeObject apply_lambda(Pair op) {

		// bind
		assert (op.cdr() instanceof Pair);
		assert (((Pair) op.cdr()).car() instanceof Pair);
		RunEnv.bind((Pair) ((Pair) op.cdr()).car(), this);

		// get body of lambda-expression
		// System.out.println("auszuwerten ist::");
		// ((Pair)((Pair)((Pair)op).cdr()).cdr()).car().print();
		assert (((Pair) op.cdr()).cdr() instanceof Pair);
		Pair body = ((Pair) ((Pair) op.cdr()).cdr());

		ISchemeObject elem1 = RunEnv.nilval;
		while (!(body.nullp())) {
			// System.out.println("apply: eval. Ausdr. im Lam.-Koerper:");
			// body.car().print();
			// System.out.println();
			elem1 = body.car();
			if (elem1 instanceof Symbol)
				elem1 = ((Symbol) elem1).eval();
			else
				elem1 = elem1.eval();
			body = (Pair) body.cdr();
		}
		// ((Pair)((Pair)op).cdr()).car().print();

		// unbind
		RunEnv.unbind((Pair) ((Pair) op.cdr()).car());
		// System.out.println("apply: nach unbind im Lambda-Koerper");
		// elem1.print();
		// System.out.println();
		return elem1;
	}

	public ISchemeObject apply(ISchemeObject op) {
		// op: function ...
		if (op instanceof SchemeFunction) {
			SchemeFunction opFunc = (SchemeFunction) op;
			// System.out.println("+ enter apply: "+((SchemeFunction)op).getPname()+
			// " "+
			// ((SchemeFunction)op).getType() );
			try {
				return apply_function(opFunc);
			} catch (Exception e) {
				System.err.println("Error(Pair.apply::op=function)::"
						+ e.getMessage());
				return this;
			}
		}

		// op: (lambda ...)
		if ((op instanceof Pair) && (((Pair) op).car() instanceof Symbol)
				&& (((Symbol) ((Pair) op).car()).getPname().equals("lambda"))) {
			// System.out.println("apply :: lambda-Ausdruck als Funktion");
			return apply_lambda((Pair) op);
		}

		// TODO: useful ???
		if (op instanceof Pair && ((Pair) op).nullp()) {
			return RunEnv.nilval;
		}

		// error!
		System.err.println("Error(Pair.apply)::" + "Type of function '"
				+ op.sprint() + "' is unknown! +++++++");
		return RunEnv.nilval;
	}

	/* *********************** Expand ********************************* */

	@Override
	public ISchemeObject expandall() {
		if (!(this instanceof Pair))
			return this;
		else if (nullp())
			return RunEnv.nilval;
		else {
			Pair tailexpand = (Pair) ((Pair) ((Pair) cdr()).expandall())
					.expand();
			// System.out.println("--- expanded---");
			// tailexpand.print();
			// System.out.println();
			return tailexpand.cons(car().expandall());
		}
	}

	public Pair expandlist() {
		if (nullp())
			return RunEnv.nilval;
		else
			return ((Pair) cdr()).expandlist().cons(car().expand());
	}

	@Override
	public ISchemeObject expand() {
		if (this instanceof Pair)
			// let ------------------------------------------------- let
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("let"))
					&& (cdr() instanceof Pair)
					&& (((Pair) cdr()).car() instanceof Pair)
					&& (((Pair) cdr()).cdr() instanceof Pair)) {
				Pair lunexp = ((Pair) ((Pair) cdr()).cdr());
				Pair lexpand = lunexp.expandlist();
				Pair l = (lexpand.cons(((Pair) ((Pair) cdr()).car()).vn())
						.cons((RunEnv.interns("lambda"))));
				Pair pl = (Pair) ((Pair) cdr()).car();
				Pair ex = pl.vl().cons(l);
				// ex.print();
				// System.out.println();
				return ex;
			} else
			// let* ---------------------------------------- let*
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("let*"))
					&& (cdr() instanceof Pair)
					&& (((Pair) cdr()).cdr() instanceof Pair)) {
				if (((((Pair) cdr()).car()) instanceof Pair)
						&& (((Pair) ((Pair) cdr()).car()).car() == null)) { // Spezialfall
																			// RunEnv.nilval.cons(((Pair)((Pair)((Pair)cdr()).cdr()).cons(RunEnv.nilval))
																			// .cons((SchemeObject)RunEnv.interns("lambda"))).write();
					return RunEnv.nilval
							.cons(((Pair) ((Pair) cdr()).cdr()).cons(
									RunEnv.nilval).cons(
									RunEnv.interns("lambda")));
				} else {
					Pair lexs = RunEnv.nilval
							.cons((((Pair) ((Pair) cdr()).cdr())
									.cons(((Pair) ((Pair) cdr()).car()).cdr())
									.cons(RunEnv.interns("let*"))))
							.cons(RunEnv.nilval.cons(((Pair) ((Pair) cdr())
									.car()).car())).cons(RunEnv.interns("let"));

					lexs = (Pair) lexs.expand();
					// lexs.write();
					return lexs;
				}
			} else
			// letrec ---------------------------------------- letrec
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("letrec"))
					&& (cdr() instanceof Pair)
					&& (((Pair) cdr()).car() instanceof Pair)
					&& (((Pair) cdr()).cdr() instanceof Pair)) {
				Pair body = ((Pair) ((Pair) cdr()).cdr()).expandlist();
				// body.print();
				// System.out.println();
				Pair lex = RunEnv.nilval
						.cons(((Pair) ((Pair) cdr()).car()).settwo()
								.append(body)
								.cons((((Pair) ((Pair) cdr()).car()).lettwo()))
								.cons((RunEnv.interns("let"))))
						.cons(((Pair) ((Pair) cdr()).car()).vundef())
						.cons(RunEnv.interns("let"));
				// lex.print();
				// System.out.println();
				// System.out.println();
				// Expandieren letrec
				lex = (Pair) lex.expand();
				// lex.print();
				// System.out.println();
				// System.out.println();
				/*
				 * // Expandieren let lex = (Pair)lex.expand(); lex.print();
				 * System.out.println(); System.out.println();
				 */
				return lex;

			} else
			// expandieren -------------------------------- DO ---
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("do"))
					&& (cdr() instanceof Pair)) {
				// System.out.println("do expandieren:");
				Pair sequence = (Pair) ((Pair) ((Pair) ((Pair) this.cdr())
						.cdr()).car()).cdr();
				sequence = sequence.cons(RunEnv.interns("begin"));
				Pair command = (Pair) ((Pair) ((Pair) this.cdr()).cdr()).cdr();
				command = command.cons(RunEnv.interns("begin"));
				Pair step = ((Pair) ((Pair) this.cdr()).car()).steplist();
				step = step.cons(RunEnv.interns("$loop$"));
				step = RunEnv.nilval.cons(step);
				step = command.append(step);
				Pair lambdabody = RunEnv.nilval
						.cons(step)
						.cons(sequence)
						.cons(((Pair) ((Pair) ((Pair) this.cdr()).cdr()).car())
								.car()).cons(RunEnv.interns("if"));
				Pair lambdaexp = RunEnv.nilval.cons(lambdabody)
						.cons(((Pair) ((Pair) this.cdr()).car()).varlist())
						.cons(RunEnv.interns("lambda"));
				Pair letrecvars = RunEnv.nilval.cons(RunEnv.nilval.cons(
						lambdaexp).cons(RunEnv.interns("$loop$")));
				Pair doexp = RunEnv.nilval
						.cons(((Pair) ((Pair) this.cdr()).car()).initlist()
								.cons(RunEnv.interns("$loop$")))
						.cons(letrecvars).cons(RunEnv.interns("letrec"));
				// doexp.print();
				// System.out.println();
				doexp = (Pair) doexp.expand();
				return doexp;
			} else
			// expandieren -------------------------------- COND ---
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("cond"))
					&& (cdr() instanceof Pair)) {
				Pair clauselist = (Pair) cdr();
				Pair res1 = clauselist.condexp();
				// res1.print();
				// System.out.println();
				return res1;
			} else if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("caaar")
							|| ((Symbol) car()).getPname().equals("caadr")
							|| ((Symbol) car()).getPname().equals("cadar")
							|| ((Symbol) car()).getPname().equals("caddr")
							|| ((Symbol) car()).getPname().equals("cdaar")
							|| ((Symbol) car()).getPname().equals("cdadr")
							|| ((Symbol) car()).getPname().equals("cddar") || ((Symbol) car())
							.getPname().equals("cdddr"))
					&& (cdr() instanceof Pair)) {
				String part1 = ((Symbol) car()).getPname().substring(0, 3)
						+ "r";
				String part2 = "c"
						+ ((Symbol) car()).getPname().substring(3, 5);
				Pair c = (expand2(part1, part2));
				return c;
			} else if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("caaaar")
							|| ((Symbol) car()).getPname().equals("caaadr")
							|| ((Symbol) car()).getPname().equals("caadar")
							|| ((Symbol) car()).getPname().equals("caaddr")
							|| ((Symbol) car()).getPname().equals("cadaar")
							|| ((Symbol) car()).getPname().equals("cadadr")
							|| ((Symbol) car()).getPname().equals("caddar")
							|| ((Symbol) car()).getPname().equals("cadddr")
							|| ((Symbol) car()).getPname().equals("cdaaar")
							|| ((Symbol) car()).getPname().equals("cdaadr")
							|| ((Symbol) car()).getPname().equals("cdadar")
							|| ((Symbol) car()).getPname().equals("cdaddr")
							|| ((Symbol) car()).getPname().equals("cddaar")
							|| ((Symbol) car()).getPname().equals("cddadr")
							|| ((Symbol) car()).getPname().equals("cdddar") || ((Symbol) car())
							.getPname().equals("cddddr"))
					&& (cdr() instanceof Pair)) {
				String part1 = ((Symbol) car()).getPname().substring(0, 3)
						+ "r";
				String part2 = "c"
						+ ((Symbol) car()).getPname().substring(3, 6);
				Pair c = (expand2(part1, part2));
				return c;
			} else if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("and")))
			// and -------------------------------------- and
			{
				if (((Pair) cdr()).car() == null) {
					return RunEnv.bTrue;
				} else if (((Pair) ((Pair) cdr()).cdr()).car() == null)
					return ((Pair) cdr()).car();
				else {
					Pair clauselist = (Pair) cdr();
					Pair thunk = RunEnv.nilval.cons(
							RunEnv.nilval
									.cons(((Pair) clauselist.cdr()).cons(
											RunEnv.interns("and")).expand())
									.cons(RunEnv.nilval)
									.cons(RunEnv.interns("lambda"))).cons(
							RunEnv.interns("thunk"));
					Pair locvars = RunEnv.nilval.cons(thunk).cons(
							RunEnv.nilval.cons(((Pair) cdr()).car()).cons(
									RunEnv.interns("x")));
					Pair andbody = RunEnv.nilval
							.cons(RunEnv.nilval
									.cons(RunEnv.interns("x"))
									.cons(RunEnv.nilval.cons(RunEnv
											.interns("thunk")))
									.cons(RunEnv.interns("x"))
									.cons(RunEnv.interns("if"))).cons(locvars)
							.cons(RunEnv.interns("letrec"));
					andbody = (Pair) andbody.expand();
					return andbody;
				}
			} else if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("or")))
			// or -------------------------------------- or
			{
				if (((Pair) cdr()).car() == null) {
					return RunEnv.bFalse;
				} else if (((Pair) ((Pair) cdr()).cdr()).car() == null)
					return ((Pair) cdr()).car();
				else {
					Pair clauselist = (Pair) cdr();
					Pair thunk = RunEnv.nilval.cons(
							RunEnv.nilval
									.cons(((Pair) clauselist.cdr()).cons(
											RunEnv.interns("or")).expand())
									.cons(RunEnv.nilval)
									.cons(RunEnv.interns("lambda"))).cons(
							RunEnv.interns("thunk"));
					Pair locvars = RunEnv.nilval.cons(thunk).cons(
							RunEnv.nilval.cons(((Pair) cdr()).car()).cons(
									RunEnv.interns("x")));
					Pair orbody = RunEnv.nilval
							.cons(RunEnv.nilval
									.cons(RunEnv.nilval.cons(RunEnv
											.interns("thunk")))
									.cons(RunEnv.interns("x"))
									.cons(RunEnv.interns("x"))
									.cons(RunEnv.interns("if"))).cons(locvars)
							.cons(RunEnv.interns("letrec"));
					// andbody.print();
					// System.out.println();
					orbody = (Pair) orbody.expand();
					// andbody.print();
					// System.out.println();
					return orbody;
				}
			}

			else
				return this;
		else
			return this;
	}

	public Pair expand2(String part1, String part2) {
		Pair erg = (RunEnv.nilval.cons(cdr().cons((RunEnv.interns(part2))))
				.cons((RunEnv.interns(part1))));
		return erg;
	}

	public ISchemeObject orexp() {
		if (this.nullp()) {
			return RunEnv.bFalse;
		} else {
			if (((SchemeBoolean) car()) == RunEnv.bTrue) {
				ISchemeObject e1 = RunEnv.bTrue;
				return e1;
			} else {
				Pair clauselist = (Pair) cdr();
				if (clauselist.cdr() instanceof Pair) {
					return clauselist.orexp();
				} else {
					ISchemeObject e2 = RunEnv.bFalse;
					return e2;
				}
			}
		}
	}

	public Pair condexp() {
		if (this.nullp()) {
			return RunEnv.nilval;
		} else {

			ISchemeObject e1 = RunEnv.interns("begin");

			Pair e2 = (Pair) ((Pair) this.car()).cdr();
			// e2.print();
			// Pair e3 =
			// ((Pair)((Pair)((Pair)RunEnv.nilval).cons(e2)).cons(e1));
			Pair e3 = e2.cons(e1);
			ISchemeObject e4 = ((Pair) this.car()).car();
			if ((e4 instanceof Symbol)
					&& (((Symbol) e4).getPname().equals("else")))
				e4 = RunEnv.bTrue;
			Pair rval = RunEnv.nilval.cons(((Pair) cdr()).condexp()).cons(e3)
					.cons(e4).cons(RunEnv.interns("if"));
			return rval;
		}
	}

	public Pair vn() {
		// print();
		if (nullp())
			return RunEnv.nilval;
		else {
			Symbol v;
			if (car() instanceof Symbol)
				v = (Symbol) car();
			else
				v = (Symbol) (((Pair) car()).car());
			return ((Pair) cdr()).vn().cons(v);
		}
	}

	public Pair vl() {
		// print();
		if (nullp())
			return RunEnv.nilval;
		else {
			ISchemeObject v;
			if (car() instanceof Symbol)
				v = RunEnv.nilval;
			else
				// v=((Pair)((Pair)car()).cdr()).car().eval();
				v = ((Pair) ((Pair) car()).cdr()).car();
			return ((Pair) cdr()).vl().cons(v);
		}
	}

	public Pair lettwo() {
		// print();
		if (nullp())
			return RunEnv.nilval;
		else {
			ISchemeObject vtwo = ((Pair) ((Pair) car()).cdr()).car();
			if ((vtwo instanceof Pair)
					&& (((Pair) vtwo).car() instanceof Symbol)
					&& (((Symbol) ((Pair) vtwo).car()).getPname()
							.equals("lambda"))) {
				vtwo = ((Pair) vtwo).expandlist();
				// vtwo.print(); System.out.println();
			}
			Pair ptwo = RunEnv.nilval
					.cons(vtwo)
					.cons(RunEnv.interns("$"
							+ ((Symbol) ((Pair) car()).car()).getPname() + "$"));
			// ptwo.print(); System.out.println();
			return ((Pair) cdr()).lettwo().cons(ptwo);
		}
	}

	public Pair settwo() {
		// print();
		if (nullp())
			return RunEnv.nilval;
		else {
			ISchemeObject vstwo = ((Pair) car()).car();
			Pair pptwo = RunEnv.nilval
					.cons(RunEnv.interns("$"
							+ ((Symbol) ((Pair) car()).car()).getPname() + "$"))
					.cons(vstwo).cons(RunEnv.interns("set!"));
			return ((Pair) cdr()).settwo().cons(pptwo);
		}
	}

	public Pair vundef() {
		// print();
		if (nullp())
			return RunEnv.nilval;
		else {
			Pair pvun = RunEnv.nilval.cons(RunEnv.bTrue).cons(
					((Pair) car()).car());
			// pvun.print(); System.out.println();
			return ((Pair) cdr()).vundef().cons(pvun);
		}
	}

	public Pair initlist() {
		if (nullp())
			return RunEnv.nilval;
		else
			return ((Pair) cdr()).initlist().cons(
					((Pair) ((Pair) car()).cdr()).car());
	}

	public Pair varlist() {
		if (nullp())
			return RunEnv.nilval;
		else
			return ((Pair) cdr()).varlist().cons(((Pair) car()).car());
	}

	public Pair steplist() {
		if (nullp())
			return RunEnv.nilval;
		else
			return ((Pair) cdr()).steplist().cons(
					((Pair) ((Pair) ((Pair) car()).cdr()).cdr()).car());
	}

	/* *********************** Evaluation ********************************* */

	public ISchemeObject evlis(Pair l) {
		if ((this instanceof Pair) && (car() == null))
			return this;
		else {
			if ((this.car()).equals(l)) {
				// System.out.println("evlis: Abbruch wegen schleife");
				return this;
			} else {
				// System.out.println("evlis: auszuwerten:");
				// car().print();
				// System.out.println();
				return ((Pair) ((Pair) cdr()).evlis(l)).cons(car().expand()
						.eval());
			}
		}
	}

	@Override
	public ISchemeObject eval() {
		// System.out.println("eval in Pair");
		if (RunEnv.read_status) {
			// wenn akuteller read Aufruf mit aktueller Datenzeile gleich
			if (RunEnv.number_read_call_temp == RunEnv.number_read_data_temp) {
				RunEnv.read_object = RunEnv.root; // aktuelle SchemeObject
													// merken
			}
			RunEnv.number_read_data_temp = RunEnv.number_read_data_temp + 1;
			return this;
		} else {
			// quote - Form
			if ((car() instanceof Symbol) && (cdr() instanceof Pair)
					&& (((Symbol) car()).getPname().equals("quote")))
				return ((Pair) cdr()).car();
			else
			// quasiquote - Form
			if ((car() instanceof Symbol) && (cdr() instanceof Pair)
					&& (((Symbol) car()).getPname().equals("quasiquote")))
				return quasiquote(((Pair) cdr()).car());
			else
			// define - Form
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("define"))
					&& (cdr() instanceof Pair)
					&& (((Pair) cdr()).car() instanceof Symbol)
					&& (((Pair) cdr()).cdr() instanceof Pair)) {
				definesym = (Symbol) ((Pair) cdr()).car();
				ISchemeObject def;
				if (((Pair) ((Pair) cdr()).cdr()).nullp())
					def = RunEnv.bTrue;
				else
					def = (((Pair) ((Pair) cdr()).cdr()).car()).expand().eval();
				((Symbol) ((Pair) cdr()).car()).setValue(def);
				((Symbol) ((Pair) cdr()).car()).setModeToAssigned();
				((Symbol) ((Pair) cdr()).car()).setToplevelValue(def);
				return (ISchemeObject) ((Symbol) ((Pair) cdr()).car())
						.getValue();
			} else
			// begin - Form
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("begin"))
					&& (cdr() instanceof Pair)) {
				Pair l = (Pair) cdr(); // "begin" abtrennen
				ISchemeObject x = new Pair(); // leere Liste
				while (!l.nullp()) {
					x = l.car().expand().eval();
					l = (Pair) (l.cdr());
				}
				return x;
			} else
			// if - Form
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("if"))
					&& (cdr() instanceof Pair)) {
				ISchemeObject bed = ((Pair) cdr()).car().expand().eval();
				if ((!(bed.nullp()))
						&& (!((bed instanceof SchemeBoolean) && (bed
								.equals(RunEnv.bFalse)))))
					return (((Pair) ((Pair) cdr()).cdr()).car()).expand()
							.eval();
				else if (!((Pair) ((Pair) ((Pair) cdr()).cdr()).cdr()).nullp())
					return (((Pair) ((Pair) ((Pair) cdr()).cdr()).cdr()).car())
							.eval();
				else
					return new Pair();
			} else
			// set! - Form
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("set!"))
					&& (cdr() instanceof Pair)
					&& (((Pair) cdr()).car() instanceof Symbol)
					&& ((Symbol) ((Pair) cdr()).car())
							.isModeSetTo(modeType.ASSIGNED)) {
				if (((Symbol) ((Pair) cdr()).car()).getValue().equals(
						RunEnv.unbound)) {
					// set! - Form / unbound
					// System.out.println("Neuer Toplevel-Wert");System.out.println();
					((Symbol) ((Pair) cdr()).car())
							.setToplevelValue((((Pair) ((Pair) cdr()).cdr())
									.car()).expand().eval());
					return (ISchemeObject) ((Symbol) ((Pair) cdr()).car())
							.getToplevelValue();
				} else {
					if (RunEnv.stack.empty()) {
						((Symbol) ((Pair) cdr()).car())
								.setToplevelValue((((Pair) ((Pair) cdr()).cdr())
										.car()).expand().eval());
					}
					((Symbol) ((Pair) cdr()).car())
							.setValue((((Pair) ((Pair) cdr()).cdr()).car())
									.expand().eval());
					return (ISchemeObject) ((Symbol) ((Pair) cdr()).car())
							.getValue();
				}
			} else
			// nur im Closurestatus verwendet (in rplaca-Aufrufen als
			// Zugriffsfunktion generiert)!
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("valact"))
					&& (cdr() instanceof Pair)
					&& (((Pair) cdr()).car() instanceof Symbol)) {
				ISchemeObject valactval = (ISchemeObject) ((Symbol) ((Pair) cdr())
						.car()).getValue();
				return RunEnv.nilval.cons(valactval).cons(
						RunEnv.interns("quote"));
			} else
			// Lambda - Form
			if ((car() instanceof Symbol)
					&& (((Symbol) car()).getPname().equals("lambda"))) {
				// System.out.println("eval: Lambda gefunden");
				if (Pair.closurestatus == true) {
					// System.out.println("eval : lambda-Form im closurestatus");
					return this;
				} else {
					SchemeFunction cl = new SchemeFunction();
					Pair thisobject = ((Pair) ((Pair) this.cdr()).cdr())
							.expandlist().cons(((Pair) cdr()).car())
							.cons(car());
					Pair body = thisobject.closure();
					// System.out.println("eval : exit closure-Aufruf");
					// body.print();
					cl.setBody(body);
					return cl;
				}
			} else
			// Procedure call
			if (cdr() instanceof Pair) {
				// if (car() instanceof Symbol)
				// System.out.println("+ eval:"+ ((Symbol)car()).getPname() );
				// {
				// if (car() instanceof Pair)&&
				// (car().car() instanceof Symbol)&&
				// (((Symbol)car().car()).getPname().equals("lambda")) {
				// ..;
				// }
				// else {
				Pair thisobject = (Pair) this.expand();
				// Pair arl = (Pair)((Pair)cdr()).evlis(this);
				Pair arl = (Pair) ((Pair) cdr()).evlis(thisobject);
				if (!closurestatus) {
					// arl.print();
					// System.out.println();
				}
				// SchemeObject func = car().eval();
				ISchemeObject func = thisobject.car().eval();
				boolean cstat = closurestatus;
				/*
				 * if (func instanceof SchemeFunction){
				 * System.out.println("SchemeFunction!"); func.write();
				 * System.out.println(); }
				 */
				// func.getType().equals("extern")){
				// Class.forName(((SchemeFunction)x).getClassn()).getInstance().apply(func);
				// SchemeObject res= .apply(func);
				// else
				ISchemeObject res = arl.apply(func);
				;
				closurestatus = cstat;
				// System.out.println("eval: after apply - res:");
				// res.print();
				// System.out.println();
				return res;
				// }
			} else
				return this;
		}
	}

	public static ISchemeObject quasiquote(ISchemeObject e) {
		if (e instanceof Pair) {
			if (((Pair) e).cdr() == null)
				return e;
			else if ((((Pair) e).car() instanceof Symbol)
					&& (((Pair) e).cdr() instanceof Pair)
					&& (((Symbol) ((Pair) e).car()).getPname()
							.equals("unquote"))) {
				return ((Pair) ((Pair) e).cdr()).car().eval();
			} else {
				Pair b = (Pair) quasiquote(((Pair) e).cdr()).cons(
						quasiquote(((Pair) e).car()));
				return b;
			}
		} else
			return e;
	}

	public void treeeval(boolean trace) {
		if (!(nullp())) {
			if (trace) {
				System.out.print("::> ");
				car().print();
				System.out.println("");
			}
			ISchemeObject exp = car().expand().eval();
			if (trace) {
				exp.print();
				System.out.println("");
				System.out.println("");
			}
			((Pair) cdr()).treeeval(trace);
		}
	}

	// neu in RunEnv programmiert
	public ISchemeObject write() {
		return RunEnv.write(this);
	}

	@Override
	public String sprint() {
		if (car == null)
			return "NIL";

		return "(" + sprintlist() + ")";
	}

	public String sprintlist() {
		if (car == null)
			return "";

		String list = car.sprint() + " ";
		if (cdr instanceof Pair) {
			Pair cdrPair = (Pair) cdr;
			if (cdrPair.car != null)
				list += cdrPair.sprintlist();
		} else {
			list += ". " + cdr.sprint();
		}
		return list;
	}

	@Override
	public void print() {
		System.out.print(sprint());
	}

	public void printlist() {
		System.out.print(sprintlist());
	}

	@Override
	public ISchemeObject printp(BufferedWriter open_buffer_writer) {
		String text;
		try {
			if (car == null) {
				text = "NIL";
				open_buffer_writer.write(text);
			} else {
				text = "(";
				open_buffer_writer.write(text);
				printplist(open_buffer_writer);
				text = ")";
				open_buffer_writer.write(text);
			}
		} catch (Exception e) {
			System.err.println("Error(Pair.printplist)::" + e.getMessage());
		}
		return RunEnv.nilval;
	}

	public void printplist(BufferedWriter open_buffer_writer) {
		String text;
		try {
			car().printp(open_buffer_writer);
			text = " ";
			open_buffer_writer.write(text);
			if (cdr instanceof Pair) {
				if (!(((Pair) cdr()).car == null))
					((Pair) cdr()).printplist(open_buffer_writer);
			} else {
				text = ". ";
				open_buffer_writer.write(text);
				cdr().printp(open_buffer_writer);
			}
		} catch (Exception e) {
			System.err.println("Error(Pair.printplist)::" + e.getMessage());
		}
	}

	public ISchemeObject newline() {
		System.out.println("");
		return RunEnv.nilval;
	}

}
