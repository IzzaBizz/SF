package de.jamus.scheme;

public class List {
	private Object car;
	private List cdr;

	public List() {
		car = this;
		cdr = this;
	}

	public boolean nullp() {
		if (this.cdr == this)
			return (true);
		else
			return (false);
	}

	public List cons(Object e) {
		List newcell = new List();
		newcell.car = e;
		newcell.cdr = this;
		return (newcell);
	}

	public List reverse() {
		if (this.nullp())
			return this;
		else
			return ((this.cdr()).reverse())
					.append((new List()).cons(this.car()));
	}

	public List append(List l) {
		if (this.nullp())
			return l;
		else
			return ((this.cdr()).append(l)).cons(this.car());
	}

	public Object car() {
		if (cdr != this)
			return (car);
		else {
			System.out.println("Car einer leeren Liste");
			return (null);
		}
	}

	public List cdr() {
		if (cdr != this) {
			return (cdr);
		} else {
			System.out.println("Cdr einer leeren Liste");
			return (null);
			// throw new NullPointerException("Cdr einer leeren Liste");
		}
	}

	public int length() {
		if (this.nullp())
			return 0;
		else
			return 1 + (this.cdr()).length();
	}

	public int lengthex() {
		try {
			return 1 + (this.cdr()).lengthex();
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public List member(Object el) {
		if (this.nullp())
			return this;
		else if (el.equals(this.car()))
			return this;
		else
			return (this.cdr()).member(el);
	}

	public Object nth(Integer n) {
		return (null);
	}

	public void princ() {
		if (!this.nullp()) {
			System.out.print("( ");
			if (car instanceof Integer)
				System.out.print(((Integer) car).intValue());
			else if (car instanceof String) {
				System.out.print(((String) car).toString());
			} else
				((List) car).princ();
			System.out.print(" . ");
			cdr.princ();
			System.out.print(" )");
		} else
			System.out.print("nil");
	}
}
