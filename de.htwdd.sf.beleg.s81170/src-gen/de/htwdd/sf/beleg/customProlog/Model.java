/**
 * generated by Xtext 2.12.0
 */
package de.htwdd.sf.beleg.customProlog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.Model#getExpressions <em>Expressions</em>}</li>
 * </ul>
 *
 * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
   * The list contents are of type {@link de.htwdd.sf.beleg.customProlog.Prologdsl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expressions</em>' containment reference list.
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getModel_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<Prologdsl> getExpressions();

} // Model
