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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalCustomPrologParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_NUMBER", "RULE_VARIABLE", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?-'", "'.'", "','", "':-'", "'('", "')'", "'[]'", "'['", "']'", "'|'"
    };
    public static final int RULE_STRING=9;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=8;
    public static final int RULE_WS=12;
    public static final int RULE_IDENT=4;
    public static final int RULE_VARIABLE=6;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_NUMBER=5;
    public static final int RULE_INT=7;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalCustomPrologParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCustomPrologParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCustomPrologParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCustomProlog.g"; }


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



    // $ANTLR start "entryRuleModel"
    // InternalCustomProlog.g:54:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalCustomProlog.g:55:1: ( ruleModel EOF )
            // InternalCustomProlog.g:56:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalCustomProlog.g:63:1: ruleModel : ( ( rule__Model__ExpressionsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:67:2: ( ( ( rule__Model__ExpressionsAssignment )* ) )
            // InternalCustomProlog.g:68:2: ( ( rule__Model__ExpressionsAssignment )* )
            {
            // InternalCustomProlog.g:68:2: ( ( rule__Model__ExpressionsAssignment )* )
            // InternalCustomProlog.g:69:3: ( rule__Model__ExpressionsAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getExpressionsAssignment()); 
            }
            // InternalCustomProlog.g:70:3: ( rule__Model__ExpressionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_IDENT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCustomProlog.g:70:4: rule__Model__ExpressionsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ExpressionsAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getExpressionsAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePrologdsl"
    // InternalCustomProlog.g:79:1: entryRulePrologdsl : rulePrologdsl EOF ;
    public final void entryRulePrologdsl() throws RecognitionException {
        try {
            // InternalCustomProlog.g:80:1: ( rulePrologdsl EOF )
            // InternalCustomProlog.g:81:1: rulePrologdsl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrologdslRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrologdsl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrologdslRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrologdsl"


    // $ANTLR start "rulePrologdsl"
    // InternalCustomProlog.g:88:1: rulePrologdsl : ( ( rule__Prologdsl__Group__0 ) ) ;
    public final void rulePrologdsl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:92:2: ( ( ( rule__Prologdsl__Group__0 ) ) )
            // InternalCustomProlog.g:93:2: ( ( rule__Prologdsl__Group__0 ) )
            {
            // InternalCustomProlog.g:93:2: ( ( rule__Prologdsl__Group__0 ) )
            // InternalCustomProlog.g:94:3: ( rule__Prologdsl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrologdslAccess().getGroup()); 
            }
            // InternalCustomProlog.g:95:3: ( rule__Prologdsl__Group__0 )
            // InternalCustomProlog.g:95:4: rule__Prologdsl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Prologdsl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrologdslAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrologdsl"


    // $ANTLR start "entryRuleProgram"
    // InternalCustomProlog.g:104:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // InternalCustomProlog.g:105:1: ( ruleProgram EOF )
            // InternalCustomProlog.g:106:1: ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleProgram();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalCustomProlog.g:113:1: ruleProgram : ( ( ( rule__Program__ClausesAssignment ) ) ( ( rule__Program__ClausesAssignment )* ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:117:2: ( ( ( ( rule__Program__ClausesAssignment ) ) ( ( rule__Program__ClausesAssignment )* ) ) )
            // InternalCustomProlog.g:118:2: ( ( ( rule__Program__ClausesAssignment ) ) ( ( rule__Program__ClausesAssignment )* ) )
            {
            // InternalCustomProlog.g:118:2: ( ( ( rule__Program__ClausesAssignment ) ) ( ( rule__Program__ClausesAssignment )* ) )
            // InternalCustomProlog.g:119:3: ( ( rule__Program__ClausesAssignment ) ) ( ( rule__Program__ClausesAssignment )* )
            {
            // InternalCustomProlog.g:119:3: ( ( rule__Program__ClausesAssignment ) )
            // InternalCustomProlog.g:120:4: ( rule__Program__ClausesAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClausesAssignment()); 
            }
            // InternalCustomProlog.g:121:4: ( rule__Program__ClausesAssignment )
            // InternalCustomProlog.g:121:5: rule__Program__ClausesAssignment
            {
            pushFollow(FOLLOW_4);
            rule__Program__ClausesAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClausesAssignment()); 
            }

            }

            // InternalCustomProlog.g:124:3: ( ( rule__Program__ClausesAssignment )* )
            // InternalCustomProlog.g:125:4: ( rule__Program__ClausesAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClausesAssignment()); 
            }
            // InternalCustomProlog.g:126:4: ( rule__Program__ClausesAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_IDENT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCustomProlog.g:126:5: rule__Program__ClausesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Program__ClausesAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClausesAssignment()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleExquery"
    // InternalCustomProlog.g:136:1: entryRuleExquery : ruleExquery EOF ;
    public final void entryRuleExquery() throws RecognitionException {
        try {
            // InternalCustomProlog.g:137:1: ( ruleExquery EOF )
            // InternalCustomProlog.g:138:1: ruleExquery EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExqueryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExquery();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExqueryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExquery"


    // $ANTLR start "ruleExquery"
    // InternalCustomProlog.g:145:1: ruleExquery : ( ( rule__Exquery__Group__0 ) ) ;
    public final void ruleExquery() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:149:2: ( ( ( rule__Exquery__Group__0 ) ) )
            // InternalCustomProlog.g:150:2: ( ( rule__Exquery__Group__0 ) )
            {
            // InternalCustomProlog.g:150:2: ( ( rule__Exquery__Group__0 ) )
            // InternalCustomProlog.g:151:3: ( rule__Exquery__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExqueryAccess().getGroup()); 
            }
            // InternalCustomProlog.g:152:3: ( rule__Exquery__Group__0 )
            // InternalCustomProlog.g:152:4: rule__Exquery__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Exquery__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExqueryAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExquery"


    // $ANTLR start "entryRuleQuery"
    // InternalCustomProlog.g:161:1: entryRuleQuery : ruleQuery EOF ;
    public final void entryRuleQuery() throws RecognitionException {
        try {
            // InternalCustomProlog.g:162:1: ( ruleQuery EOF )
            // InternalCustomProlog.g:163:1: ruleQuery EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQuery();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // InternalCustomProlog.g:170:1: ruleQuery : ( ( rule__Query__Group__0 ) ) ;
    public final void ruleQuery() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:174:2: ( ( ( rule__Query__Group__0 ) ) )
            // InternalCustomProlog.g:175:2: ( ( rule__Query__Group__0 ) )
            {
            // InternalCustomProlog.g:175:2: ( ( rule__Query__Group__0 ) )
            // InternalCustomProlog.g:176:3: ( rule__Query__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getGroup()); 
            }
            // InternalCustomProlog.g:177:3: ( rule__Query__Group__0 )
            // InternalCustomProlog.g:177:4: rule__Query__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Query__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleClause"
    // InternalCustomProlog.g:186:1: entryRuleClause : ruleClause EOF ;
    public final void entryRuleClause() throws RecognitionException {
        try {
            // InternalCustomProlog.g:187:1: ( ruleClause EOF )
            // InternalCustomProlog.g:188:1: ruleClause EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClause();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClauseRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClause"


    // $ANTLR start "ruleClause"
    // InternalCustomProlog.g:195:1: ruleClause : ( ( rule__Clause__Alternatives ) ) ;
    public final void ruleClause() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:199:2: ( ( ( rule__Clause__Alternatives ) ) )
            // InternalCustomProlog.g:200:2: ( ( rule__Clause__Alternatives ) )
            {
            // InternalCustomProlog.g:200:2: ( ( rule__Clause__Alternatives ) )
            // InternalCustomProlog.g:201:3: ( rule__Clause__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClauseAccess().getAlternatives()); 
            }
            // InternalCustomProlog.g:202:3: ( rule__Clause__Alternatives )
            // InternalCustomProlog.g:202:4: rule__Clause__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Clause__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClauseAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClause"


    // $ANTLR start "entryRuleFact"
    // InternalCustomProlog.g:211:1: entryRuleFact : ruleFact EOF ;
    public final void entryRuleFact() throws RecognitionException {
        try {
            // InternalCustomProlog.g:212:1: ( ruleFact EOF )
            // InternalCustomProlog.g:213:1: ruleFact EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFact();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFactRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFact"


    // $ANTLR start "ruleFact"
    // InternalCustomProlog.g:220:1: ruleFact : ( ( rule__Fact__Group__0 ) ) ;
    public final void ruleFact() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:224:2: ( ( ( rule__Fact__Group__0 ) ) )
            // InternalCustomProlog.g:225:2: ( ( rule__Fact__Group__0 ) )
            {
            // InternalCustomProlog.g:225:2: ( ( rule__Fact__Group__0 ) )
            // InternalCustomProlog.g:226:3: ( rule__Fact__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactAccess().getGroup()); 
            }
            // InternalCustomProlog.g:227:3: ( rule__Fact__Group__0 )
            // InternalCustomProlog.g:227:4: rule__Fact__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Fact__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFactAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFact"


    // $ANTLR start "entryRuleRule"
    // InternalCustomProlog.g:236:1: entryRuleRule : ruleRule EOF ;
    public final void entryRuleRule() throws RecognitionException {
        try {
            // InternalCustomProlog.g:237:1: ( ruleRule EOF )
            // InternalCustomProlog.g:238:1: ruleRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalCustomProlog.g:245:1: ruleRule : ( ( rule__Rule__Group__0 ) ) ;
    public final void ruleRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:249:2: ( ( ( rule__Rule__Group__0 ) ) )
            // InternalCustomProlog.g:250:2: ( ( rule__Rule__Group__0 ) )
            {
            // InternalCustomProlog.g:250:2: ( ( rule__Rule__Group__0 ) )
            // InternalCustomProlog.g:251:3: ( rule__Rule__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getGroup()); 
            }
            // InternalCustomProlog.g:252:3: ( rule__Rule__Group__0 )
            // InternalCustomProlog.g:252:4: rule__Rule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRulePredicate"
    // InternalCustomProlog.g:261:1: entryRulePredicate : rulePredicate EOF ;
    public final void entryRulePredicate() throws RecognitionException {
        try {
            // InternalCustomProlog.g:262:1: ( rulePredicate EOF )
            // InternalCustomProlog.g:263:1: rulePredicate EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalCustomProlog.g:270:1: rulePredicate : ( ( rule__Predicate__Group__0 ) ) ;
    public final void rulePredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:274:2: ( ( ( rule__Predicate__Group__0 ) ) )
            // InternalCustomProlog.g:275:2: ( ( rule__Predicate__Group__0 ) )
            {
            // InternalCustomProlog.g:275:2: ( ( rule__Predicate__Group__0 ) )
            // InternalCustomProlog.g:276:3: ( rule__Predicate__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getGroup()); 
            }
            // InternalCustomProlog.g:277:3: ( rule__Predicate__Group__0 )
            // InternalCustomProlog.g:277:4: rule__Predicate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleFunctor"
    // InternalCustomProlog.g:286:1: entryRuleFunctor : ruleFunctor EOF ;
    public final void entryRuleFunctor() throws RecognitionException {
        try {
            // InternalCustomProlog.g:287:1: ( ruleFunctor EOF )
            // InternalCustomProlog.g:288:1: ruleFunctor EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctorRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFunctor();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctorRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunctor"


    // $ANTLR start "ruleFunctor"
    // InternalCustomProlog.g:295:1: ruleFunctor : ( ( rule__Functor__FuncNameAssignment ) ) ;
    public final void ruleFunctor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:299:2: ( ( ( rule__Functor__FuncNameAssignment ) ) )
            // InternalCustomProlog.g:300:2: ( ( rule__Functor__FuncNameAssignment ) )
            {
            // InternalCustomProlog.g:300:2: ( ( rule__Functor__FuncNameAssignment ) )
            // InternalCustomProlog.g:301:3: ( rule__Functor__FuncNameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctorAccess().getFuncNameAssignment()); 
            }
            // InternalCustomProlog.g:302:3: ( rule__Functor__FuncNameAssignment )
            // InternalCustomProlog.g:302:4: rule__Functor__FuncNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Functor__FuncNameAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctorAccess().getFuncNameAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctor"


    // $ANTLR start "entryRuleTerm"
    // InternalCustomProlog.g:311:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalCustomProlog.g:312:1: ( ruleTerm EOF )
            // InternalCustomProlog.g:313:1: ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalCustomProlog.g:320:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:324:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalCustomProlog.g:325:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalCustomProlog.g:325:2: ( ( rule__Term__Alternatives ) )
            // InternalCustomProlog.g:326:3: ( rule__Term__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getAlternatives()); 
            }
            // InternalCustomProlog.g:327:3: ( rule__Term__Alternatives )
            // InternalCustomProlog.g:327:4: rule__Term__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Term__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // InternalCustomProlog.g:336:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalCustomProlog.g:337:1: ( ruleAtom EOF )
            // InternalCustomProlog.g:338:1: ruleAtom EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalCustomProlog.g:345:1: ruleAtom : ( ( rule__Atom__Alternatives ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:349:2: ( ( ( rule__Atom__Alternatives ) ) )
            // InternalCustomProlog.g:350:2: ( ( rule__Atom__Alternatives ) )
            {
            // InternalCustomProlog.g:350:2: ( ( rule__Atom__Alternatives ) )
            // InternalCustomProlog.g:351:3: ( rule__Atom__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomAccess().getAlternatives()); 
            }
            // InternalCustomProlog.g:352:3: ( rule__Atom__Alternatives )
            // InternalCustomProlog.g:352:4: rule__Atom__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleList"
    // InternalCustomProlog.g:361:1: entryRuleList : ruleList EOF ;
    public final void entryRuleList() throws RecognitionException {
        try {
            // InternalCustomProlog.g:362:1: ( ruleList EOF )
            // InternalCustomProlog.g:363:1: ruleList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleList"


    // $ANTLR start "ruleList"
    // InternalCustomProlog.g:370:1: ruleList : ( ( rule__List__Alternatives ) ) ;
    public final void ruleList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:374:2: ( ( ( rule__List__Alternatives ) ) )
            // InternalCustomProlog.g:375:2: ( ( rule__List__Alternatives ) )
            {
            // InternalCustomProlog.g:375:2: ( ( rule__List__Alternatives ) )
            // InternalCustomProlog.g:376:3: ( rule__List__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListAccess().getAlternatives()); 
            }
            // InternalCustomProlog.g:377:3: ( rule__List__Alternatives )
            // InternalCustomProlog.g:377:4: rule__List__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__List__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleList"


    // $ANTLR start "entryRuleNonEmptyList"
    // InternalCustomProlog.g:386:1: entryRuleNonEmptyList : ruleNonEmptyList EOF ;
    public final void entryRuleNonEmptyList() throws RecognitionException {
        try {
            // InternalCustomProlog.g:387:1: ( ruleNonEmptyList EOF )
            // InternalCustomProlog.g:388:1: ruleNonEmptyList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNonEmptyList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNonEmptyList"


    // $ANTLR start "ruleNonEmptyList"
    // InternalCustomProlog.g:395:1: ruleNonEmptyList : ( ( rule__NonEmptyList__Alternatives ) ) ;
    public final void ruleNonEmptyList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:399:2: ( ( ( rule__NonEmptyList__Alternatives ) ) )
            // InternalCustomProlog.g:400:2: ( ( rule__NonEmptyList__Alternatives ) )
            {
            // InternalCustomProlog.g:400:2: ( ( rule__NonEmptyList__Alternatives ) )
            // InternalCustomProlog.g:401:3: ( rule__NonEmptyList__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getAlternatives()); 
            }
            // InternalCustomProlog.g:402:3: ( rule__NonEmptyList__Alternatives )
            // InternalCustomProlog.g:402:4: rule__NonEmptyList__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNonEmptyList"


    // $ANTLR start "entryRuleFolge"
    // InternalCustomProlog.g:411:1: entryRuleFolge : ruleFolge EOF ;
    public final void entryRuleFolge() throws RecognitionException {
        try {
            // InternalCustomProlog.g:412:1: ( ruleFolge EOF )
            // InternalCustomProlog.g:413:1: ruleFolge EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFolge();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFolge"


    // $ANTLR start "ruleFolge"
    // InternalCustomProlog.g:420:1: ruleFolge : ( ( rule__Folge__Group__0 ) ) ;
    public final void ruleFolge() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:424:2: ( ( ( rule__Folge__Group__0 ) ) )
            // InternalCustomProlog.g:425:2: ( ( rule__Folge__Group__0 ) )
            {
            // InternalCustomProlog.g:425:2: ( ( rule__Folge__Group__0 ) )
            // InternalCustomProlog.g:426:3: ( rule__Folge__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getGroup()); 
            }
            // InternalCustomProlog.g:427:3: ( rule__Folge__Group__0 )
            // InternalCustomProlog.g:427:4: rule__Folge__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Folge__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFolge"


    // $ANTLR start "rule__Clause__Alternatives"
    // InternalCustomProlog.g:435:1: rule__Clause__Alternatives : ( ( ( rule__Clause__FactAssignment_0 ) ) | ( ( rule__Clause__RuleAssignment_1 ) ) );
    public final void rule__Clause__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:439:1: ( ( ( rule__Clause__FactAssignment_0 ) ) | ( ( rule__Clause__RuleAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_IDENT) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred3_InternalCustomProlog()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalCustomProlog.g:440:2: ( ( rule__Clause__FactAssignment_0 ) )
                    {
                    // InternalCustomProlog.g:440:2: ( ( rule__Clause__FactAssignment_0 ) )
                    // InternalCustomProlog.g:441:3: ( rule__Clause__FactAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClauseAccess().getFactAssignment_0()); 
                    }
                    // InternalCustomProlog.g:442:3: ( rule__Clause__FactAssignment_0 )
                    // InternalCustomProlog.g:442:4: rule__Clause__FactAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clause__FactAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClauseAccess().getFactAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:446:2: ( ( rule__Clause__RuleAssignment_1 ) )
                    {
                    // InternalCustomProlog.g:446:2: ( ( rule__Clause__RuleAssignment_1 ) )
                    // InternalCustomProlog.g:447:3: ( rule__Clause__RuleAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClauseAccess().getRuleAssignment_1()); 
                    }
                    // InternalCustomProlog.g:448:3: ( rule__Clause__RuleAssignment_1 )
                    // InternalCustomProlog.g:448:4: rule__Clause__RuleAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clause__RuleAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClauseAccess().getRuleAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clause__Alternatives"


    // $ANTLR start "rule__Term__Alternatives"
    // InternalCustomProlog.g:456:1: rule__Term__Alternatives : ( ( ( rule__Term__AtomAssignment_0 ) ) | ( ( rule__Term__ListAssignment_1 ) ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:460:1: ( ( ( rule__Term__AtomAssignment_0 ) ) | ( ( rule__Term__ListAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_IDENT && LA4_0<=RULE_VARIABLE)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=20 && LA4_0<=21)) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalCustomProlog.g:461:2: ( ( rule__Term__AtomAssignment_0 ) )
                    {
                    // InternalCustomProlog.g:461:2: ( ( rule__Term__AtomAssignment_0 ) )
                    // InternalCustomProlog.g:462:3: ( rule__Term__AtomAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTermAccess().getAtomAssignment_0()); 
                    }
                    // InternalCustomProlog.g:463:3: ( rule__Term__AtomAssignment_0 )
                    // InternalCustomProlog.g:463:4: rule__Term__AtomAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Term__AtomAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTermAccess().getAtomAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:467:2: ( ( rule__Term__ListAssignment_1 ) )
                    {
                    // InternalCustomProlog.g:467:2: ( ( rule__Term__ListAssignment_1 ) )
                    // InternalCustomProlog.g:468:3: ( rule__Term__ListAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTermAccess().getListAssignment_1()); 
                    }
                    // InternalCustomProlog.g:469:3: ( rule__Term__ListAssignment_1 )
                    // InternalCustomProlog.g:469:4: rule__Term__ListAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Term__ListAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTermAccess().getListAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Alternatives"


    // $ANTLR start "rule__Atom__Alternatives"
    // InternalCustomProlog.g:477:1: rule__Atom__Alternatives : ( ( ( rule__Atom__IdentAssignment_0 ) ) | ( ( rule__Atom__IdentAssignment_1 ) ) | ( ( rule__Atom__IdentAssignment_2 ) ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:481:1: ( ( ( rule__Atom__IdentAssignment_0 ) ) | ( ( rule__Atom__IdentAssignment_1 ) ) | ( ( rule__Atom__IdentAssignment_2 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_IDENT:
                {
                alt5=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt5=2;
                }
                break;
            case RULE_VARIABLE:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalCustomProlog.g:482:2: ( ( rule__Atom__IdentAssignment_0 ) )
                    {
                    // InternalCustomProlog.g:482:2: ( ( rule__Atom__IdentAssignment_0 ) )
                    // InternalCustomProlog.g:483:3: ( rule__Atom__IdentAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getIdentAssignment_0()); 
                    }
                    // InternalCustomProlog.g:484:3: ( rule__Atom__IdentAssignment_0 )
                    // InternalCustomProlog.g:484:4: rule__Atom__IdentAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__IdentAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getIdentAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:488:2: ( ( rule__Atom__IdentAssignment_1 ) )
                    {
                    // InternalCustomProlog.g:488:2: ( ( rule__Atom__IdentAssignment_1 ) )
                    // InternalCustomProlog.g:489:3: ( rule__Atom__IdentAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getIdentAssignment_1()); 
                    }
                    // InternalCustomProlog.g:490:3: ( rule__Atom__IdentAssignment_1 )
                    // InternalCustomProlog.g:490:4: rule__Atom__IdentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__IdentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getIdentAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCustomProlog.g:494:2: ( ( rule__Atom__IdentAssignment_2 ) )
                    {
                    // InternalCustomProlog.g:494:2: ( ( rule__Atom__IdentAssignment_2 ) )
                    // InternalCustomProlog.g:495:3: ( rule__Atom__IdentAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomAccess().getIdentAssignment_2()); 
                    }
                    // InternalCustomProlog.g:496:3: ( rule__Atom__IdentAssignment_2 )
                    // InternalCustomProlog.g:496:4: rule__Atom__IdentAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__IdentAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomAccess().getIdentAssignment_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Alternatives"


    // $ANTLR start "rule__List__Alternatives"
    // InternalCustomProlog.g:504:1: rule__List__Alternatives : ( ( ( rule__List__Group_0__0 ) ) | ( ( rule__List__NonemptyAssignment_1 ) ) );
    public final void rule__List__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:508:1: ( ( ( rule__List__Group_0__0 ) ) | ( ( rule__List__NonemptyAssignment_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalCustomProlog.g:509:2: ( ( rule__List__Group_0__0 ) )
                    {
                    // InternalCustomProlog.g:509:2: ( ( rule__List__Group_0__0 ) )
                    // InternalCustomProlog.g:510:3: ( rule__List__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getListAccess().getGroup_0()); 
                    }
                    // InternalCustomProlog.g:511:3: ( rule__List__Group_0__0 )
                    // InternalCustomProlog.g:511:4: rule__List__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__List__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getListAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:515:2: ( ( rule__List__NonemptyAssignment_1 ) )
                    {
                    // InternalCustomProlog.g:515:2: ( ( rule__List__NonemptyAssignment_1 ) )
                    // InternalCustomProlog.g:516:3: ( rule__List__NonemptyAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getListAccess().getNonemptyAssignment_1()); 
                    }
                    // InternalCustomProlog.g:517:3: ( rule__List__NonemptyAssignment_1 )
                    // InternalCustomProlog.g:517:4: rule__List__NonemptyAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__List__NonemptyAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getListAccess().getNonemptyAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__List__Alternatives"


    // $ANTLR start "rule__NonEmptyList__Alternatives"
    // InternalCustomProlog.g:525:1: rule__NonEmptyList__Alternatives : ( ( ( rule__NonEmptyList__Group_0__0 ) ) | ( ( rule__NonEmptyList__Group_1__0 ) ) );
    public final void rule__NonEmptyList__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:529:1: ( ( ( rule__NonEmptyList__Group_0__0 ) ) | ( ( rule__NonEmptyList__Group_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                switch ( input.LA(2) ) {
                case RULE_IDENT:
                    {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==23) ) {
                        alt7=2;
                    }
                    else if ( (LA7_2==16||LA7_2==22) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_NUMBER:
                    {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==23) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==16||LA7_3==22) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_VARIABLE:
                    {
                    int LA7_4 = input.LA(3);

                    if ( (LA7_4==23) ) {
                        alt7=2;
                    }
                    else if ( (LA7_4==16||LA7_4==22) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalCustomProlog.g:530:2: ( ( rule__NonEmptyList__Group_0__0 ) )
                    {
                    // InternalCustomProlog.g:530:2: ( ( rule__NonEmptyList__Group_0__0 ) )
                    // InternalCustomProlog.g:531:3: ( rule__NonEmptyList__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonEmptyListAccess().getGroup_0()); 
                    }
                    // InternalCustomProlog.g:532:3: ( rule__NonEmptyList__Group_0__0 )
                    // InternalCustomProlog.g:532:4: rule__NonEmptyList__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonEmptyList__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonEmptyListAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:536:2: ( ( rule__NonEmptyList__Group_1__0 ) )
                    {
                    // InternalCustomProlog.g:536:2: ( ( rule__NonEmptyList__Group_1__0 ) )
                    // InternalCustomProlog.g:537:3: ( rule__NonEmptyList__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonEmptyListAccess().getGroup_1()); 
                    }
                    // InternalCustomProlog.g:538:3: ( rule__NonEmptyList__Group_1__0 )
                    // InternalCustomProlog.g:538:4: rule__NonEmptyList__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonEmptyList__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonEmptyListAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Alternatives"


    // $ANTLR start "rule__Prologdsl__Group__0"
    // InternalCustomProlog.g:546:1: rule__Prologdsl__Group__0 : rule__Prologdsl__Group__0__Impl rule__Prologdsl__Group__1 ;
    public final void rule__Prologdsl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:550:1: ( rule__Prologdsl__Group__0__Impl rule__Prologdsl__Group__1 )
            // InternalCustomProlog.g:551:2: rule__Prologdsl__Group__0__Impl rule__Prologdsl__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Prologdsl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Prologdsl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prologdsl__Group__0"


    // $ANTLR start "rule__Prologdsl__Group__0__Impl"
    // InternalCustomProlog.g:558:1: rule__Prologdsl__Group__0__Impl : ( ( rule__Prologdsl__ProgramAssignment_0 ) ) ;
    public final void rule__Prologdsl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:562:1: ( ( ( rule__Prologdsl__ProgramAssignment_0 ) ) )
            // InternalCustomProlog.g:563:1: ( ( rule__Prologdsl__ProgramAssignment_0 ) )
            {
            // InternalCustomProlog.g:563:1: ( ( rule__Prologdsl__ProgramAssignment_0 ) )
            // InternalCustomProlog.g:564:2: ( rule__Prologdsl__ProgramAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrologdslAccess().getProgramAssignment_0()); 
            }
            // InternalCustomProlog.g:565:2: ( rule__Prologdsl__ProgramAssignment_0 )
            // InternalCustomProlog.g:565:3: rule__Prologdsl__ProgramAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Prologdsl__ProgramAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrologdslAccess().getProgramAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prologdsl__Group__0__Impl"


    // $ANTLR start "rule__Prologdsl__Group__1"
    // InternalCustomProlog.g:573:1: rule__Prologdsl__Group__1 : rule__Prologdsl__Group__1__Impl ;
    public final void rule__Prologdsl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:577:1: ( rule__Prologdsl__Group__1__Impl )
            // InternalCustomProlog.g:578:2: rule__Prologdsl__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Prologdsl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prologdsl__Group__1"


    // $ANTLR start "rule__Prologdsl__Group__1__Impl"
    // InternalCustomProlog.g:584:1: rule__Prologdsl__Group__1__Impl : ( ( rule__Prologdsl__ExqueryAssignment_1 ) ) ;
    public final void rule__Prologdsl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:588:1: ( ( ( rule__Prologdsl__ExqueryAssignment_1 ) ) )
            // InternalCustomProlog.g:589:1: ( ( rule__Prologdsl__ExqueryAssignment_1 ) )
            {
            // InternalCustomProlog.g:589:1: ( ( rule__Prologdsl__ExqueryAssignment_1 ) )
            // InternalCustomProlog.g:590:2: ( rule__Prologdsl__ExqueryAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrologdslAccess().getExqueryAssignment_1()); 
            }
            // InternalCustomProlog.g:591:2: ( rule__Prologdsl__ExqueryAssignment_1 )
            // InternalCustomProlog.g:591:3: rule__Prologdsl__ExqueryAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Prologdsl__ExqueryAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrologdslAccess().getExqueryAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prologdsl__Group__1__Impl"


    // $ANTLR start "rule__Exquery__Group__0"
    // InternalCustomProlog.g:600:1: rule__Exquery__Group__0 : rule__Exquery__Group__0__Impl rule__Exquery__Group__1 ;
    public final void rule__Exquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:604:1: ( rule__Exquery__Group__0__Impl rule__Exquery__Group__1 )
            // InternalCustomProlog.g:605:2: rule__Exquery__Group__0__Impl rule__Exquery__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Exquery__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Exquery__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__Group__0"


    // $ANTLR start "rule__Exquery__Group__0__Impl"
    // InternalCustomProlog.g:612:1: rule__Exquery__Group__0__Impl : ( '?-' ) ;
    public final void rule__Exquery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:616:1: ( ( '?-' ) )
            // InternalCustomProlog.g:617:1: ( '?-' )
            {
            // InternalCustomProlog.g:617:1: ( '?-' )
            // InternalCustomProlog.g:618:2: '?-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExqueryAccess().getQuestionMarkHyphenMinusKeyword_0()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExqueryAccess().getQuestionMarkHyphenMinusKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__Group__0__Impl"


    // $ANTLR start "rule__Exquery__Group__1"
    // InternalCustomProlog.g:627:1: rule__Exquery__Group__1 : rule__Exquery__Group__1__Impl rule__Exquery__Group__2 ;
    public final void rule__Exquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:631:1: ( rule__Exquery__Group__1__Impl rule__Exquery__Group__2 )
            // InternalCustomProlog.g:632:2: rule__Exquery__Group__1__Impl rule__Exquery__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Exquery__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Exquery__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__Group__1"


    // $ANTLR start "rule__Exquery__Group__1__Impl"
    // InternalCustomProlog.g:639:1: rule__Exquery__Group__1__Impl : ( ( rule__Exquery__QueryAssignment_1 ) ) ;
    public final void rule__Exquery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:643:1: ( ( ( rule__Exquery__QueryAssignment_1 ) ) )
            // InternalCustomProlog.g:644:1: ( ( rule__Exquery__QueryAssignment_1 ) )
            {
            // InternalCustomProlog.g:644:1: ( ( rule__Exquery__QueryAssignment_1 ) )
            // InternalCustomProlog.g:645:2: ( rule__Exquery__QueryAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExqueryAccess().getQueryAssignment_1()); 
            }
            // InternalCustomProlog.g:646:2: ( rule__Exquery__QueryAssignment_1 )
            // InternalCustomProlog.g:646:3: rule__Exquery__QueryAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Exquery__QueryAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExqueryAccess().getQueryAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__Group__1__Impl"


    // $ANTLR start "rule__Exquery__Group__2"
    // InternalCustomProlog.g:654:1: rule__Exquery__Group__2 : rule__Exquery__Group__2__Impl ;
    public final void rule__Exquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:658:1: ( rule__Exquery__Group__2__Impl )
            // InternalCustomProlog.g:659:2: rule__Exquery__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exquery__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__Group__2"


    // $ANTLR start "rule__Exquery__Group__2__Impl"
    // InternalCustomProlog.g:665:1: rule__Exquery__Group__2__Impl : ( '.' ) ;
    public final void rule__Exquery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:669:1: ( ( '.' ) )
            // InternalCustomProlog.g:670:1: ( '.' )
            {
            // InternalCustomProlog.g:670:1: ( '.' )
            // InternalCustomProlog.g:671:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExqueryAccess().getFullStopKeyword_2()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExqueryAccess().getFullStopKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__Group__2__Impl"


    // $ANTLR start "rule__Query__Group__0"
    // InternalCustomProlog.g:681:1: rule__Query__Group__0 : rule__Query__Group__0__Impl rule__Query__Group__1 ;
    public final void rule__Query__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:685:1: ( rule__Query__Group__0__Impl rule__Query__Group__1 )
            // InternalCustomProlog.g:686:2: rule__Query__Group__0__Impl rule__Query__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Query__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Query__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__0"


    // $ANTLR start "rule__Query__Group__0__Impl"
    // InternalCustomProlog.g:693:1: rule__Query__Group__0__Impl : ( ( rule__Query__PAssignment_0 ) ) ;
    public final void rule__Query__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:697:1: ( ( ( rule__Query__PAssignment_0 ) ) )
            // InternalCustomProlog.g:698:1: ( ( rule__Query__PAssignment_0 ) )
            {
            // InternalCustomProlog.g:698:1: ( ( rule__Query__PAssignment_0 ) )
            // InternalCustomProlog.g:699:2: ( rule__Query__PAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getPAssignment_0()); 
            }
            // InternalCustomProlog.g:700:2: ( rule__Query__PAssignment_0 )
            // InternalCustomProlog.g:700:3: rule__Query__PAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Query__PAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getPAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__0__Impl"


    // $ANTLR start "rule__Query__Group__1"
    // InternalCustomProlog.g:708:1: rule__Query__Group__1 : rule__Query__Group__1__Impl ;
    public final void rule__Query__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:712:1: ( rule__Query__Group__1__Impl )
            // InternalCustomProlog.g:713:2: rule__Query__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Query__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__1"


    // $ANTLR start "rule__Query__Group__1__Impl"
    // InternalCustomProlog.g:719:1: rule__Query__Group__1__Impl : ( ( rule__Query__Group_1__0 )* ) ;
    public final void rule__Query__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:723:1: ( ( ( rule__Query__Group_1__0 )* ) )
            // InternalCustomProlog.g:724:1: ( ( rule__Query__Group_1__0 )* )
            {
            // InternalCustomProlog.g:724:1: ( ( rule__Query__Group_1__0 )* )
            // InternalCustomProlog.g:725:2: ( rule__Query__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getGroup_1()); 
            }
            // InternalCustomProlog.g:726:2: ( rule__Query__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==16) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCustomProlog.g:726:3: rule__Query__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Query__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__1__Impl"


    // $ANTLR start "rule__Query__Group_1__0"
    // InternalCustomProlog.g:735:1: rule__Query__Group_1__0 : rule__Query__Group_1__0__Impl rule__Query__Group_1__1 ;
    public final void rule__Query__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:739:1: ( rule__Query__Group_1__0__Impl rule__Query__Group_1__1 )
            // InternalCustomProlog.g:740:2: rule__Query__Group_1__0__Impl rule__Query__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Query__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Query__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group_1__0"


    // $ANTLR start "rule__Query__Group_1__0__Impl"
    // InternalCustomProlog.g:747:1: rule__Query__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Query__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:751:1: ( ( ',' ) )
            // InternalCustomProlog.g:752:1: ( ',' )
            {
            // InternalCustomProlog.g:752:1: ( ',' )
            // InternalCustomProlog.g:753:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getCommaKeyword_1_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group_1__0__Impl"


    // $ANTLR start "rule__Query__Group_1__1"
    // InternalCustomProlog.g:762:1: rule__Query__Group_1__1 : rule__Query__Group_1__1__Impl ;
    public final void rule__Query__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:766:1: ( rule__Query__Group_1__1__Impl )
            // InternalCustomProlog.g:767:2: rule__Query__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Query__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group_1__1"


    // $ANTLR start "rule__Query__Group_1__1__Impl"
    // InternalCustomProlog.g:773:1: rule__Query__Group_1__1__Impl : ( ( rule__Query__PAssignment_1_1 ) ) ;
    public final void rule__Query__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:777:1: ( ( ( rule__Query__PAssignment_1_1 ) ) )
            // InternalCustomProlog.g:778:1: ( ( rule__Query__PAssignment_1_1 ) )
            {
            // InternalCustomProlog.g:778:1: ( ( rule__Query__PAssignment_1_1 ) )
            // InternalCustomProlog.g:779:2: ( rule__Query__PAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getPAssignment_1_1()); 
            }
            // InternalCustomProlog.g:780:2: ( rule__Query__PAssignment_1_1 )
            // InternalCustomProlog.g:780:3: rule__Query__PAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Query__PAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getPAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group_1__1__Impl"


    // $ANTLR start "rule__Fact__Group__0"
    // InternalCustomProlog.g:789:1: rule__Fact__Group__0 : rule__Fact__Group__0__Impl rule__Fact__Group__1 ;
    public final void rule__Fact__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:793:1: ( rule__Fact__Group__0__Impl rule__Fact__Group__1 )
            // InternalCustomProlog.g:794:2: rule__Fact__Group__0__Impl rule__Fact__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Fact__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Fact__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fact__Group__0"


    // $ANTLR start "rule__Fact__Group__0__Impl"
    // InternalCustomProlog.g:801:1: rule__Fact__Group__0__Impl : ( ( rule__Fact__PredicateAssignment_0 ) ) ;
    public final void rule__Fact__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:805:1: ( ( ( rule__Fact__PredicateAssignment_0 ) ) )
            // InternalCustomProlog.g:806:1: ( ( rule__Fact__PredicateAssignment_0 ) )
            {
            // InternalCustomProlog.g:806:1: ( ( rule__Fact__PredicateAssignment_0 ) )
            // InternalCustomProlog.g:807:2: ( rule__Fact__PredicateAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactAccess().getPredicateAssignment_0()); 
            }
            // InternalCustomProlog.g:808:2: ( rule__Fact__PredicateAssignment_0 )
            // InternalCustomProlog.g:808:3: rule__Fact__PredicateAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Fact__PredicateAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFactAccess().getPredicateAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fact__Group__0__Impl"


    // $ANTLR start "rule__Fact__Group__1"
    // InternalCustomProlog.g:816:1: rule__Fact__Group__1 : rule__Fact__Group__1__Impl ;
    public final void rule__Fact__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:820:1: ( rule__Fact__Group__1__Impl )
            // InternalCustomProlog.g:821:2: rule__Fact__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Fact__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fact__Group__1"


    // $ANTLR start "rule__Fact__Group__1__Impl"
    // InternalCustomProlog.g:827:1: rule__Fact__Group__1__Impl : ( '.' ) ;
    public final void rule__Fact__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:831:1: ( ( '.' ) )
            // InternalCustomProlog.g:832:1: ( '.' )
            {
            // InternalCustomProlog.g:832:1: ( '.' )
            // InternalCustomProlog.g:833:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactAccess().getFullStopKeyword_1()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFactAccess().getFullStopKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fact__Group__1__Impl"


    // $ANTLR start "rule__Rule__Group__0"
    // InternalCustomProlog.g:843:1: rule__Rule__Group__0 : rule__Rule__Group__0__Impl rule__Rule__Group__1 ;
    public final void rule__Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:847:1: ( rule__Rule__Group__0__Impl rule__Rule__Group__1 )
            // InternalCustomProlog.g:848:2: rule__Rule__Group__0__Impl rule__Rule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Rule__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Rule__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0"


    // $ANTLR start "rule__Rule__Group__0__Impl"
    // InternalCustomProlog.g:855:1: rule__Rule__Group__0__Impl : ( ( rule__Rule__RuleAssignment_0 ) ) ;
    public final void rule__Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:859:1: ( ( ( rule__Rule__RuleAssignment_0 ) ) )
            // InternalCustomProlog.g:860:1: ( ( rule__Rule__RuleAssignment_0 ) )
            {
            // InternalCustomProlog.g:860:1: ( ( rule__Rule__RuleAssignment_0 ) )
            // InternalCustomProlog.g:861:2: ( rule__Rule__RuleAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getRuleAssignment_0()); 
            }
            // InternalCustomProlog.g:862:2: ( rule__Rule__RuleAssignment_0 )
            // InternalCustomProlog.g:862:3: rule__Rule__RuleAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Rule__RuleAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getRuleAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0__Impl"


    // $ANTLR start "rule__Rule__Group__1"
    // InternalCustomProlog.g:870:1: rule__Rule__Group__1 : rule__Rule__Group__1__Impl rule__Rule__Group__2 ;
    public final void rule__Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:874:1: ( rule__Rule__Group__1__Impl rule__Rule__Group__2 )
            // InternalCustomProlog.g:875:2: rule__Rule__Group__1__Impl rule__Rule__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Rule__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Rule__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1"


    // $ANTLR start "rule__Rule__Group__1__Impl"
    // InternalCustomProlog.g:882:1: rule__Rule__Group__1__Impl : ( ':-' ) ;
    public final void rule__Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:886:1: ( ( ':-' ) )
            // InternalCustomProlog.g:887:1: ( ':-' )
            {
            // InternalCustomProlog.g:887:1: ( ':-' )
            // InternalCustomProlog.g:888:2: ':-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getColonHyphenMinusKeyword_1()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getColonHyphenMinusKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1__Impl"


    // $ANTLR start "rule__Rule__Group__2"
    // InternalCustomProlog.g:897:1: rule__Rule__Group__2 : rule__Rule__Group__2__Impl rule__Rule__Group__3 ;
    public final void rule__Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:901:1: ( rule__Rule__Group__2__Impl rule__Rule__Group__3 )
            // InternalCustomProlog.g:902:2: rule__Rule__Group__2__Impl rule__Rule__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Rule__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Rule__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2"


    // $ANTLR start "rule__Rule__Group__2__Impl"
    // InternalCustomProlog.g:909:1: rule__Rule__Group__2__Impl : ( ( rule__Rule__QueryAssignment_2 ) ) ;
    public final void rule__Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:913:1: ( ( ( rule__Rule__QueryAssignment_2 ) ) )
            // InternalCustomProlog.g:914:1: ( ( rule__Rule__QueryAssignment_2 ) )
            {
            // InternalCustomProlog.g:914:1: ( ( rule__Rule__QueryAssignment_2 ) )
            // InternalCustomProlog.g:915:2: ( rule__Rule__QueryAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getQueryAssignment_2()); 
            }
            // InternalCustomProlog.g:916:2: ( rule__Rule__QueryAssignment_2 )
            // InternalCustomProlog.g:916:3: rule__Rule__QueryAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Rule__QueryAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getQueryAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2__Impl"


    // $ANTLR start "rule__Rule__Group__3"
    // InternalCustomProlog.g:924:1: rule__Rule__Group__3 : rule__Rule__Group__3__Impl ;
    public final void rule__Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:928:1: ( rule__Rule__Group__3__Impl )
            // InternalCustomProlog.g:929:2: rule__Rule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3"


    // $ANTLR start "rule__Rule__Group__3__Impl"
    // InternalCustomProlog.g:935:1: rule__Rule__Group__3__Impl : ( '.' ) ;
    public final void rule__Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:939:1: ( ( '.' ) )
            // InternalCustomProlog.g:940:1: ( '.' )
            {
            // InternalCustomProlog.g:940:1: ( '.' )
            // InternalCustomProlog.g:941:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getFullStopKeyword_3()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getFullStopKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3__Impl"


    // $ANTLR start "rule__Predicate__Group__0"
    // InternalCustomProlog.g:951:1: rule__Predicate__Group__0 : rule__Predicate__Group__0__Impl rule__Predicate__Group__1 ;
    public final void rule__Predicate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:955:1: ( rule__Predicate__Group__0__Impl rule__Predicate__Group__1 )
            // InternalCustomProlog.g:956:2: rule__Predicate__Group__0__Impl rule__Predicate__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Predicate__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__0"


    // $ANTLR start "rule__Predicate__Group__0__Impl"
    // InternalCustomProlog.g:963:1: rule__Predicate__Group__0__Impl : ( ( rule__Predicate__FunctorAssignment_0 ) ) ;
    public final void rule__Predicate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:967:1: ( ( ( rule__Predicate__FunctorAssignment_0 ) ) )
            // InternalCustomProlog.g:968:1: ( ( rule__Predicate__FunctorAssignment_0 ) )
            {
            // InternalCustomProlog.g:968:1: ( ( rule__Predicate__FunctorAssignment_0 ) )
            // InternalCustomProlog.g:969:2: ( rule__Predicate__FunctorAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getFunctorAssignment_0()); 
            }
            // InternalCustomProlog.g:970:2: ( rule__Predicate__FunctorAssignment_0 )
            // InternalCustomProlog.g:970:3: rule__Predicate__FunctorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__FunctorAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getFunctorAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__0__Impl"


    // $ANTLR start "rule__Predicate__Group__1"
    // InternalCustomProlog.g:978:1: rule__Predicate__Group__1 : rule__Predicate__Group__1__Impl rule__Predicate__Group__2 ;
    public final void rule__Predicate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:982:1: ( rule__Predicate__Group__1__Impl rule__Predicate__Group__2 )
            // InternalCustomProlog.g:983:2: rule__Predicate__Group__1__Impl rule__Predicate__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__Predicate__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__1"


    // $ANTLR start "rule__Predicate__Group__1__Impl"
    // InternalCustomProlog.g:990:1: rule__Predicate__Group__1__Impl : ( '(' ) ;
    public final void rule__Predicate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:994:1: ( ( '(' ) )
            // InternalCustomProlog.g:995:1: ( '(' )
            {
            // InternalCustomProlog.g:995:1: ( '(' )
            // InternalCustomProlog.g:996:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__1__Impl"


    // $ANTLR start "rule__Predicate__Group__2"
    // InternalCustomProlog.g:1005:1: rule__Predicate__Group__2 : rule__Predicate__Group__2__Impl rule__Predicate__Group__3 ;
    public final void rule__Predicate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1009:1: ( rule__Predicate__Group__2__Impl rule__Predicate__Group__3 )
            // InternalCustomProlog.g:1010:2: rule__Predicate__Group__2__Impl rule__Predicate__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Predicate__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__2"


    // $ANTLR start "rule__Predicate__Group__2__Impl"
    // InternalCustomProlog.g:1017:1: rule__Predicate__Group__2__Impl : ( ( rule__Predicate__TermAssignment_2 ) ) ;
    public final void rule__Predicate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1021:1: ( ( ( rule__Predicate__TermAssignment_2 ) ) )
            // InternalCustomProlog.g:1022:1: ( ( rule__Predicate__TermAssignment_2 ) )
            {
            // InternalCustomProlog.g:1022:1: ( ( rule__Predicate__TermAssignment_2 ) )
            // InternalCustomProlog.g:1023:2: ( rule__Predicate__TermAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getTermAssignment_2()); 
            }
            // InternalCustomProlog.g:1024:2: ( rule__Predicate__TermAssignment_2 )
            // InternalCustomProlog.g:1024:3: rule__Predicate__TermAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__TermAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getTermAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__2__Impl"


    // $ANTLR start "rule__Predicate__Group__3"
    // InternalCustomProlog.g:1032:1: rule__Predicate__Group__3 : rule__Predicate__Group__3__Impl rule__Predicate__Group__4 ;
    public final void rule__Predicate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1036:1: ( rule__Predicate__Group__3__Impl rule__Predicate__Group__4 )
            // InternalCustomProlog.g:1037:2: rule__Predicate__Group__3__Impl rule__Predicate__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__Predicate__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__3"


    // $ANTLR start "rule__Predicate__Group__3__Impl"
    // InternalCustomProlog.g:1044:1: rule__Predicate__Group__3__Impl : ( ( rule__Predicate__Group_3__0 )* ) ;
    public final void rule__Predicate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1048:1: ( ( ( rule__Predicate__Group_3__0 )* ) )
            // InternalCustomProlog.g:1049:1: ( ( rule__Predicate__Group_3__0 )* )
            {
            // InternalCustomProlog.g:1049:1: ( ( rule__Predicate__Group_3__0 )* )
            // InternalCustomProlog.g:1050:2: ( rule__Predicate__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getGroup_3()); 
            }
            // InternalCustomProlog.g:1051:2: ( rule__Predicate__Group_3__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCustomProlog.g:1051:3: rule__Predicate__Group_3__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Predicate__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__3__Impl"


    // $ANTLR start "rule__Predicate__Group__4"
    // InternalCustomProlog.g:1059:1: rule__Predicate__Group__4 : rule__Predicate__Group__4__Impl ;
    public final void rule__Predicate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1063:1: ( rule__Predicate__Group__4__Impl )
            // InternalCustomProlog.g:1064:2: rule__Predicate__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__4"


    // $ANTLR start "rule__Predicate__Group__4__Impl"
    // InternalCustomProlog.g:1070:1: rule__Predicate__Group__4__Impl : ( ')' ) ;
    public final void rule__Predicate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1074:1: ( ( ')' ) )
            // InternalCustomProlog.g:1075:1: ( ')' )
            {
            // InternalCustomProlog.g:1075:1: ( ')' )
            // InternalCustomProlog.g:1076:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group__4__Impl"


    // $ANTLR start "rule__Predicate__Group_3__0"
    // InternalCustomProlog.g:1086:1: rule__Predicate__Group_3__0 : rule__Predicate__Group_3__0__Impl rule__Predicate__Group_3__1 ;
    public final void rule__Predicate__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1090:1: ( rule__Predicate__Group_3__0__Impl rule__Predicate__Group_3__1 )
            // InternalCustomProlog.g:1091:2: rule__Predicate__Group_3__0__Impl rule__Predicate__Group_3__1
            {
            pushFollow(FOLLOW_11);
            rule__Predicate__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Predicate__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group_3__0"


    // $ANTLR start "rule__Predicate__Group_3__0__Impl"
    // InternalCustomProlog.g:1098:1: rule__Predicate__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Predicate__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1102:1: ( ( ',' ) )
            // InternalCustomProlog.g:1103:1: ( ',' )
            {
            // InternalCustomProlog.g:1103:1: ( ',' )
            // InternalCustomProlog.g:1104:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getCommaKeyword_3_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getCommaKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group_3__0__Impl"


    // $ANTLR start "rule__Predicate__Group_3__1"
    // InternalCustomProlog.g:1113:1: rule__Predicate__Group_3__1 : rule__Predicate__Group_3__1__Impl ;
    public final void rule__Predicate__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1117:1: ( rule__Predicate__Group_3__1__Impl )
            // InternalCustomProlog.g:1118:2: rule__Predicate__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group_3__1"


    // $ANTLR start "rule__Predicate__Group_3__1__Impl"
    // InternalCustomProlog.g:1124:1: rule__Predicate__Group_3__1__Impl : ( ( rule__Predicate__TermAssignment_3_1 ) ) ;
    public final void rule__Predicate__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1128:1: ( ( ( rule__Predicate__TermAssignment_3_1 ) ) )
            // InternalCustomProlog.g:1129:1: ( ( rule__Predicate__TermAssignment_3_1 ) )
            {
            // InternalCustomProlog.g:1129:1: ( ( rule__Predicate__TermAssignment_3_1 ) )
            // InternalCustomProlog.g:1130:2: ( rule__Predicate__TermAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getTermAssignment_3_1()); 
            }
            // InternalCustomProlog.g:1131:2: ( rule__Predicate__TermAssignment_3_1 )
            // InternalCustomProlog.g:1131:3: rule__Predicate__TermAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__TermAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getTermAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Group_3__1__Impl"


    // $ANTLR start "rule__List__Group_0__0"
    // InternalCustomProlog.g:1140:1: rule__List__Group_0__0 : rule__List__Group_0__0__Impl rule__List__Group_0__1 ;
    public final void rule__List__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1144:1: ( rule__List__Group_0__0__Impl rule__List__Group_0__1 )
            // InternalCustomProlog.g:1145:2: rule__List__Group_0__0__Impl rule__List__Group_0__1
            {
            pushFollow(FOLLOW_13);
            rule__List__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__List__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__List__Group_0__0"


    // $ANTLR start "rule__List__Group_0__0__Impl"
    // InternalCustomProlog.g:1152:1: rule__List__Group_0__0__Impl : ( () ) ;
    public final void rule__List__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1156:1: ( ( () ) )
            // InternalCustomProlog.g:1157:1: ( () )
            {
            // InternalCustomProlog.g:1157:1: ( () )
            // InternalCustomProlog.g:1158:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListAccess().getListAction_0_0()); 
            }
            // InternalCustomProlog.g:1159:2: ()
            // InternalCustomProlog.g:1159:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListAccess().getListAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__List__Group_0__0__Impl"


    // $ANTLR start "rule__List__Group_0__1"
    // InternalCustomProlog.g:1167:1: rule__List__Group_0__1 : rule__List__Group_0__1__Impl ;
    public final void rule__List__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1171:1: ( rule__List__Group_0__1__Impl )
            // InternalCustomProlog.g:1172:2: rule__List__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__List__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__List__Group_0__1"


    // $ANTLR start "rule__List__Group_0__1__Impl"
    // InternalCustomProlog.g:1178:1: rule__List__Group_0__1__Impl : ( '[]' ) ;
    public final void rule__List__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1182:1: ( ( '[]' ) )
            // InternalCustomProlog.g:1183:1: ( '[]' )
            {
            // InternalCustomProlog.g:1183:1: ( '[]' )
            // InternalCustomProlog.g:1184:2: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListAccess().getLeftSquareBracketRightSquareBracketKeyword_0_1()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListAccess().getLeftSquareBracketRightSquareBracketKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__List__Group_0__1__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_0__0"
    // InternalCustomProlog.g:1194:1: rule__NonEmptyList__Group_0__0 : rule__NonEmptyList__Group_0__0__Impl rule__NonEmptyList__Group_0__1 ;
    public final void rule__NonEmptyList__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1198:1: ( rule__NonEmptyList__Group_0__0__Impl rule__NonEmptyList__Group_0__1 )
            // InternalCustomProlog.g:1199:2: rule__NonEmptyList__Group_0__0__Impl rule__NonEmptyList__Group_0__1
            {
            pushFollow(FOLLOW_14);
            rule__NonEmptyList__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_0__0"


    // $ANTLR start "rule__NonEmptyList__Group_0__0__Impl"
    // InternalCustomProlog.g:1206:1: rule__NonEmptyList__Group_0__0__Impl : ( '[' ) ;
    public final void rule__NonEmptyList__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1210:1: ( ( '[' ) )
            // InternalCustomProlog.g:1211:1: ( '[' )
            {
            // InternalCustomProlog.g:1211:1: ( '[' )
            // InternalCustomProlog.g:1212:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_0_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_0__0__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_0__1"
    // InternalCustomProlog.g:1221:1: rule__NonEmptyList__Group_0__1 : rule__NonEmptyList__Group_0__1__Impl rule__NonEmptyList__Group_0__2 ;
    public final void rule__NonEmptyList__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1225:1: ( rule__NonEmptyList__Group_0__1__Impl rule__NonEmptyList__Group_0__2 )
            // InternalCustomProlog.g:1226:2: rule__NonEmptyList__Group_0__1__Impl rule__NonEmptyList__Group_0__2
            {
            pushFollow(FOLLOW_15);
            rule__NonEmptyList__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_0__1"


    // $ANTLR start "rule__NonEmptyList__Group_0__1__Impl"
    // InternalCustomProlog.g:1233:1: rule__NonEmptyList__Group_0__1__Impl : ( ( rule__NonEmptyList__FolgeAssignment_0_1 ) ) ;
    public final void rule__NonEmptyList__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1237:1: ( ( ( rule__NonEmptyList__FolgeAssignment_0_1 ) ) )
            // InternalCustomProlog.g:1238:1: ( ( rule__NonEmptyList__FolgeAssignment_0_1 ) )
            {
            // InternalCustomProlog.g:1238:1: ( ( rule__NonEmptyList__FolgeAssignment_0_1 ) )
            // InternalCustomProlog.g:1239:2: ( rule__NonEmptyList__FolgeAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getFolgeAssignment_0_1()); 
            }
            // InternalCustomProlog.g:1240:2: ( rule__NonEmptyList__FolgeAssignment_0_1 )
            // InternalCustomProlog.g:1240:3: rule__NonEmptyList__FolgeAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__FolgeAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getFolgeAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_0__1__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_0__2"
    // InternalCustomProlog.g:1248:1: rule__NonEmptyList__Group_0__2 : rule__NonEmptyList__Group_0__2__Impl ;
    public final void rule__NonEmptyList__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1252:1: ( rule__NonEmptyList__Group_0__2__Impl )
            // InternalCustomProlog.g:1253:2: rule__NonEmptyList__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_0__2"


    // $ANTLR start "rule__NonEmptyList__Group_0__2__Impl"
    // InternalCustomProlog.g:1259:1: rule__NonEmptyList__Group_0__2__Impl : ( ']' ) ;
    public final void rule__NonEmptyList__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1263:1: ( ( ']' ) )
            // InternalCustomProlog.g:1264:1: ( ']' )
            {
            // InternalCustomProlog.g:1264:1: ( ']' )
            // InternalCustomProlog.g:1265:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_0_2()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_0__2__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_1__0"
    // InternalCustomProlog.g:1275:1: rule__NonEmptyList__Group_1__0 : rule__NonEmptyList__Group_1__0__Impl rule__NonEmptyList__Group_1__1 ;
    public final void rule__NonEmptyList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1279:1: ( rule__NonEmptyList__Group_1__0__Impl rule__NonEmptyList__Group_1__1 )
            // InternalCustomProlog.g:1280:2: rule__NonEmptyList__Group_1__0__Impl rule__NonEmptyList__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__NonEmptyList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1__0"


    // $ANTLR start "rule__NonEmptyList__Group_1__0__Impl"
    // InternalCustomProlog.g:1287:1: rule__NonEmptyList__Group_1__0__Impl : ( '[' ) ;
    public final void rule__NonEmptyList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1291:1: ( ( '[' ) )
            // InternalCustomProlog.g:1292:1: ( '[' )
            {
            // InternalCustomProlog.g:1292:1: ( '[' )
            // InternalCustomProlog.g:1293:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1__0__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_1__1"
    // InternalCustomProlog.g:1302:1: rule__NonEmptyList__Group_1__1 : rule__NonEmptyList__Group_1__1__Impl rule__NonEmptyList__Group_1__2 ;
    public final void rule__NonEmptyList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1306:1: ( rule__NonEmptyList__Group_1__1__Impl rule__NonEmptyList__Group_1__2 )
            // InternalCustomProlog.g:1307:2: rule__NonEmptyList__Group_1__1__Impl rule__NonEmptyList__Group_1__2
            {
            pushFollow(FOLLOW_15);
            rule__NonEmptyList__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1__1"


    // $ANTLR start "rule__NonEmptyList__Group_1__1__Impl"
    // InternalCustomProlog.g:1314:1: rule__NonEmptyList__Group_1__1__Impl : ( ( rule__NonEmptyList__Group_1_1__0 ) ) ;
    public final void rule__NonEmptyList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1318:1: ( ( ( rule__NonEmptyList__Group_1_1__0 ) ) )
            // InternalCustomProlog.g:1319:1: ( ( rule__NonEmptyList__Group_1_1__0 ) )
            {
            // InternalCustomProlog.g:1319:1: ( ( rule__NonEmptyList__Group_1_1__0 ) )
            // InternalCustomProlog.g:1320:2: ( rule__NonEmptyList__Group_1_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getGroup_1_1()); 
            }
            // InternalCustomProlog.g:1321:2: ( rule__NonEmptyList__Group_1_1__0 )
            // InternalCustomProlog.g:1321:3: rule__NonEmptyList__Group_1_1__0
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getGroup_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1__1__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_1__2"
    // InternalCustomProlog.g:1329:1: rule__NonEmptyList__Group_1__2 : rule__NonEmptyList__Group_1__2__Impl ;
    public final void rule__NonEmptyList__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1333:1: ( rule__NonEmptyList__Group_1__2__Impl )
            // InternalCustomProlog.g:1334:2: rule__NonEmptyList__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1__2"


    // $ANTLR start "rule__NonEmptyList__Group_1__2__Impl"
    // InternalCustomProlog.g:1340:1: rule__NonEmptyList__Group_1__2__Impl : ( ']' ) ;
    public final void rule__NonEmptyList__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1344:1: ( ( ']' ) )
            // InternalCustomProlog.g:1345:1: ( ']' )
            {
            // InternalCustomProlog.g:1345:1: ( ']' )
            // InternalCustomProlog.g:1346:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_1_2()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1__2__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_1_1__0"
    // InternalCustomProlog.g:1356:1: rule__NonEmptyList__Group_1_1__0 : rule__NonEmptyList__Group_1_1__0__Impl rule__NonEmptyList__Group_1_1__1 ;
    public final void rule__NonEmptyList__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1360:1: ( rule__NonEmptyList__Group_1_1__0__Impl rule__NonEmptyList__Group_1_1__1 )
            // InternalCustomProlog.g:1361:2: rule__NonEmptyList__Group_1_1__0__Impl rule__NonEmptyList__Group_1_1__1
            {
            pushFollow(FOLLOW_16);
            rule__NonEmptyList__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1_1__0"


    // $ANTLR start "rule__NonEmptyList__Group_1_1__0__Impl"
    // InternalCustomProlog.g:1368:1: rule__NonEmptyList__Group_1_1__0__Impl : ( ( rule__NonEmptyList__AtomAssignment_1_1_0 ) ) ;
    public final void rule__NonEmptyList__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1372:1: ( ( ( rule__NonEmptyList__AtomAssignment_1_1_0 ) ) )
            // InternalCustomProlog.g:1373:1: ( ( rule__NonEmptyList__AtomAssignment_1_1_0 ) )
            {
            // InternalCustomProlog.g:1373:1: ( ( rule__NonEmptyList__AtomAssignment_1_1_0 ) )
            // InternalCustomProlog.g:1374:2: ( rule__NonEmptyList__AtomAssignment_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getAtomAssignment_1_1_0()); 
            }
            // InternalCustomProlog.g:1375:2: ( rule__NonEmptyList__AtomAssignment_1_1_0 )
            // InternalCustomProlog.g:1375:3: rule__NonEmptyList__AtomAssignment_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__AtomAssignment_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getAtomAssignment_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1_1__0__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_1_1__1"
    // InternalCustomProlog.g:1383:1: rule__NonEmptyList__Group_1_1__1 : rule__NonEmptyList__Group_1_1__1__Impl rule__NonEmptyList__Group_1_1__2 ;
    public final void rule__NonEmptyList__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1387:1: ( rule__NonEmptyList__Group_1_1__1__Impl rule__NonEmptyList__Group_1_1__2 )
            // InternalCustomProlog.g:1388:2: rule__NonEmptyList__Group_1_1__1__Impl rule__NonEmptyList__Group_1_1__2
            {
            pushFollow(FOLLOW_11);
            rule__NonEmptyList__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1_1__1"


    // $ANTLR start "rule__NonEmptyList__Group_1_1__1__Impl"
    // InternalCustomProlog.g:1395:1: rule__NonEmptyList__Group_1_1__1__Impl : ( '|' ) ;
    public final void rule__NonEmptyList__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1399:1: ( ( '|' ) )
            // InternalCustomProlog.g:1400:1: ( '|' )
            {
            // InternalCustomProlog.g:1400:1: ( '|' )
            // InternalCustomProlog.g:1401:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getVerticalLineKeyword_1_1_1()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getVerticalLineKeyword_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1_1__1__Impl"


    // $ANTLR start "rule__NonEmptyList__Group_1_1__2"
    // InternalCustomProlog.g:1410:1: rule__NonEmptyList__Group_1_1__2 : rule__NonEmptyList__Group_1_1__2__Impl ;
    public final void rule__NonEmptyList__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1414:1: ( rule__NonEmptyList__Group_1_1__2__Impl )
            // InternalCustomProlog.g:1415:2: rule__NonEmptyList__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1_1__2"


    // $ANTLR start "rule__NonEmptyList__Group_1_1__2__Impl"
    // InternalCustomProlog.g:1421:1: rule__NonEmptyList__Group_1_1__2__Impl : ( ( rule__NonEmptyList__TermAssignment_1_1_2 ) ) ;
    public final void rule__NonEmptyList__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1425:1: ( ( ( rule__NonEmptyList__TermAssignment_1_1_2 ) ) )
            // InternalCustomProlog.g:1426:1: ( ( rule__NonEmptyList__TermAssignment_1_1_2 ) )
            {
            // InternalCustomProlog.g:1426:1: ( ( rule__NonEmptyList__TermAssignment_1_1_2 ) )
            // InternalCustomProlog.g:1427:2: ( rule__NonEmptyList__TermAssignment_1_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getTermAssignment_1_1_2()); 
            }
            // InternalCustomProlog.g:1428:2: ( rule__NonEmptyList__TermAssignment_1_1_2 )
            // InternalCustomProlog.g:1428:3: rule__NonEmptyList__TermAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__NonEmptyList__TermAssignment_1_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getTermAssignment_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__Group_1_1__2__Impl"


    // $ANTLR start "rule__Folge__Group__0"
    // InternalCustomProlog.g:1437:1: rule__Folge__Group__0 : rule__Folge__Group__0__Impl rule__Folge__Group__1 ;
    public final void rule__Folge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1441:1: ( rule__Folge__Group__0__Impl rule__Folge__Group__1 )
            // InternalCustomProlog.g:1442:2: rule__Folge__Group__0__Impl rule__Folge__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Folge__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Folge__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group__0"


    // $ANTLR start "rule__Folge__Group__0__Impl"
    // InternalCustomProlog.g:1449:1: rule__Folge__Group__0__Impl : ( ( rule__Folge__AtomAssignment_0 ) ) ;
    public final void rule__Folge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1453:1: ( ( ( rule__Folge__AtomAssignment_0 ) ) )
            // InternalCustomProlog.g:1454:1: ( ( rule__Folge__AtomAssignment_0 ) )
            {
            // InternalCustomProlog.g:1454:1: ( ( rule__Folge__AtomAssignment_0 ) )
            // InternalCustomProlog.g:1455:2: ( rule__Folge__AtomAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getAtomAssignment_0()); 
            }
            // InternalCustomProlog.g:1456:2: ( rule__Folge__AtomAssignment_0 )
            // InternalCustomProlog.g:1456:3: rule__Folge__AtomAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Folge__AtomAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getAtomAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group__0__Impl"


    // $ANTLR start "rule__Folge__Group__1"
    // InternalCustomProlog.g:1464:1: rule__Folge__Group__1 : rule__Folge__Group__1__Impl ;
    public final void rule__Folge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1468:1: ( rule__Folge__Group__1__Impl )
            // InternalCustomProlog.g:1469:2: rule__Folge__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Folge__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group__1"


    // $ANTLR start "rule__Folge__Group__1__Impl"
    // InternalCustomProlog.g:1475:1: rule__Folge__Group__1__Impl : ( ( rule__Folge__Group_1__0 )* ) ;
    public final void rule__Folge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1479:1: ( ( ( rule__Folge__Group_1__0 )* ) )
            // InternalCustomProlog.g:1480:1: ( ( rule__Folge__Group_1__0 )* )
            {
            // InternalCustomProlog.g:1480:1: ( ( rule__Folge__Group_1__0 )* )
            // InternalCustomProlog.g:1481:2: ( rule__Folge__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getGroup_1()); 
            }
            // InternalCustomProlog.g:1482:2: ( rule__Folge__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCustomProlog.g:1482:3: rule__Folge__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Folge__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group__1__Impl"


    // $ANTLR start "rule__Folge__Group_1__0"
    // InternalCustomProlog.g:1491:1: rule__Folge__Group_1__0 : rule__Folge__Group_1__0__Impl rule__Folge__Group_1__1 ;
    public final void rule__Folge__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1495:1: ( rule__Folge__Group_1__0__Impl rule__Folge__Group_1__1 )
            // InternalCustomProlog.g:1496:2: rule__Folge__Group_1__0__Impl rule__Folge__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Folge__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Folge__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group_1__0"


    // $ANTLR start "rule__Folge__Group_1__0__Impl"
    // InternalCustomProlog.g:1503:1: rule__Folge__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Folge__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1507:1: ( ( ',' ) )
            // InternalCustomProlog.g:1508:1: ( ',' )
            {
            // InternalCustomProlog.g:1508:1: ( ',' )
            // InternalCustomProlog.g:1509:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getCommaKeyword_1_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group_1__0__Impl"


    // $ANTLR start "rule__Folge__Group_1__1"
    // InternalCustomProlog.g:1518:1: rule__Folge__Group_1__1 : rule__Folge__Group_1__1__Impl ;
    public final void rule__Folge__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1522:1: ( rule__Folge__Group_1__1__Impl )
            // InternalCustomProlog.g:1523:2: rule__Folge__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Folge__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group_1__1"


    // $ANTLR start "rule__Folge__Group_1__1__Impl"
    // InternalCustomProlog.g:1529:1: rule__Folge__Group_1__1__Impl : ( ( rule__Folge__AtomAssignment_1_1 ) ) ;
    public final void rule__Folge__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1533:1: ( ( ( rule__Folge__AtomAssignment_1_1 ) ) )
            // InternalCustomProlog.g:1534:1: ( ( rule__Folge__AtomAssignment_1_1 ) )
            {
            // InternalCustomProlog.g:1534:1: ( ( rule__Folge__AtomAssignment_1_1 ) )
            // InternalCustomProlog.g:1535:2: ( rule__Folge__AtomAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getAtomAssignment_1_1()); 
            }
            // InternalCustomProlog.g:1536:2: ( rule__Folge__AtomAssignment_1_1 )
            // InternalCustomProlog.g:1536:3: rule__Folge__AtomAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Folge__AtomAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getAtomAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ExpressionsAssignment"
    // InternalCustomProlog.g:1545:1: rule__Model__ExpressionsAssignment : ( rulePrologdsl ) ;
    public final void rule__Model__ExpressionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1549:1: ( ( rulePrologdsl ) )
            // InternalCustomProlog.g:1550:2: ( rulePrologdsl )
            {
            // InternalCustomProlog.g:1550:2: ( rulePrologdsl )
            // InternalCustomProlog.g:1551:3: rulePrologdsl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getExpressionsPrologdslParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrologdsl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getExpressionsPrologdslParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ExpressionsAssignment"


    // $ANTLR start "rule__Prologdsl__ProgramAssignment_0"
    // InternalCustomProlog.g:1560:1: rule__Prologdsl__ProgramAssignment_0 : ( ruleProgram ) ;
    public final void rule__Prologdsl__ProgramAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1564:1: ( ( ruleProgram ) )
            // InternalCustomProlog.g:1565:2: ( ruleProgram )
            {
            // InternalCustomProlog.g:1565:2: ( ruleProgram )
            // InternalCustomProlog.g:1566:3: ruleProgram
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrologdslAccess().getProgramProgramParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleProgram();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrologdslAccess().getProgramProgramParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prologdsl__ProgramAssignment_0"


    // $ANTLR start "rule__Prologdsl__ExqueryAssignment_1"
    // InternalCustomProlog.g:1575:1: rule__Prologdsl__ExqueryAssignment_1 : ( ruleExquery ) ;
    public final void rule__Prologdsl__ExqueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1579:1: ( ( ruleExquery ) )
            // InternalCustomProlog.g:1580:2: ( ruleExquery )
            {
            // InternalCustomProlog.g:1580:2: ( ruleExquery )
            // InternalCustomProlog.g:1581:3: ruleExquery
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrologdslAccess().getExqueryExqueryParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExquery();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrologdslAccess().getExqueryExqueryParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prologdsl__ExqueryAssignment_1"


    // $ANTLR start "rule__Program__ClausesAssignment"
    // InternalCustomProlog.g:1590:1: rule__Program__ClausesAssignment : ( ruleClause ) ;
    public final void rule__Program__ClausesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1594:1: ( ( ruleClause ) )
            // InternalCustomProlog.g:1595:2: ( ruleClause )
            {
            // InternalCustomProlog.g:1595:2: ( ruleClause )
            // InternalCustomProlog.g:1596:3: ruleClause
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClausesClauseParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleClause();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClausesClauseParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ClausesAssignment"


    // $ANTLR start "rule__Exquery__QueryAssignment_1"
    // InternalCustomProlog.g:1605:1: rule__Exquery__QueryAssignment_1 : ( ruleQuery ) ;
    public final void rule__Exquery__QueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1609:1: ( ( ruleQuery ) )
            // InternalCustomProlog.g:1610:2: ( ruleQuery )
            {
            // InternalCustomProlog.g:1610:2: ( ruleQuery )
            // InternalCustomProlog.g:1611:3: ruleQuery
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExqueryAccess().getQueryQueryParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQuery();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExqueryAccess().getQueryQueryParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exquery__QueryAssignment_1"


    // $ANTLR start "rule__Query__PAssignment_0"
    // InternalCustomProlog.g:1620:1: rule__Query__PAssignment_0 : ( rulePredicate ) ;
    public final void rule__Query__PAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1624:1: ( ( rulePredicate ) )
            // InternalCustomProlog.g:1625:2: ( rulePredicate )
            {
            // InternalCustomProlog.g:1625:2: ( rulePredicate )
            // InternalCustomProlog.g:1626:3: rulePredicate
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__PAssignment_0"


    // $ANTLR start "rule__Query__PAssignment_1_1"
    // InternalCustomProlog.g:1635:1: rule__Query__PAssignment_1_1 : ( rulePredicate ) ;
    public final void rule__Query__PAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1639:1: ( ( rulePredicate ) )
            // InternalCustomProlog.g:1640:2: ( rulePredicate )
            {
            // InternalCustomProlog.g:1640:2: ( rulePredicate )
            // InternalCustomProlog.g:1641:3: rulePredicate
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__PAssignment_1_1"


    // $ANTLR start "rule__Clause__FactAssignment_0"
    // InternalCustomProlog.g:1650:1: rule__Clause__FactAssignment_0 : ( ruleFact ) ;
    public final void rule__Clause__FactAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1654:1: ( ( ruleFact ) )
            // InternalCustomProlog.g:1655:2: ( ruleFact )
            {
            // InternalCustomProlog.g:1655:2: ( ruleFact )
            // InternalCustomProlog.g:1656:3: ruleFact
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClauseAccess().getFactFactParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFact();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClauseAccess().getFactFactParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clause__FactAssignment_0"


    // $ANTLR start "rule__Clause__RuleAssignment_1"
    // InternalCustomProlog.g:1665:1: rule__Clause__RuleAssignment_1 : ( ruleRule ) ;
    public final void rule__Clause__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1669:1: ( ( ruleRule ) )
            // InternalCustomProlog.g:1670:2: ( ruleRule )
            {
            // InternalCustomProlog.g:1670:2: ( ruleRule )
            // InternalCustomProlog.g:1671:3: ruleRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClauseAccess().getRuleRuleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClauseAccess().getRuleRuleParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clause__RuleAssignment_1"


    // $ANTLR start "rule__Fact__PredicateAssignment_0"
    // InternalCustomProlog.g:1680:1: rule__Fact__PredicateAssignment_0 : ( rulePredicate ) ;
    public final void rule__Fact__PredicateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1684:1: ( ( rulePredicate ) )
            // InternalCustomProlog.g:1685:2: ( rulePredicate )
            {
            // InternalCustomProlog.g:1685:2: ( rulePredicate )
            // InternalCustomProlog.g:1686:3: rulePredicate
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFactAccess().getPredicatePredicateParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFactAccess().getPredicatePredicateParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fact__PredicateAssignment_0"


    // $ANTLR start "rule__Rule__RuleAssignment_0"
    // InternalCustomProlog.g:1695:1: rule__Rule__RuleAssignment_0 : ( rulePredicate ) ;
    public final void rule__Rule__RuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1699:1: ( ( rulePredicate ) )
            // InternalCustomProlog.g:1700:2: ( rulePredicate )
            {
            // InternalCustomProlog.g:1700:2: ( rulePredicate )
            // InternalCustomProlog.g:1701:3: rulePredicate
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getRulePredicateParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getRulePredicateParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__RuleAssignment_0"


    // $ANTLR start "rule__Rule__QueryAssignment_2"
    // InternalCustomProlog.g:1710:1: rule__Rule__QueryAssignment_2 : ( ruleQuery ) ;
    public final void rule__Rule__QueryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1714:1: ( ( ruleQuery ) )
            // InternalCustomProlog.g:1715:2: ( ruleQuery )
            {
            // InternalCustomProlog.g:1715:2: ( ruleQuery )
            // InternalCustomProlog.g:1716:3: ruleQuery
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleAccess().getQueryQueryParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQuery();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleAccess().getQueryQueryParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__QueryAssignment_2"


    // $ANTLR start "rule__Predicate__FunctorAssignment_0"
    // InternalCustomProlog.g:1725:1: rule__Predicate__FunctorAssignment_0 : ( ruleFunctor ) ;
    public final void rule__Predicate__FunctorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1729:1: ( ( ruleFunctor ) )
            // InternalCustomProlog.g:1730:2: ( ruleFunctor )
            {
            // InternalCustomProlog.g:1730:2: ( ruleFunctor )
            // InternalCustomProlog.g:1731:3: ruleFunctor
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getFunctorFunctorParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFunctor();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getFunctorFunctorParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__FunctorAssignment_0"


    // $ANTLR start "rule__Predicate__TermAssignment_2"
    // InternalCustomProlog.g:1740:1: rule__Predicate__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__Predicate__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1744:1: ( ( ruleTerm ) )
            // InternalCustomProlog.g:1745:2: ( ruleTerm )
            {
            // InternalCustomProlog.g:1745:2: ( ruleTerm )
            // InternalCustomProlog.g:1746:3: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__TermAssignment_2"


    // $ANTLR start "rule__Predicate__TermAssignment_3_1"
    // InternalCustomProlog.g:1755:1: rule__Predicate__TermAssignment_3_1 : ( ruleTerm ) ;
    public final void rule__Predicate__TermAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1759:1: ( ( ruleTerm ) )
            // InternalCustomProlog.g:1760:2: ( ruleTerm )
            {
            // InternalCustomProlog.g:1760:2: ( ruleTerm )
            // InternalCustomProlog.g:1761:3: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__TermAssignment_3_1"


    // $ANTLR start "rule__Functor__FuncNameAssignment"
    // InternalCustomProlog.g:1770:1: rule__Functor__FuncNameAssignment : ( RULE_IDENT ) ;
    public final void rule__Functor__FuncNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1774:1: ( ( RULE_IDENT ) )
            // InternalCustomProlog.g:1775:2: ( RULE_IDENT )
            {
            // InternalCustomProlog.g:1775:2: ( RULE_IDENT )
            // InternalCustomProlog.g:1776:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctorAccess().getFuncNameIDENTTerminalRuleCall_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctorAccess().getFuncNameIDENTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__FuncNameAssignment"


    // $ANTLR start "rule__Term__AtomAssignment_0"
    // InternalCustomProlog.g:1785:1: rule__Term__AtomAssignment_0 : ( ruleAtom ) ;
    public final void rule__Term__AtomAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1789:1: ( ( ruleAtom ) )
            // InternalCustomProlog.g:1790:2: ( ruleAtom )
            {
            // InternalCustomProlog.g:1790:2: ( ruleAtom )
            // InternalCustomProlog.g:1791:3: ruleAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getAtomAtomParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getAtomAtomParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__AtomAssignment_0"


    // $ANTLR start "rule__Term__ListAssignment_1"
    // InternalCustomProlog.g:1800:1: rule__Term__ListAssignment_1 : ( ruleList ) ;
    public final void rule__Term__ListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1804:1: ( ( ruleList ) )
            // InternalCustomProlog.g:1805:2: ( ruleList )
            {
            // InternalCustomProlog.g:1805:2: ( ruleList )
            // InternalCustomProlog.g:1806:3: ruleList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getListListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getListListParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__ListAssignment_1"


    // $ANTLR start "rule__Atom__IdentAssignment_0"
    // InternalCustomProlog.g:1815:1: rule__Atom__IdentAssignment_0 : ( RULE_IDENT ) ;
    public final void rule__Atom__IdentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1819:1: ( ( RULE_IDENT ) )
            // InternalCustomProlog.g:1820:2: ( RULE_IDENT )
            {
            // InternalCustomProlog.g:1820:2: ( RULE_IDENT )
            // InternalCustomProlog.g:1821:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomAccess().getIdentIDENTTerminalRuleCall_0_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomAccess().getIdentIDENTTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__IdentAssignment_0"


    // $ANTLR start "rule__Atom__IdentAssignment_1"
    // InternalCustomProlog.g:1830:1: rule__Atom__IdentAssignment_1 : ( RULE_NUMBER ) ;
    public final void rule__Atom__IdentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1834:1: ( ( RULE_NUMBER ) )
            // InternalCustomProlog.g:1835:2: ( RULE_NUMBER )
            {
            // InternalCustomProlog.g:1835:2: ( RULE_NUMBER )
            // InternalCustomProlog.g:1836:3: RULE_NUMBER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomAccess().getIdentNUMBERTerminalRuleCall_1_0()); 
            }
            match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomAccess().getIdentNUMBERTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__IdentAssignment_1"


    // $ANTLR start "rule__Atom__IdentAssignment_2"
    // InternalCustomProlog.g:1845:1: rule__Atom__IdentAssignment_2 : ( RULE_VARIABLE ) ;
    public final void rule__Atom__IdentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1849:1: ( ( RULE_VARIABLE ) )
            // InternalCustomProlog.g:1850:2: ( RULE_VARIABLE )
            {
            // InternalCustomProlog.g:1850:2: ( RULE_VARIABLE )
            // InternalCustomProlog.g:1851:3: RULE_VARIABLE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomAccess().getIdentVARIABLETerminalRuleCall_2_0()); 
            }
            match(input,RULE_VARIABLE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomAccess().getIdentVARIABLETerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__IdentAssignment_2"


    // $ANTLR start "rule__List__NonemptyAssignment_1"
    // InternalCustomProlog.g:1860:1: rule__List__NonemptyAssignment_1 : ( ruleNonEmptyList ) ;
    public final void rule__List__NonemptyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1864:1: ( ( ruleNonEmptyList ) )
            // InternalCustomProlog.g:1865:2: ( ruleNonEmptyList )
            {
            // InternalCustomProlog.g:1865:2: ( ruleNonEmptyList )
            // InternalCustomProlog.g:1866:3: ruleNonEmptyList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListAccess().getNonemptyNonEmptyListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNonEmptyList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListAccess().getNonemptyNonEmptyListParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__List__NonemptyAssignment_1"


    // $ANTLR start "rule__NonEmptyList__FolgeAssignment_0_1"
    // InternalCustomProlog.g:1875:1: rule__NonEmptyList__FolgeAssignment_0_1 : ( ruleFolge ) ;
    public final void rule__NonEmptyList__FolgeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1879:1: ( ( ruleFolge ) )
            // InternalCustomProlog.g:1880:2: ( ruleFolge )
            {
            // InternalCustomProlog.g:1880:2: ( ruleFolge )
            // InternalCustomProlog.g:1881:3: ruleFolge
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getFolgeFolgeParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFolge();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getFolgeFolgeParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__FolgeAssignment_0_1"


    // $ANTLR start "rule__NonEmptyList__AtomAssignment_1_1_0"
    // InternalCustomProlog.g:1890:1: rule__NonEmptyList__AtomAssignment_1_1_0 : ( ruleAtom ) ;
    public final void rule__NonEmptyList__AtomAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1894:1: ( ( ruleAtom ) )
            // InternalCustomProlog.g:1895:2: ( ruleAtom )
            {
            // InternalCustomProlog.g:1895:2: ( ruleAtom )
            // InternalCustomProlog.g:1896:3: ruleAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getAtomAtomParserRuleCall_1_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getAtomAtomParserRuleCall_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__AtomAssignment_1_1_0"


    // $ANTLR start "rule__NonEmptyList__TermAssignment_1_1_2"
    // InternalCustomProlog.g:1905:1: rule__NonEmptyList__TermAssignment_1_1_2 : ( ruleTerm ) ;
    public final void rule__NonEmptyList__TermAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1909:1: ( ( ruleTerm ) )
            // InternalCustomProlog.g:1910:2: ( ruleTerm )
            {
            // InternalCustomProlog.g:1910:2: ( ruleTerm )
            // InternalCustomProlog.g:1911:3: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonEmptyListAccess().getTermTermParserRuleCall_1_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonEmptyListAccess().getTermTermParserRuleCall_1_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonEmptyList__TermAssignment_1_1_2"


    // $ANTLR start "rule__Folge__AtomAssignment_0"
    // InternalCustomProlog.g:1920:1: rule__Folge__AtomAssignment_0 : ( ruleAtom ) ;
    public final void rule__Folge__AtomAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1924:1: ( ( ruleAtom ) )
            // InternalCustomProlog.g:1925:2: ( ruleAtom )
            {
            // InternalCustomProlog.g:1925:2: ( ruleAtom )
            // InternalCustomProlog.g:1926:3: ruleAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__AtomAssignment_0"


    // $ANTLR start "rule__Folge__AtomAssignment_1_1"
    // InternalCustomProlog.g:1935:1: rule__Folge__AtomAssignment_1_1 : ( ruleAtom ) ;
    public final void rule__Folge__AtomAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCustomProlog.g:1939:1: ( ( ruleAtom ) )
            // InternalCustomProlog.g:1940:2: ( ruleAtom )
            {
            // InternalCustomProlog.g:1940:2: ( ruleAtom )
            // InternalCustomProlog.g:1941:3: ruleAtom
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtom();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Folge__AtomAssignment_1_1"

    // $ANTLR start synpred3_InternalCustomProlog
    public final void synpred3_InternalCustomProlog_fragment() throws RecognitionException {   
        // InternalCustomProlog.g:440:2: ( ( ( rule__Clause__FactAssignment_0 ) ) )
        // InternalCustomProlog.g:440:2: ( ( rule__Clause__FactAssignment_0 ) )
        {
        // InternalCustomProlog.g:440:2: ( ( rule__Clause__FactAssignment_0 ) )
        // InternalCustomProlog.g:441:3: ( rule__Clause__FactAssignment_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getClauseAccess().getFactAssignment_0()); 
        }
        // InternalCustomProlog.g:442:3: ( rule__Clause__FactAssignment_0 )
        // InternalCustomProlog.g:442:4: rule__Clause__FactAssignment_0
        {
        pushFollow(FOLLOW_2);
        rule__Clause__FactAssignment_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalCustomProlog

    // Delegated rules

    public final boolean synpred3_InternalCustomProlog() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalCustomProlog_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000300070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});

}