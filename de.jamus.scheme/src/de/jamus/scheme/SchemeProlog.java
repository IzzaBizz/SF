/**
 * 
 */
package de.jamus.scheme;

import de.jamus.scheme.StElem.modeType;

/**
 * @author mkain
 * 
 */
public final class SchemeProlog implements ISchemeProlog {

	private static Stack var_stack = new Stack(1000);
	private static Pair var_list = new Pair();

	/*
	 * (non-Javadoc)
	 * 
	 * @see Scheme.ISchemeProlog#add_fact(Scheme.ISchemeObject)
	 */
	@Override
	public void add_fact(ISchemeObject head) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Scheme.ISchemeProlog#add_rule(Scheme.ISchemeObject,
	 * Scheme.ISchemeObject)
	 */
	@Override
	public void add_rule(ISchemeObject head, ISchemeObject body) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Scheme.ISchemeProlog#question(Scheme.ISchemeObject)
	 */
	@Override
	public void question(ISchemeObject body) {
		// TODO Auto-generated method stub

	}

	public ISchemeObject unify(ISchemeObject l1, ISchemeObject l2) {
		if (l1.eqp(l2) == RunEnv.bTrue) {
			if (l1 instanceof ISchemePair && l2 instanceof ISchemePair)
				return unify_help(((ISchemePair) l1).cdr(),
						((ISchemePair) l2).cdr(), new Pair());
			return RunEnv.bTrue;
		}
		return RunEnv.bFalse;
	}

	private ISchemeObject unify_help(ISchemeObject l1, ISchemeObject l2,
			ISchemeObject u) {
		if (l1.nullp() && l2.nullp())
			return u;
		if (l1.equalp(l2) == RunEnv.bTrue)
			return u;

		if (variablep(l1, var_list)) {
			assert (l1 instanceof Symbol);
			Symbol sl1 = (Symbol) l1;
			if (SchemeProlog.boundp(sl1, var_list)) {
				u = unify_help(toList(getval(sl1)), toList(l2), u);
				if (u.eqp(RunEnv.bFalse) == RunEnv.bTrue)
					return RunEnv.bFalse;
				return u;
			}
			if (occur(sl1, l2))
				return RunEnv.bFalse;

			setval(sl1, toList(l2));
			return u.cons(l2.cons(l1));
		}

		if (variablep(l2, var_list))
			return unify_help(l2, l1, u);

		if (atomp(l1) || atomp(l2))
			return RunEnv.bFalse;

		if (l1 instanceof ISchemePair && l2 instanceof ISchemePair) {
			ISchemePair pl1 = (ISchemePair) l1;
			ISchemePair pl2 = (ISchemePair) l2;
			u = unify_help(pl1.car(), pl2.car(), u);
			if (u.eqp(RunEnv.bFalse) == RunEnv.bTrue)
				return RunEnv.bFalse;

			return unify_help(pl1.cdr(), pl2, u);
		}

		return RunEnv.bFalse;
	}

	private static boolean variablep(ISchemeObject obj, Pair variable_list) {
		return ((obj instanceof Symbol) && (variable_list.member(obj) != RunEnv.nilval));
	}

	private static boolean boundp(ISchemeObject var, Pair variable_list) {
		if (!(var instanceof Symbol) || !variablep(var, variable_list))
			return false;
		assert (var instanceof Symbol);
		boolean b = ((Symbol) var).isModeSetTo(modeType.UNASSIGNED);
		return !b;
	}

	private static ISchemeObject getval(Symbol var) {
		return (ISchemeObject) var.getValue();
	}

	private static void setval(Symbol var, Pair val) {
		RunEnv.bind1(var, val, var_stack);
	}

	private static Pair toList(ISchemeObject obj) {
		return RunEnv.nilval.cons(obj);
	}

	private static boolean atomp(ISchemeObject obj) {
		return !(obj instanceof ISchemePair);
	}

	private static boolean occur(Symbol var, ISchemeObject expr) {
		if (var.eqp(expr) == RunEnv.bTrue)
			return true;

		if (variablep(expr, var_list)) {
			if (var.equalp(expr) == RunEnv.bTrue)
				return true;
			if (boundp(expr, var_list)) {
				assert (expr instanceof Symbol);
				return occur(var, getval((Symbol) expr));
			}
			return false;
		}

		if (atomp(expr))
			return false;

		assert (expr instanceof ISchemePair);
		ISchemePair pexpr = (ISchemePair) expr;
		if (occur(var, pexpr.car()))
			return true;
		return occur(var, pexpr.cdr());
	}
}
