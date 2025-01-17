/**
 * generated by Xtext 2.12.0
 */
package de.htwdd.sf.beleg.customProlog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.Predicate#getFunctor <em>Functor</em>}</li>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.Predicate#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends EObject
{
  /**
   * Returns the value of the '<em><b>Functor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functor</em>' containment reference.
   * @see #setFunctor(Functor)
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getPredicate_Functor()
   * @model containment="true"
   * @generated
   */
  Functor getFunctor();

  /**
   * Sets the value of the '{@link de.htwdd.sf.beleg.customProlog.Predicate#getFunctor <em>Functor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Functor</em>' containment reference.
   * @see #getFunctor()
   * @generated
   */
  void setFunctor(Functor value);

  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference list.
   * The list contents are of type {@link de.htwdd.sf.beleg.customProlog.Term}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference list.
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getPredicate_Term()
   * @model containment="true"
   * @generated
   */
  EList<Term> getTerm();

} // Predicate
