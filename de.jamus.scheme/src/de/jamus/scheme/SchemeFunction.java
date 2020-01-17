package de.jamus.scheme;

import java.io.BufferedWriter;

public class SchemeFunction extends StElem implements ISchemeFunction {

	/**
	 * The environment of the function.
	 */
	ISchemeObject Environment;

	/**
	 * The name of the class which implements the function.
	 */
	Class<?> class_name;

	/**
	 * The parameters of the function as Class<?>.
	 */
	Class<?>[] params = {};

	/**
	 * The type of the function. The scheme interpreter must know who a function
	 * is called.
	 */
	exprType type = exprType.LIST;

	/**
	 * The body of the function.
	 */
	Pair body;

	/**
	 * The instance of the function.
	 */
	Object instobject;

	public SchemeFunction(String function_name, Class<?> class_name,
			exprType type, Class<?>... params) {
		super(function_name);

		init(function_name, class_name, type, params);
	}

	public SchemeFunction(String scheme_function_name,
			String java_function_name, Class<?> class_name, exprType type,
			Class<?>... params) {
		super(scheme_function_name);

		init(java_function_name, class_name, type, params);
	}

	public SchemeFunction(String function_name, Class<?> class_name,
			exprType type, Object instObject, Class<?>... params) {
		super(function_name);

		if (init(function_name, class_name, type, params)) {
			this.instobject = instObject;
		}
	}

	public SchemeFunction(String scheme_function_name,
			String java_function_name, Class<?> class_name, exprType type,
			Object instObject, Class<?>... params) {
		super(scheme_function_name);

		if (init(java_function_name, class_name, type, params)) {
			this.instobject = instObject;
		}
	}

	/**
	 * Creates an anonymous function (lambda function) object.
	 * 
	 * After creation, the body of the function has to be set with setBody()!
	 */
	public SchemeFunction() {
		super("");
		this.type = exprType.CLOSURE;

		try {
			// this.class_name = Class.forName("Scheme.Pair");
			this.class_name = Class.forName("de.jamus.scheme.Pair");
		} catch (ClassNotFoundException e) {
			System.err.println("Error(SchemeFunction):::" + "Class "
					+ e.getMessage() + " not found!");
		}
	}

	private boolean init(String java_function_name, Class<?> class_name,
			exprType type, Class<?>... params) {
		assert (java_function_name != "");
		this.class_name = class_name;
		this.type = type;

		try {
			this.setValue(class_name.getDeclaredMethod(java_function_name,
					params));
			this.setParams(params);
			this.setModeToImplemented();
			return true;
		} catch (SecurityException e) {
			System.err.println("Error(SchemeFunction)::" + e.getMessage());
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.err.println("Error(SchemeFunction)::" + e.getMessage());
		}
		return false;
	}

	public Object getInst() {
		return instobject;
	}

	public String getClassn() {
		return class_name.getSimpleName();
	}

	private void setParams(Class<?>[] params) {
		this.params = params;
	}

	public Class<?>[] getParams() {
		return params;
	}

	protected exprType getType() {
		return type;
	}

	protected boolean isTypeSetTo(exprType type) {
		return (type == this.type);
	}

	public Pair getBody() {
		return body;
	}

	public void setBody(Pair b) {
		body = b;
	}

	@Override
	public ISchemeObject eval() {
		return this;
	}

	@Override
	public String sprint() {
		return "#<function>";
	}

	@Override
	public void print() {
		System.out.print(sprint());
	}

	@Override
	public ISchemeObject printp(BufferedWriter open_buffer_writer) {
		try {
			open_buffer_writer.write(sprint());
			open_buffer_writer.newLine();
		} catch (Exception e) {
			System.err.println("Error(SchemeObject.printp)::" + e.getMessage());
		}
		return RunEnv.nilval;
	}
}
