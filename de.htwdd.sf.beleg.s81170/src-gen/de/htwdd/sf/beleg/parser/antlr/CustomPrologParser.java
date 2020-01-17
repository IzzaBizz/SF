/*
 * generated by Xtext 2.12.0
 */
package de.htwdd.sf.beleg.parser.antlr;

import com.google.inject.Inject;
import de.htwdd.sf.beleg.parser.antlr.internal.InternalCustomPrologParser;
import de.htwdd.sf.beleg.services.CustomPrologGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class CustomPrologParser extends AbstractAntlrParser {

	@Inject
	private CustomPrologGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalCustomPrologParser createParser(XtextTokenStream stream) {
		return new InternalCustomPrologParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public CustomPrologGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CustomPrologGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
