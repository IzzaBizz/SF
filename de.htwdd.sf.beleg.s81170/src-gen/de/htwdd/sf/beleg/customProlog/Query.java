/**
 * generated by Xtext 2.12.0
 */
package de.htwdd.sf.beleg.customProlog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.Query#getP <em>P</em>}</li>
 * </ul>
 *
 * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getQuery()
 * @model
 * @generated
 */
public interface Query extends EObject
{
  /**
   * Returns the value of the '<em><b>P</b></em>' containment reference list.
   * The list contents are of type {@link de.htwdd.sf.beleg.customProlog.Predicate}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>P</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>P</em>' containment reference list.
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getQuery_P()
   * @model containment="true"
   * @generated
   */
  EList<Predicate> getP();

} // Query