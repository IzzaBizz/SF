/*
 * generated by Xtext 2.11.0
 */
package de.htwdd.sf.beleg.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import de.htwdd.sf.beleg.customProlog.Fact
import de.htwdd.sf.beleg.customProlog.Program
import de.htwdd.sf.beleg.customProlog.Clause
import de.htwdd.sf.beleg.customProlog.Predicate
import de.htwdd.sf.beleg.customProlog.Term
import de.htwdd.sf.beleg.customProlog.List
import de.htwdd.sf.beleg.customProlog.Exquery
import de.htwdd.sf.beleg.customProlog.Functor
import de.htwdd.sf.beleg.services.CustomPrologGrammarAccess.PrologdslElements
import de.htwdd.sf.beleg.customProlog.Prologdsl
import de.htwdd.sf.beleg.customProlog.Query
import de.htwdd.sf.beleg.customProlog.Atom
import de.htwdd.sf.beleg.customProlog.Rule
import de.htwdd.sf.beleg.customProlog.NonEmptyList
import de.htwdd.sf.beleg.customProlog.Folge

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class CustomPrologLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:
	def text(Program p) {
		'Program'
	}

	def text(Clause c) {
		'Clause'
	}

	def text(Prologdsl p) {
		'Prologdsl'
	}

	def text(PrologdslElements e) {
		'PrologdslElement'
	}

	def text(Predicate p) {
		'Predicate: '
	}

	def text(List l) {
		'List'
	}
	
	def text(Folge f) {
		'Folge'
	}

	def text(Exquery e) {
		'?- Exquery'
	}

	def text(Functor f) {
		'Functor "' + f.funcName + '"'
	}

	def text(Fact f) {
		'Fact'
	}

	def text(Atom a) {
		return a.ident
	}
	
	def text(Term t) {
		'Term'
	}

	def text(Query q) {
		'Query'
	}
	
	def text(Rule r) {
		'Rule'
	}
	
	def text(NonEmptyList nel) {
		'NonEmptyList'
	}
}