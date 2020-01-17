package de.jamus.scheme;

import java.io.BufferedWriter;

public abstract class StElem extends SchemeObject {
	/**
	 * The possible mode types of a StElem object. The previous representation
	 * as string was replaced by this enumeration.
	 * 
	 * @author Angelos Drossos
	 */
	public enum modeType {
		ASSIGNED, UNASSIGNED, IMPLEMENTED, UNIMPLEMENTED
	}

	/** The name of this StElem object. */
	protected String pname;

	/** The value of this StElem object. */
	protected Object value;

	/** ?? */
	protected Object toplevelvalue;

	/** The next symbol after this StElem object. */
	protected Symbol next;

	/** The current saved mode of this StElem object. */
	private modeType mode;

	/**
	 * Initialize a new StElem object with mode set to unassigned.
	 */
	public StElem() {
		setModeToUnassigned();
	}

	/**
	 * 
	 */

	/**
	 * Initialize a new StElem object with a given name. If this name is 'if',
	 * 'begin' or 'define', then the mode is set to implemented, else the mode
	 * is set to unassigned.
	 * 
	 * @param pname
	 *            the name of this StElem, e.g. 'if', 'begin', 'define'.
	 */
	public StElem(String pname) {
		this.pname = pname;
		if ((pname.equals("if")) || (pname.equals("begin"))
				|| (pname.equals("define")))
			setModeToImplemented();
		else
			setModeToUnassigned();
	}

	/**
	 * Get the current name of this StElem object.
	 * 
	 * @return the current name.
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * Set a new name of this StElem object.
	 * 
	 * @note The mode is not changed.
	 * 
	 * @param pname
	 *            the new name
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object e) {
		value = e;
	}

	public Object getToplevelValue() {
		return toplevelvalue;
	}

	public void setToplevelValue(Object e) {
		toplevelvalue = e;
		// this.write();
		// System.out.println(" - new Toplevel-Value!");
	}

	protected void setModeToAssigned() {
		mode = modeType.ASSIGNED;
	}

	protected void setModeToUnassigned() {
		mode = modeType.UNASSIGNED;
	}

	protected void setModeToImplemented() {
		mode = modeType.IMPLEMENTED;
	}

	protected void setModeToUnimplemented() {
		mode = modeType.UNIMPLEMENTED;
	}

	protected boolean isModeSetTo(modeType mode) {
		return (mode == this.mode);
	}

	@Override
	public ISchemeObject eval() {
		if (this == RunEnv.unbound)
			return this;

		if ((this instanceof Symbol)
				&& ((((Symbol) this).isModeSetTo(modeType.UNASSIGNED)) || (this
						.getValue() == RunEnv.unbound))) {
			// Symbol is unassigned or unbound
			if (toplevelvalue == null) {
				// Error because there is no top level value
				System.err
						.println("Error(StElem.eval)::There is no top level value!");
				return RunEnv.nilval;
			} else {
				// take top level value
				return (ISchemeObject) this.getToplevelValue();
			}
		} else {
			if (this.getValue() instanceof SchemeFunction) {
				return (SchemeFunction) this.getValue();
			} else {
				// Warning: Cycle because of x.setValue(x) for SchemeBoolean!
				return (ISchemeObject) this.getValue();
			}
		}
	}

	public SchemeString symbolstring() {
		return new SchemeString("\"" + getPname() + "\"");
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
			System.err.println("Error(SchemeObject.printp)::" + e.getMessage());
		}
		return RunEnv.nilval;
	}

	/*
	 * public SchemeObject write(){ System.out.print(pname);
	 * System.out.println(""); return RunEnv.nilval; }
	 */
}
