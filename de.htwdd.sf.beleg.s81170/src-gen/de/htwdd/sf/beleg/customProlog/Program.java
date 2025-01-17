/**
 * generated by Xtext 2.12.0
 */
package de.htwdd.sf.beleg.customProlog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.Program#getClauses <em>Clauses</em>}</li>
 * </ul>
 *
 * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject
{
  /**
   * Returns the value of the '<em><b>Clauses</b></em>' containment reference list.
   * The list contents are of type {@link de.htwdd.sf.beleg.customProlog.Clause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clauses</em>' containment reference list.
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getProgram_Clauses()
   * @model containment="true"
   * @generated
   */
  EList<Clause> getClauses();

} // Program
