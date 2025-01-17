/*
 * generated by Xtext 2.12.0
 */
grammar InternalCustomProlog;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@lexer::header {
package de.htwdd.sf.beleg.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.htwdd.sf.beleg.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.htwdd.sf.beleg.services.CustomPrologGrammarAccess;

}
@parser::members {
	private CustomPrologGrammarAccess grammarAccess;

	public void setGrammarAccess(CustomPrologGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleModel
entryRuleModel
:
{ before(grammarAccess.getModelRule()); }
	 ruleModel
{ after(grammarAccess.getModelRule()); } 
	 EOF 
;

// Rule Model
ruleModel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getModelAccess().getExpressionsAssignment()); }
		(rule__Model__ExpressionsAssignment)*
		{ after(grammarAccess.getModelAccess().getExpressionsAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePrologdsl
entryRulePrologdsl
:
{ before(grammarAccess.getPrologdslRule()); }
	 rulePrologdsl
{ after(grammarAccess.getPrologdslRule()); } 
	 EOF 
;

// Rule Prologdsl
rulePrologdsl 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrologdslAccess().getGroup()); }
		(rule__Prologdsl__Group__0)
		{ after(grammarAccess.getPrologdslAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleProgram
entryRuleProgram
:
{ before(grammarAccess.getProgramRule()); }
	 ruleProgram
{ after(grammarAccess.getProgramRule()); } 
	 EOF 
;

// Rule Program
ruleProgram 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getProgramAccess().getClausesAssignment()); }
			(rule__Program__ClausesAssignment)
			{ after(grammarAccess.getProgramAccess().getClausesAssignment()); }
		)
		(
			{ before(grammarAccess.getProgramAccess().getClausesAssignment()); }
			(rule__Program__ClausesAssignment)*
			{ after(grammarAccess.getProgramAccess().getClausesAssignment()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExquery
entryRuleExquery
:
{ before(grammarAccess.getExqueryRule()); }
	 ruleExquery
{ after(grammarAccess.getExqueryRule()); } 
	 EOF 
;

// Rule Exquery
ruleExquery 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExqueryAccess().getGroup()); }
		(rule__Exquery__Group__0)
		{ after(grammarAccess.getExqueryAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQuery
entryRuleQuery
:
{ before(grammarAccess.getQueryRule()); }
	 ruleQuery
{ after(grammarAccess.getQueryRule()); } 
	 EOF 
;

// Rule Query
ruleQuery 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQueryAccess().getGroup()); }
		(rule__Query__Group__0)
		{ after(grammarAccess.getQueryAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleClause
entryRuleClause
:
{ before(grammarAccess.getClauseRule()); }
	 ruleClause
{ after(grammarAccess.getClauseRule()); } 
	 EOF 
;

// Rule Clause
ruleClause 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getClauseAccess().getAlternatives()); }
		(rule__Clause__Alternatives)
		{ after(grammarAccess.getClauseAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFact
entryRuleFact
:
{ before(grammarAccess.getFactRule()); }
	 ruleFact
{ after(grammarAccess.getFactRule()); } 
	 EOF 
;

// Rule Fact
ruleFact 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFactAccess().getGroup()); }
		(rule__Fact__Group__0)
		{ after(grammarAccess.getFactAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRule
entryRuleRule
:
{ before(grammarAccess.getRuleRule()); }
	 ruleRule
{ after(grammarAccess.getRuleRule()); } 
	 EOF 
;

// Rule Rule
ruleRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleAccess().getGroup()); }
		(rule__Rule__Group__0)
		{ after(grammarAccess.getRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePredicate
entryRulePredicate
:
{ before(grammarAccess.getPredicateRule()); }
	 rulePredicate
{ after(grammarAccess.getPredicateRule()); } 
	 EOF 
;

// Rule Predicate
rulePredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicateAccess().getGroup()); }
		(rule__Predicate__Group__0)
		{ after(grammarAccess.getPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFunctor
entryRuleFunctor
:
{ before(grammarAccess.getFunctorRule()); }
	 ruleFunctor
{ after(grammarAccess.getFunctorRule()); } 
	 EOF 
;

// Rule Functor
ruleFunctor 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctorAccess().getFuncNameAssignment()); }
		(rule__Functor__FuncNameAssignment)
		{ after(grammarAccess.getFunctorAccess().getFuncNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerm
entryRuleTerm
:
{ before(grammarAccess.getTermRule()); }
	 ruleTerm
{ after(grammarAccess.getTermRule()); } 
	 EOF 
;

// Rule Term
ruleTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTermAccess().getAlternatives()); }
		(rule__Term__Alternatives)
		{ after(grammarAccess.getTermAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAtom
entryRuleAtom
:
{ before(grammarAccess.getAtomRule()); }
	 ruleAtom
{ after(grammarAccess.getAtomRule()); } 
	 EOF 
;

// Rule Atom
ruleAtom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAtomAccess().getAlternatives()); }
		(rule__Atom__Alternatives)
		{ after(grammarAccess.getAtomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleList
entryRuleList
:
{ before(grammarAccess.getListRule()); }
	 ruleList
{ after(grammarAccess.getListRule()); } 
	 EOF 
;

// Rule List
ruleList 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getListAccess().getAlternatives()); }
		(rule__List__Alternatives)
		{ after(grammarAccess.getListAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNonEmptyList
entryRuleNonEmptyList
:
{ before(grammarAccess.getNonEmptyListRule()); }
	 ruleNonEmptyList
{ after(grammarAccess.getNonEmptyListRule()); } 
	 EOF 
;

// Rule NonEmptyList
ruleNonEmptyList 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNonEmptyListAccess().getAlternatives()); }
		(rule__NonEmptyList__Alternatives)
		{ after(grammarAccess.getNonEmptyListAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFolge
entryRuleFolge
:
{ before(grammarAccess.getFolgeRule()); }
	 ruleFolge
{ after(grammarAccess.getFolgeRule()); } 
	 EOF 
;

// Rule Folge
ruleFolge 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFolgeAccess().getGroup()); }
		(rule__Folge__Group__0)
		{ after(grammarAccess.getFolgeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Clause__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClauseAccess().getFactAssignment_0()); }
		(rule__Clause__FactAssignment_0)
		{ after(grammarAccess.getClauseAccess().getFactAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getClauseAccess().getRuleAssignment_1()); }
		(rule__Clause__RuleAssignment_1)
		{ after(grammarAccess.getClauseAccess().getRuleAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Term__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTermAccess().getAtomAssignment_0()); }
		(rule__Term__AtomAssignment_0)
		{ after(grammarAccess.getTermAccess().getAtomAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getTermAccess().getListAssignment_1()); }
		(rule__Term__ListAssignment_1)
		{ after(grammarAccess.getTermAccess().getListAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomAccess().getIdentAssignment_0()); }
		(rule__Atom__IdentAssignment_0)
		{ after(grammarAccess.getAtomAccess().getIdentAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getAtomAccess().getIdentAssignment_1()); }
		(rule__Atom__IdentAssignment_1)
		{ after(grammarAccess.getAtomAccess().getIdentAssignment_1()); }
	)
	|
	(
		{ before(grammarAccess.getAtomAccess().getIdentAssignment_2()); }
		(rule__Atom__IdentAssignment_2)
		{ after(grammarAccess.getAtomAccess().getIdentAssignment_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__List__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListAccess().getGroup_0()); }
		(rule__List__Group_0__0)
		{ after(grammarAccess.getListAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getListAccess().getNonemptyAssignment_1()); }
		(rule__List__NonemptyAssignment_1)
		{ after(grammarAccess.getListAccess().getNonemptyAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNonEmptyListAccess().getGroup_0()); }
		(rule__NonEmptyList__Group_0__0)
		{ after(grammarAccess.getNonEmptyListAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getNonEmptyListAccess().getGroup_1()); }
		(rule__NonEmptyList__Group_1__0)
		{ after(grammarAccess.getNonEmptyListAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prologdsl__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prologdsl__Group__0__Impl
	rule__Prologdsl__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Prologdsl__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologdslAccess().getProgramAssignment_0()); }
	(rule__Prologdsl__ProgramAssignment_0)
	{ after(grammarAccess.getPrologdslAccess().getProgramAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prologdsl__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prologdsl__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Prologdsl__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologdslAccess().getExqueryAssignment_1()); }
	(rule__Prologdsl__ExqueryAssignment_1)
	{ after(grammarAccess.getPrologdslAccess().getExqueryAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exquery__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exquery__Group__0__Impl
	rule__Exquery__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exquery__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExqueryAccess().getQuestionMarkHyphenMinusKeyword_0()); }
	'?-'
	{ after(grammarAccess.getExqueryAccess().getQuestionMarkHyphenMinusKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exquery__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exquery__Group__1__Impl
	rule__Exquery__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Exquery__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExqueryAccess().getQueryAssignment_1()); }
	(rule__Exquery__QueryAssignment_1)
	{ after(grammarAccess.getExqueryAccess().getQueryAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exquery__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exquery__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exquery__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExqueryAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getExqueryAccess().getFullStopKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Query__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group__0__Impl
	rule__Query__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getPAssignment_0()); }
	(rule__Query__PAssignment_0)
	{ after(grammarAccess.getQueryAccess().getPAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getGroup_1()); }
	(rule__Query__Group_1__0)*
	{ after(grammarAccess.getQueryAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Query__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__0__Impl
	rule__Query__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getCommaKeyword_1_0()); }
	','
	{ after(grammarAccess.getQueryAccess().getCommaKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getPAssignment_1_1()); }
	(rule__Query__PAssignment_1_1)
	{ after(grammarAccess.getQueryAccess().getPAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Fact__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fact__Group__0__Impl
	rule__Fact__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Fact__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFactAccess().getPredicateAssignment_0()); }
	(rule__Fact__PredicateAssignment_0)
	{ after(grammarAccess.getFactAccess().getPredicateAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fact__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fact__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Fact__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFactAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getFactAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Rule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__0__Impl
	rule__Rule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getRuleAssignment_0()); }
	(rule__Rule__RuleAssignment_0)
	{ after(grammarAccess.getRuleAccess().getRuleAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__1__Impl
	rule__Rule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getColonHyphenMinusKeyword_1()); }
	':-'
	{ after(grammarAccess.getRuleAccess().getColonHyphenMinusKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__2__Impl
	rule__Rule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getQueryAssignment_2()); }
	(rule__Rule__QueryAssignment_2)
	{ after(grammarAccess.getRuleAccess().getQueryAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getRuleAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Predicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__0__Impl
	rule__Predicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getFunctorAssignment_0()); }
	(rule__Predicate__FunctorAssignment_0)
	{ after(grammarAccess.getPredicateAccess().getFunctorAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__1__Impl
	rule__Predicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__2__Impl
	rule__Predicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getTermAssignment_2()); }
	(rule__Predicate__TermAssignment_2)
	{ after(grammarAccess.getPredicateAccess().getTermAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__3__Impl
	rule__Predicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getGroup_3()); }
	(rule__Predicate__Group_3__0)*
	{ after(grammarAccess.getPredicateAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Predicate__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group_3__0__Impl
	rule__Predicate__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getCommaKeyword_3_0()); }
	','
	{ after(grammarAccess.getPredicateAccess().getCommaKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Predicate__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicateAccess().getTermAssignment_3_1()); }
	(rule__Predicate__TermAssignment_3_1)
	{ after(grammarAccess.getPredicateAccess().getTermAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__List__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__List__Group_0__0__Impl
	rule__List__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__List__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListAccess().getListAction_0_0()); }
	()
	{ after(grammarAccess.getListAccess().getListAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__List__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__List__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__List__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListAccess().getLeftSquareBracketRightSquareBracketKeyword_0_1()); }
	'[]'
	{ after(grammarAccess.getListAccess().getLeftSquareBracketRightSquareBracketKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NonEmptyList__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_0__0__Impl
	rule__NonEmptyList__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_0_0()); }
	'['
	{ after(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_0__1__Impl
	rule__NonEmptyList__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getFolgeAssignment_0_1()); }
	(rule__NonEmptyList__FolgeAssignment_0_1)
	{ after(grammarAccess.getNonEmptyListAccess().getFolgeAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_0_2()); }
	']'
	{ after(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NonEmptyList__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_1__0__Impl
	rule__NonEmptyList__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_1_0()); }
	'['
	{ after(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_1__1__Impl
	rule__NonEmptyList__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getGroup_1_1()); }
	(rule__NonEmptyList__Group_1_1__0)
	{ after(grammarAccess.getNonEmptyListAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_1_2()); }
	']'
	{ after(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NonEmptyList__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_1_1__0__Impl
	rule__NonEmptyList__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getAtomAssignment_1_1_0()); }
	(rule__NonEmptyList__AtomAssignment_1_1_0)
	{ after(grammarAccess.getNonEmptyListAccess().getAtomAssignment_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_1_1__1__Impl
	rule__NonEmptyList__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getVerticalLineKeyword_1_1_1()); }
	'|'
	{ after(grammarAccess.getNonEmptyListAccess().getVerticalLineKeyword_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NonEmptyList__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNonEmptyListAccess().getTermAssignment_1_1_2()); }
	(rule__NonEmptyList__TermAssignment_1_1_2)
	{ after(grammarAccess.getNonEmptyListAccess().getTermAssignment_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Folge__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Folge__Group__0__Impl
	rule__Folge__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFolgeAccess().getAtomAssignment_0()); }
	(rule__Folge__AtomAssignment_0)
	{ after(grammarAccess.getFolgeAccess().getAtomAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Folge__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFolgeAccess().getGroup_1()); }
	(rule__Folge__Group_1__0)*
	{ after(grammarAccess.getFolgeAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Folge__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Folge__Group_1__0__Impl
	rule__Folge__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFolgeAccess().getCommaKeyword_1_0()); }
	','
	{ after(grammarAccess.getFolgeAccess().getCommaKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Folge__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFolgeAccess().getAtomAssignment_1_1()); }
	(rule__Folge__AtomAssignment_1_1)
	{ after(grammarAccess.getFolgeAccess().getAtomAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Model__ExpressionsAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModelAccess().getExpressionsPrologdslParserRuleCall_0()); }
		rulePrologdsl
		{ after(grammarAccess.getModelAccess().getExpressionsPrologdslParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prologdsl__ProgramAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrologdslAccess().getProgramProgramParserRuleCall_0_0()); }
		ruleProgram
		{ after(grammarAccess.getPrologdslAccess().getProgramProgramParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prologdsl__ExqueryAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrologdslAccess().getExqueryExqueryParserRuleCall_1_0()); }
		ruleExquery
		{ after(grammarAccess.getPrologdslAccess().getExqueryExqueryParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Program__ClausesAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getProgramAccess().getClausesClauseParserRuleCall_0()); }
		ruleClause
		{ after(grammarAccess.getProgramAccess().getClausesClauseParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exquery__QueryAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExqueryAccess().getQueryQueryParserRuleCall_1_0()); }
		ruleQuery
		{ after(grammarAccess.getExqueryAccess().getQueryQueryParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__PAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_0_0()); }
		rulePredicate
		{ after(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__PAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_1_1_0()); }
		rulePredicate
		{ after(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Clause__FactAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClauseAccess().getFactFactParserRuleCall_0_0()); }
		ruleFact
		{ after(grammarAccess.getClauseAccess().getFactFactParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Clause__RuleAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClauseAccess().getRuleRuleParserRuleCall_1_0()); }
		ruleRule
		{ after(grammarAccess.getClauseAccess().getRuleRuleParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fact__PredicateAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFactAccess().getPredicatePredicateParserRuleCall_0_0()); }
		rulePredicate
		{ after(grammarAccess.getFactAccess().getPredicatePredicateParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__RuleAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getRulePredicateParserRuleCall_0_0()); }
		rulePredicate
		{ after(grammarAccess.getRuleAccess().getRulePredicateParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__QueryAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getQueryQueryParserRuleCall_2_0()); }
		ruleQuery
		{ after(grammarAccess.getRuleAccess().getQueryQueryParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__FunctorAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getFunctorFunctorParserRuleCall_0_0()); }
		ruleFunctor
		{ after(grammarAccess.getPredicateAccess().getFunctorFunctorParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__TermAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_2_0()); }
		ruleTerm
		{ after(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__TermAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_3_1_0()); }
		ruleTerm
		{ after(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Functor__FuncNameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctorAccess().getFuncNameIDENTTerminalRuleCall_0()); }
		RULE_IDENT
		{ after(grammarAccess.getFunctorAccess().getFuncNameIDENTTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Term__AtomAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTermAccess().getAtomAtomParserRuleCall_0_0()); }
		ruleAtom
		{ after(grammarAccess.getTermAccess().getAtomAtomParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Term__ListAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTermAccess().getListListParserRuleCall_1_0()); }
		ruleList
		{ after(grammarAccess.getTermAccess().getListListParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atom__IdentAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomAccess().getIdentIDENTTerminalRuleCall_0_0()); }
		RULE_IDENT
		{ after(grammarAccess.getAtomAccess().getIdentIDENTTerminalRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atom__IdentAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomAccess().getIdentNUMBERTerminalRuleCall_1_0()); }
		RULE_NUMBER
		{ after(grammarAccess.getAtomAccess().getIdentNUMBERTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atom__IdentAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomAccess().getIdentVARIABLETerminalRuleCall_2_0()); }
		RULE_VARIABLE
		{ after(grammarAccess.getAtomAccess().getIdentVARIABLETerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__List__NonemptyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListAccess().getNonemptyNonEmptyListParserRuleCall_1_0()); }
		ruleNonEmptyList
		{ after(grammarAccess.getListAccess().getNonemptyNonEmptyListParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__FolgeAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNonEmptyListAccess().getFolgeFolgeParserRuleCall_0_1_0()); }
		ruleFolge
		{ after(grammarAccess.getNonEmptyListAccess().getFolgeFolgeParserRuleCall_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__AtomAssignment_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNonEmptyListAccess().getAtomAtomParserRuleCall_1_1_0_0()); }
		ruleAtom
		{ after(grammarAccess.getNonEmptyListAccess().getAtomAtomParserRuleCall_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NonEmptyList__TermAssignment_1_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNonEmptyListAccess().getTermTermParserRuleCall_1_1_2_0()); }
		ruleTerm
		{ after(grammarAccess.getNonEmptyListAccess().getTermTermParserRuleCall_1_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__AtomAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_0_0()); }
		ruleAtom
		{ after(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Folge__AtomAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_1_1_0()); }
		ruleAtom
		{ after(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_IDENT : 'a'..'z' ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_VARIABLE : 'A'..'Z';

RULE_NUMBER : RULE_INT;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

fragment RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
