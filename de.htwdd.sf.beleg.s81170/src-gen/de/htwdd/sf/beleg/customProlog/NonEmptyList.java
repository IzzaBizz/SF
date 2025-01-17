/**
 * generated by Xtext 2.12.0
 */
package de.htwdd.sf.beleg.customProlog;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Empty List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.NonEmptyList#getFolge <em>Folge</em>}</li>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.NonEmptyList#getAtom <em>Atom</em>}</li>
 *   <li>{@link de.htwdd.sf.beleg.customProlog.NonEmptyList#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getNonEmptyList()
 * @model
 * @generated
 */
public interface NonEmptyList extends EObject
{
  /**
   * Returns the value of the '<em><b>Folge</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Folge</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Folge</em>' containment reference.
   * @see #setFolge(Folge)
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getNonEmptyList_Folge()
   * @model containment="true"
   * @generated
   */
  Folge getFolge();

  /**
   * Sets the value of the '{@link de.htwdd.sf.beleg.customProlog.NonEmptyList#getFolge <em>Folge</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Folge</em>' containment reference.
   * @see #getFolge()
   * @generated
   */
  void setFolge(Folge value);

  /**
   * Returns the value of the '<em><b>Atom</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atom</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atom</em>' containment reference.
   * @see #setAtom(Atom)
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getNonEmptyList_Atom()
   * @model containment="true"
   * @generated
   */
  Atom getAtom();

  /**
   * Sets the value of the '{@link de.htwdd.sf.beleg.customProlog.NonEmptyList#getAtom <em>Atom</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atom</em>' containment reference.
   * @see #getAtom()
   * @generated
   */
  void setAtom(Atom value);

  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(Term)
   * @see de.htwdd.sf.beleg.customProlog.CustomPrologPackage#getNonEmptyList_Term()
   * @model containment="true"
   * @generated
   */
  Term getTerm();

  /**
   * Sets the value of the '{@link de.htwdd.sf.beleg.customProlog.NonEmptyList#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(Term value);

} // NonEmptyList
