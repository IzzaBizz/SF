package de.htwdd.sf.beleg.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.htwdd.sf.beleg.services.CustomPrologGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalCustomPrologParser extends AbstractInternalAntlrParser {
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

        public InternalCustomPrologParser(TokenStream input, CustomPrologGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected CustomPrologGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalCustomProlog.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCustomProlog.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalCustomProlog.g:65:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalCustomProlog.g:71:1: ruleModel returns [EObject current=null] : ( (lv_expressions_0_0= rulePrologdsl ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:77:2: ( ( (lv_expressions_0_0= rulePrologdsl ) )* )
            // InternalCustomProlog.g:78:2: ( (lv_expressions_0_0= rulePrologdsl ) )*
            {
            // InternalCustomProlog.g:78:2: ( (lv_expressions_0_0= rulePrologdsl ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_IDENT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCustomProlog.g:79:3: (lv_expressions_0_0= rulePrologdsl )
            	    {
            	    // InternalCustomProlog.g:79:3: (lv_expressions_0_0= rulePrologdsl )
            	    // InternalCustomProlog.g:80:4: lv_expressions_0_0= rulePrologdsl
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getModelAccess().getExpressionsPrologdslParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_expressions_0_0=rulePrologdsl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"expressions",
            	      					lv_expressions_0_0,
            	      					"de.htwdd.sf.beleg.CustomProlog.Prologdsl");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePrologdsl"
    // InternalCustomProlog.g:100:1: entryRulePrologdsl returns [EObject current=null] : iv_rulePrologdsl= rulePrologdsl EOF ;
    public final EObject entryRulePrologdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrologdsl = null;


        try {
            // InternalCustomProlog.g:100:50: (iv_rulePrologdsl= rulePrologdsl EOF )
            // InternalCustomProlog.g:101:2: iv_rulePrologdsl= rulePrologdsl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrologdslRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrologdsl=rulePrologdsl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrologdsl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrologdsl"


    // $ANTLR start "rulePrologdsl"
    // InternalCustomProlog.g:107:1: rulePrologdsl returns [EObject current=null] : ( ( (lv_program_0_0= ruleProgram ) ) ( (lv_exquery_1_0= ruleExquery ) ) ) ;
    public final EObject rulePrologdsl() throws RecognitionException {
        EObject current = null;

        EObject lv_program_0_0 = null;

        EObject lv_exquery_1_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:113:2: ( ( ( (lv_program_0_0= ruleProgram ) ) ( (lv_exquery_1_0= ruleExquery ) ) ) )
            // InternalCustomProlog.g:114:2: ( ( (lv_program_0_0= ruleProgram ) ) ( (lv_exquery_1_0= ruleExquery ) ) )
            {
            // InternalCustomProlog.g:114:2: ( ( (lv_program_0_0= ruleProgram ) ) ( (lv_exquery_1_0= ruleExquery ) ) )
            // InternalCustomProlog.g:115:3: ( (lv_program_0_0= ruleProgram ) ) ( (lv_exquery_1_0= ruleExquery ) )
            {
            // InternalCustomProlog.g:115:3: ( (lv_program_0_0= ruleProgram ) )
            // InternalCustomProlog.g:116:4: (lv_program_0_0= ruleProgram )
            {
            // InternalCustomProlog.g:116:4: (lv_program_0_0= ruleProgram )
            // InternalCustomProlog.g:117:5: lv_program_0_0= ruleProgram
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrologdslAccess().getProgramProgramParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_program_0_0=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrologdslRule());
              					}
              					set(
              						current,
              						"program",
              						lv_program_0_0,
              						"de.htwdd.sf.beleg.CustomProlog.Program");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCustomProlog.g:134:3: ( (lv_exquery_1_0= ruleExquery ) )
            // InternalCustomProlog.g:135:4: (lv_exquery_1_0= ruleExquery )
            {
            // InternalCustomProlog.g:135:4: (lv_exquery_1_0= ruleExquery )
            // InternalCustomProlog.g:136:5: lv_exquery_1_0= ruleExquery
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrologdslAccess().getExqueryExqueryParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_exquery_1_0=ruleExquery();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrologdslRule());
              					}
              					set(
              						current,
              						"exquery",
              						lv_exquery_1_0,
              						"de.htwdd.sf.beleg.CustomProlog.Exquery");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrologdsl"


    // $ANTLR start "entryRuleProgram"
    // InternalCustomProlog.g:157:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalCustomProlog.g:157:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalCustomProlog.g:158:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalCustomProlog.g:164:1: ruleProgram returns [EObject current=null] : ( (lv_clauses_0_0= ruleClause ) )+ ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_clauses_0_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:170:2: ( ( (lv_clauses_0_0= ruleClause ) )+ )
            // InternalCustomProlog.g:171:2: ( (lv_clauses_0_0= ruleClause ) )+
            {
            // InternalCustomProlog.g:171:2: ( (lv_clauses_0_0= ruleClause ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_IDENT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCustomProlog.g:172:3: (lv_clauses_0_0= ruleClause )
            	    {
            	    // InternalCustomProlog.g:172:3: (lv_clauses_0_0= ruleClause )
            	    // InternalCustomProlog.g:173:4: lv_clauses_0_0= ruleClause
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getProgramAccess().getClausesClauseParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_clauses_0_0=ruleClause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getProgramRule());
            	      				}
            	      				add(
            	      					current,
            	      					"clauses",
            	      					lv_clauses_0_0,
            	      					"de.htwdd.sf.beleg.CustomProlog.Clause");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleExquery"
    // InternalCustomProlog.g:193:1: entryRuleExquery returns [EObject current=null] : iv_ruleExquery= ruleExquery EOF ;
    public final EObject entryRuleExquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExquery = null;


        try {
            // InternalCustomProlog.g:193:48: (iv_ruleExquery= ruleExquery EOF )
            // InternalCustomProlog.g:194:2: iv_ruleExquery= ruleExquery EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExqueryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExquery=ruleExquery();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExquery; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExquery"


    // $ANTLR start "ruleExquery"
    // InternalCustomProlog.g:200:1: ruleExquery returns [EObject current=null] : (otherlv_0= '?-' ( (lv_query_1_0= ruleQuery ) ) otherlv_2= '.' ) ;
    public final EObject ruleExquery() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_query_1_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:206:2: ( (otherlv_0= '?-' ( (lv_query_1_0= ruleQuery ) ) otherlv_2= '.' ) )
            // InternalCustomProlog.g:207:2: (otherlv_0= '?-' ( (lv_query_1_0= ruleQuery ) ) otherlv_2= '.' )
            {
            // InternalCustomProlog.g:207:2: (otherlv_0= '?-' ( (lv_query_1_0= ruleQuery ) ) otherlv_2= '.' )
            // InternalCustomProlog.g:208:3: otherlv_0= '?-' ( (lv_query_1_0= ruleQuery ) ) otherlv_2= '.'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExqueryAccess().getQuestionMarkHyphenMinusKeyword_0());
              		
            }
            // InternalCustomProlog.g:212:3: ( (lv_query_1_0= ruleQuery ) )
            // InternalCustomProlog.g:213:4: (lv_query_1_0= ruleQuery )
            {
            // InternalCustomProlog.g:213:4: (lv_query_1_0= ruleQuery )
            // InternalCustomProlog.g:214:5: lv_query_1_0= ruleQuery
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExqueryAccess().getQueryQueryParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_query_1_0=ruleQuery();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExqueryRule());
              					}
              					set(
              						current,
              						"query",
              						lv_query_1_0,
              						"de.htwdd.sf.beleg.CustomProlog.Query");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getExqueryAccess().getFullStopKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExquery"


    // $ANTLR start "entryRuleQuery"
    // InternalCustomProlog.g:239:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // InternalCustomProlog.g:239:46: (iv_ruleQuery= ruleQuery EOF )
            // InternalCustomProlog.g:240:2: iv_ruleQuery= ruleQuery EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQuery=ruleQuery();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQuery; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // InternalCustomProlog.g:246:1: ruleQuery returns [EObject current=null] : ( ( (lv_p_0_0= rulePredicate ) ) (otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) ) )* ) ;
    public final EObject ruleQuery() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_p_0_0 = null;

        EObject lv_p_2_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:252:2: ( ( ( (lv_p_0_0= rulePredicate ) ) (otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) ) )* ) )
            // InternalCustomProlog.g:253:2: ( ( (lv_p_0_0= rulePredicate ) ) (otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) ) )* )
            {
            // InternalCustomProlog.g:253:2: ( ( (lv_p_0_0= rulePredicate ) ) (otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) ) )* )
            // InternalCustomProlog.g:254:3: ( (lv_p_0_0= rulePredicate ) ) (otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) ) )*
            {
            // InternalCustomProlog.g:254:3: ( (lv_p_0_0= rulePredicate ) )
            // InternalCustomProlog.g:255:4: (lv_p_0_0= rulePredicate )
            {
            // InternalCustomProlog.g:255:4: (lv_p_0_0= rulePredicate )
            // InternalCustomProlog.g:256:5: lv_p_0_0= rulePredicate
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_p_0_0=rulePredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getQueryRule());
              					}
              					add(
              						current,
              						"p",
              						lv_p_0_0,
              						"de.htwdd.sf.beleg.CustomProlog.Predicate");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCustomProlog.g:273:3: (otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCustomProlog.g:274:4: otherlv_1= ',' ( (lv_p_2_0= rulePredicate ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getQueryAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCustomProlog.g:278:4: ( (lv_p_2_0= rulePredicate ) )
            	    // InternalCustomProlog.g:279:5: (lv_p_2_0= rulePredicate )
            	    {
            	    // InternalCustomProlog.g:279:5: (lv_p_2_0= rulePredicate )
            	    // InternalCustomProlog.g:280:6: lv_p_2_0= rulePredicate
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQueryAccess().getPPredicateParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_p_2_0=rulePredicate();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getQueryRule());
            	      						}
            	      						add(
            	      							current,
            	      							"p",
            	      							lv_p_2_0,
            	      							"de.htwdd.sf.beleg.CustomProlog.Predicate");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleClause"
    // InternalCustomProlog.g:302:1: entryRuleClause returns [EObject current=null] : iv_ruleClause= ruleClause EOF ;
    public final EObject entryRuleClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClause = null;


        try {
            // InternalCustomProlog.g:302:47: (iv_ruleClause= ruleClause EOF )
            // InternalCustomProlog.g:303:2: iv_ruleClause= ruleClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClause=ruleClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClause"


    // $ANTLR start "ruleClause"
    // InternalCustomProlog.g:309:1: ruleClause returns [EObject current=null] : ( ( ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact ) ) | ( (lv_rule_1_0= ruleRule ) ) ) ;
    public final EObject ruleClause() throws RecognitionException {
        EObject current = null;

        EObject lv_fact_0_0 = null;

        EObject lv_rule_1_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:315:2: ( ( ( ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact ) ) | ( (lv_rule_1_0= ruleRule ) ) ) )
            // InternalCustomProlog.g:316:2: ( ( ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact ) ) | ( (lv_rule_1_0= ruleRule ) ) )
            {
            // InternalCustomProlog.g:316:2: ( ( ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact ) ) | ( (lv_rule_1_0= ruleRule ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_IDENT) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred1_InternalCustomProlog()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalCustomProlog.g:317:3: ( ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact ) )
                    {
                    // InternalCustomProlog.g:317:3: ( ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact ) )
                    // InternalCustomProlog.g:318:4: ( ( ruleFact ) )=> (lv_fact_0_0= ruleFact )
                    {
                    // InternalCustomProlog.g:322:4: (lv_fact_0_0= ruleFact )
                    // InternalCustomProlog.g:323:5: lv_fact_0_0= ruleFact
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getClauseAccess().getFactFactParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_fact_0_0=ruleFact();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getClauseRule());
                      					}
                      					set(
                      						current,
                      						"fact",
                      						lv_fact_0_0,
                      						"de.htwdd.sf.beleg.CustomProlog.Fact");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:341:3: ( (lv_rule_1_0= ruleRule ) )
                    {
                    // InternalCustomProlog.g:341:3: ( (lv_rule_1_0= ruleRule ) )
                    // InternalCustomProlog.g:342:4: (lv_rule_1_0= ruleRule )
                    {
                    // InternalCustomProlog.g:342:4: (lv_rule_1_0= ruleRule )
                    // InternalCustomProlog.g:343:5: lv_rule_1_0= ruleRule
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getClauseAccess().getRuleRuleParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_rule_1_0=ruleRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getClauseRule());
                      					}
                      					set(
                      						current,
                      						"rule",
                      						lv_rule_1_0,
                      						"de.htwdd.sf.beleg.CustomProlog.Rule");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClause"


    // $ANTLR start "entryRuleFact"
    // InternalCustomProlog.g:364:1: entryRuleFact returns [EObject current=null] : iv_ruleFact= ruleFact EOF ;
    public final EObject entryRuleFact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFact = null;


        try {
            // InternalCustomProlog.g:364:45: (iv_ruleFact= ruleFact EOF )
            // InternalCustomProlog.g:365:2: iv_ruleFact= ruleFact EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFactRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFact=ruleFact();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFact; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFact"


    // $ANTLR start "ruleFact"
    // InternalCustomProlog.g:371:1: ruleFact returns [EObject current=null] : ( ( (lv_predicate_0_0= rulePredicate ) ) otherlv_1= '.' ) ;
    public final EObject ruleFact() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_predicate_0_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:377:2: ( ( ( (lv_predicate_0_0= rulePredicate ) ) otherlv_1= '.' ) )
            // InternalCustomProlog.g:378:2: ( ( (lv_predicate_0_0= rulePredicate ) ) otherlv_1= '.' )
            {
            // InternalCustomProlog.g:378:2: ( ( (lv_predicate_0_0= rulePredicate ) ) otherlv_1= '.' )
            // InternalCustomProlog.g:379:3: ( (lv_predicate_0_0= rulePredicate ) ) otherlv_1= '.'
            {
            // InternalCustomProlog.g:379:3: ( (lv_predicate_0_0= rulePredicate ) )
            // InternalCustomProlog.g:380:4: (lv_predicate_0_0= rulePredicate )
            {
            // InternalCustomProlog.g:380:4: (lv_predicate_0_0= rulePredicate )
            // InternalCustomProlog.g:381:5: lv_predicate_0_0= rulePredicate
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFactAccess().getPredicatePredicateParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_predicate_0_0=rulePredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFactRule());
              					}
              					set(
              						current,
              						"predicate",
              						lv_predicate_0_0,
              						"de.htwdd.sf.beleg.CustomProlog.Predicate");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFactAccess().getFullStopKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFact"


    // $ANTLR start "entryRuleRule"
    // InternalCustomProlog.g:406:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalCustomProlog.g:406:45: (iv_ruleRule= ruleRule EOF )
            // InternalCustomProlog.g:407:2: iv_ruleRule= ruleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalCustomProlog.g:413:1: ruleRule returns [EObject current=null] : ( ( (lv_rule_0_0= rulePredicate ) ) otherlv_1= ':-' ( (lv_query_2_0= ruleQuery ) ) otherlv_3= '.' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_rule_0_0 = null;

        EObject lv_query_2_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:419:2: ( ( ( (lv_rule_0_0= rulePredicate ) ) otherlv_1= ':-' ( (lv_query_2_0= ruleQuery ) ) otherlv_3= '.' ) )
            // InternalCustomProlog.g:420:2: ( ( (lv_rule_0_0= rulePredicate ) ) otherlv_1= ':-' ( (lv_query_2_0= ruleQuery ) ) otherlv_3= '.' )
            {
            // InternalCustomProlog.g:420:2: ( ( (lv_rule_0_0= rulePredicate ) ) otherlv_1= ':-' ( (lv_query_2_0= ruleQuery ) ) otherlv_3= '.' )
            // InternalCustomProlog.g:421:3: ( (lv_rule_0_0= rulePredicate ) ) otherlv_1= ':-' ( (lv_query_2_0= ruleQuery ) ) otherlv_3= '.'
            {
            // InternalCustomProlog.g:421:3: ( (lv_rule_0_0= rulePredicate ) )
            // InternalCustomProlog.g:422:4: (lv_rule_0_0= rulePredicate )
            {
            // InternalCustomProlog.g:422:4: (lv_rule_0_0= rulePredicate )
            // InternalCustomProlog.g:423:5: lv_rule_0_0= rulePredicate
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleAccess().getRulePredicateParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_rule_0_0=rulePredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRuleRule());
              					}
              					set(
              						current,
              						"rule",
              						lv_rule_0_0,
              						"de.htwdd.sf.beleg.CustomProlog.Predicate");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getColonHyphenMinusKeyword_1());
              		
            }
            // InternalCustomProlog.g:444:3: ( (lv_query_2_0= ruleQuery ) )
            // InternalCustomProlog.g:445:4: (lv_query_2_0= ruleQuery )
            {
            // InternalCustomProlog.g:445:4: (lv_query_2_0= ruleQuery )
            // InternalCustomProlog.g:446:5: lv_query_2_0= ruleQuery
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleAccess().getQueryQueryParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_query_2_0=ruleQuery();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRuleRule());
              					}
              					set(
              						current,
              						"query",
              						lv_query_2_0,
              						"de.htwdd.sf.beleg.CustomProlog.Query");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getFullStopKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRulePredicate"
    // InternalCustomProlog.g:471:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalCustomProlog.g:471:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalCustomProlog.g:472:2: iv_rulePredicate= rulePredicate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalCustomProlog.g:478:1: rulePredicate returns [EObject current=null] : ( ( (lv_functor_0_0= ruleFunctor ) ) otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) (otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) ) )* otherlv_5= ')' ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_functor_0_0 = null;

        EObject lv_term_2_0 = null;

        EObject lv_term_4_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:484:2: ( ( ( (lv_functor_0_0= ruleFunctor ) ) otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) (otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) ) )* otherlv_5= ')' ) )
            // InternalCustomProlog.g:485:2: ( ( (lv_functor_0_0= ruleFunctor ) ) otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) (otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) ) )* otherlv_5= ')' )
            {
            // InternalCustomProlog.g:485:2: ( ( (lv_functor_0_0= ruleFunctor ) ) otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) (otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) ) )* otherlv_5= ')' )
            // InternalCustomProlog.g:486:3: ( (lv_functor_0_0= ruleFunctor ) ) otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) (otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) ) )* otherlv_5= ')'
            {
            // InternalCustomProlog.g:486:3: ( (lv_functor_0_0= ruleFunctor ) )
            // InternalCustomProlog.g:487:4: (lv_functor_0_0= ruleFunctor )
            {
            // InternalCustomProlog.g:487:4: (lv_functor_0_0= ruleFunctor )
            // InternalCustomProlog.g:488:5: lv_functor_0_0= ruleFunctor
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredicateAccess().getFunctorFunctorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_functor_0_0=ruleFunctor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPredicateRule());
              					}
              					set(
              						current,
              						"functor",
              						lv_functor_0_0,
              						"de.htwdd.sf.beleg.CustomProlog.Functor");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCustomProlog.g:509:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalCustomProlog.g:510:4: (lv_term_2_0= ruleTerm )
            {
            // InternalCustomProlog.g:510:4: (lv_term_2_0= ruleTerm )
            // InternalCustomProlog.g:511:5: lv_term_2_0= ruleTerm
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_term_2_0=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPredicateRule());
              					}
              					add(
              						current,
              						"term",
              						lv_term_2_0,
              						"de.htwdd.sf.beleg.CustomProlog.Term");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCustomProlog.g:528:3: (otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCustomProlog.g:529:4: otherlv_3= ',' ( (lv_term_4_0= ruleTerm ) )
            	    {
            	    otherlv_3=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getPredicateAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalCustomProlog.g:533:4: ( (lv_term_4_0= ruleTerm ) )
            	    // InternalCustomProlog.g:534:5: (lv_term_4_0= ruleTerm )
            	    {
            	    // InternalCustomProlog.g:534:5: (lv_term_4_0= ruleTerm )
            	    // InternalCustomProlog.g:535:6: lv_term_4_0= ruleTerm
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPredicateAccess().getTermTermParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_term_4_0=ruleTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPredicateRule());
            	      						}
            	      						add(
            	      							current,
            	      							"term",
            	      							lv_term_4_0,
            	      							"de.htwdd.sf.beleg.CustomProlog.Term");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPredicateAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleFunctor"
    // InternalCustomProlog.g:561:1: entryRuleFunctor returns [EObject current=null] : iv_ruleFunctor= ruleFunctor EOF ;
    public final EObject entryRuleFunctor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctor = null;


        try {
            // InternalCustomProlog.g:561:48: (iv_ruleFunctor= ruleFunctor EOF )
            // InternalCustomProlog.g:562:2: iv_ruleFunctor= ruleFunctor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctor=ruleFunctor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctor"


    // $ANTLR start "ruleFunctor"
    // InternalCustomProlog.g:568:1: ruleFunctor returns [EObject current=null] : ( (lv_funcName_0_0= RULE_IDENT ) ) ;
    public final EObject ruleFunctor() throws RecognitionException {
        EObject current = null;

        Token lv_funcName_0_0=null;


        	enterRule();

        try {
            // InternalCustomProlog.g:574:2: ( ( (lv_funcName_0_0= RULE_IDENT ) ) )
            // InternalCustomProlog.g:575:2: ( (lv_funcName_0_0= RULE_IDENT ) )
            {
            // InternalCustomProlog.g:575:2: ( (lv_funcName_0_0= RULE_IDENT ) )
            // InternalCustomProlog.g:576:3: (lv_funcName_0_0= RULE_IDENT )
            {
            // InternalCustomProlog.g:576:3: (lv_funcName_0_0= RULE_IDENT )
            // InternalCustomProlog.g:577:4: lv_funcName_0_0= RULE_IDENT
            {
            lv_funcName_0_0=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_funcName_0_0, grammarAccess.getFunctorAccess().getFuncNameIDENTTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getFunctorRule());
              				}
              				setWithLastConsumed(
              					current,
              					"funcName",
              					lv_funcName_0_0,
              					"de.htwdd.sf.beleg.CustomProlog.IDENT");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctor"


    // $ANTLR start "entryRuleTerm"
    // InternalCustomProlog.g:596:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalCustomProlog.g:596:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalCustomProlog.g:597:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalCustomProlog.g:603:1: ruleTerm returns [EObject current=null] : ( ( (lv_atom_0_0= ruleAtom ) ) | ( (lv_list_1_0= ruleList ) ) ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_atom_0_0 = null;

        EObject lv_list_1_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:609:2: ( ( ( (lv_atom_0_0= ruleAtom ) ) | ( (lv_list_1_0= ruleList ) ) ) )
            // InternalCustomProlog.g:610:2: ( ( (lv_atom_0_0= ruleAtom ) ) | ( (lv_list_1_0= ruleList ) ) )
            {
            // InternalCustomProlog.g:610:2: ( ( (lv_atom_0_0= ruleAtom ) ) | ( (lv_list_1_0= ruleList ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_IDENT && LA6_0<=RULE_VARIABLE)) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=20 && LA6_0<=21)) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalCustomProlog.g:611:3: ( (lv_atom_0_0= ruleAtom ) )
                    {
                    // InternalCustomProlog.g:611:3: ( (lv_atom_0_0= ruleAtom ) )
                    // InternalCustomProlog.g:612:4: (lv_atom_0_0= ruleAtom )
                    {
                    // InternalCustomProlog.g:612:4: (lv_atom_0_0= ruleAtom )
                    // InternalCustomProlog.g:613:5: lv_atom_0_0= ruleAtom
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTermAccess().getAtomAtomParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_atom_0_0=ruleAtom();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTermRule());
                      					}
                      					set(
                      						current,
                      						"atom",
                      						lv_atom_0_0,
                      						"de.htwdd.sf.beleg.CustomProlog.Atom");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:631:3: ( (lv_list_1_0= ruleList ) )
                    {
                    // InternalCustomProlog.g:631:3: ( (lv_list_1_0= ruleList ) )
                    // InternalCustomProlog.g:632:4: (lv_list_1_0= ruleList )
                    {
                    // InternalCustomProlog.g:632:4: (lv_list_1_0= ruleList )
                    // InternalCustomProlog.g:633:5: lv_list_1_0= ruleList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTermAccess().getListListParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_list_1_0=ruleList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTermRule());
                      					}
                      					set(
                      						current,
                      						"list",
                      						lv_list_1_0,
                      						"de.htwdd.sf.beleg.CustomProlog.List");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // InternalCustomProlog.g:654:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalCustomProlog.g:654:45: (iv_ruleAtom= ruleAtom EOF )
            // InternalCustomProlog.g:655:2: iv_ruleAtom= ruleAtom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtom; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalCustomProlog.g:661:1: ruleAtom returns [EObject current=null] : ( ( (lv_ident_0_0= RULE_IDENT ) ) | ( (lv_ident_1_0= RULE_NUMBER ) ) | ( (lv_ident_2_0= RULE_VARIABLE ) ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_ident_0_0=null;
        Token lv_ident_1_0=null;
        Token lv_ident_2_0=null;


        	enterRule();

        try {
            // InternalCustomProlog.g:667:2: ( ( ( (lv_ident_0_0= RULE_IDENT ) ) | ( (lv_ident_1_0= RULE_NUMBER ) ) | ( (lv_ident_2_0= RULE_VARIABLE ) ) ) )
            // InternalCustomProlog.g:668:2: ( ( (lv_ident_0_0= RULE_IDENT ) ) | ( (lv_ident_1_0= RULE_NUMBER ) ) | ( (lv_ident_2_0= RULE_VARIABLE ) ) )
            {
            // InternalCustomProlog.g:668:2: ( ( (lv_ident_0_0= RULE_IDENT ) ) | ( (lv_ident_1_0= RULE_NUMBER ) ) | ( (lv_ident_2_0= RULE_VARIABLE ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_IDENT:
                {
                alt7=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt7=2;
                }
                break;
            case RULE_VARIABLE:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalCustomProlog.g:669:3: ( (lv_ident_0_0= RULE_IDENT ) )
                    {
                    // InternalCustomProlog.g:669:3: ( (lv_ident_0_0= RULE_IDENT ) )
                    // InternalCustomProlog.g:670:4: (lv_ident_0_0= RULE_IDENT )
                    {
                    // InternalCustomProlog.g:670:4: (lv_ident_0_0= RULE_IDENT )
                    // InternalCustomProlog.g:671:5: lv_ident_0_0= RULE_IDENT
                    {
                    lv_ident_0_0=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_ident_0_0, grammarAccess.getAtomAccess().getIdentIDENTTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getAtomRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"ident",
                      						lv_ident_0_0,
                      						"de.htwdd.sf.beleg.CustomProlog.IDENT");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:688:3: ( (lv_ident_1_0= RULE_NUMBER ) )
                    {
                    // InternalCustomProlog.g:688:3: ( (lv_ident_1_0= RULE_NUMBER ) )
                    // InternalCustomProlog.g:689:4: (lv_ident_1_0= RULE_NUMBER )
                    {
                    // InternalCustomProlog.g:689:4: (lv_ident_1_0= RULE_NUMBER )
                    // InternalCustomProlog.g:690:5: lv_ident_1_0= RULE_NUMBER
                    {
                    lv_ident_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_ident_1_0, grammarAccess.getAtomAccess().getIdentNUMBERTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getAtomRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"ident",
                      						lv_ident_1_0,
                      						"de.htwdd.sf.beleg.CustomProlog.NUMBER");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCustomProlog.g:707:3: ( (lv_ident_2_0= RULE_VARIABLE ) )
                    {
                    // InternalCustomProlog.g:707:3: ( (lv_ident_2_0= RULE_VARIABLE ) )
                    // InternalCustomProlog.g:708:4: (lv_ident_2_0= RULE_VARIABLE )
                    {
                    // InternalCustomProlog.g:708:4: (lv_ident_2_0= RULE_VARIABLE )
                    // InternalCustomProlog.g:709:5: lv_ident_2_0= RULE_VARIABLE
                    {
                    lv_ident_2_0=(Token)match(input,RULE_VARIABLE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_ident_2_0, grammarAccess.getAtomAccess().getIdentVARIABLETerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getAtomRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"ident",
                      						lv_ident_2_0,
                      						"de.htwdd.sf.beleg.CustomProlog.VARIABLE");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleList"
    // InternalCustomProlog.g:729:1: entryRuleList returns [EObject current=null] : iv_ruleList= ruleList EOF ;
    public final EObject entryRuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList = null;


        try {
            // InternalCustomProlog.g:729:45: (iv_ruleList= ruleList EOF )
            // InternalCustomProlog.g:730:2: iv_ruleList= ruleList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleList=ruleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList"


    // $ANTLR start "ruleList"
    // InternalCustomProlog.g:736:1: ruleList returns [EObject current=null] : ( ( () otherlv_1= '[]' ) | ( (lv_nonempty_2_0= ruleNonEmptyList ) ) ) ;
    public final EObject ruleList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_nonempty_2_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:742:2: ( ( ( () otherlv_1= '[]' ) | ( (lv_nonempty_2_0= ruleNonEmptyList ) ) ) )
            // InternalCustomProlog.g:743:2: ( ( () otherlv_1= '[]' ) | ( (lv_nonempty_2_0= ruleNonEmptyList ) ) )
            {
            // InternalCustomProlog.g:743:2: ( ( () otherlv_1= '[]' ) | ( (lv_nonempty_2_0= ruleNonEmptyList ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalCustomProlog.g:744:3: ( () otherlv_1= '[]' )
                    {
                    // InternalCustomProlog.g:744:3: ( () otherlv_1= '[]' )
                    // InternalCustomProlog.g:745:4: () otherlv_1= '[]'
                    {
                    // InternalCustomProlog.g:745:4: ()
                    // InternalCustomProlog.g:746:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getListAccess().getListAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getListAccess().getLeftSquareBracketRightSquareBracketKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:758:3: ( (lv_nonempty_2_0= ruleNonEmptyList ) )
                    {
                    // InternalCustomProlog.g:758:3: ( (lv_nonempty_2_0= ruleNonEmptyList ) )
                    // InternalCustomProlog.g:759:4: (lv_nonempty_2_0= ruleNonEmptyList )
                    {
                    // InternalCustomProlog.g:759:4: (lv_nonempty_2_0= ruleNonEmptyList )
                    // InternalCustomProlog.g:760:5: lv_nonempty_2_0= ruleNonEmptyList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getListAccess().getNonemptyNonEmptyListParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_nonempty_2_0=ruleNonEmptyList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getListRule());
                      					}
                      					set(
                      						current,
                      						"nonempty",
                      						lv_nonempty_2_0,
                      						"de.htwdd.sf.beleg.CustomProlog.NonEmptyList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList"


    // $ANTLR start "entryRuleNonEmptyList"
    // InternalCustomProlog.g:781:1: entryRuleNonEmptyList returns [EObject current=null] : iv_ruleNonEmptyList= ruleNonEmptyList EOF ;
    public final EObject entryRuleNonEmptyList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonEmptyList = null;


        try {
            // InternalCustomProlog.g:781:53: (iv_ruleNonEmptyList= ruleNonEmptyList EOF )
            // InternalCustomProlog.g:782:2: iv_ruleNonEmptyList= ruleNonEmptyList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNonEmptyListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNonEmptyList=ruleNonEmptyList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNonEmptyList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonEmptyList"


    // $ANTLR start "ruleNonEmptyList"
    // InternalCustomProlog.g:788:1: ruleNonEmptyList returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']' ) | (otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']' ) ) ;
    public final EObject ruleNonEmptyList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_folge_1_0 = null;

        EObject lv_atom_4_0 = null;

        EObject lv_term_6_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:794:2: ( ( (otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']' ) | (otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']' ) ) )
            // InternalCustomProlog.g:795:2: ( (otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']' ) | (otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']' ) )
            {
            // InternalCustomProlog.g:795:2: ( (otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']' ) | (otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                switch ( input.LA(2) ) {
                case RULE_IDENT:
                    {
                    int LA9_2 = input.LA(3);

                    if ( (LA9_2==23) ) {
                        alt9=2;
                    }
                    else if ( (LA9_2==16||LA9_2==22) ) {
                        alt9=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_NUMBER:
                    {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==16||LA9_3==22) ) {
                        alt9=1;
                    }
                    else if ( (LA9_3==23) ) {
                        alt9=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_VARIABLE:
                    {
                    int LA9_4 = input.LA(3);

                    if ( (LA9_4==23) ) {
                        alt9=2;
                    }
                    else if ( (LA9_4==16||LA9_4==22) ) {
                        alt9=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalCustomProlog.g:796:3: (otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']' )
                    {
                    // InternalCustomProlog.g:796:3: (otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']' )
                    // InternalCustomProlog.g:797:4: otherlv_0= '[' ( (lv_folge_1_0= ruleFolge ) ) otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    // InternalCustomProlog.g:801:4: ( (lv_folge_1_0= ruleFolge ) )
                    // InternalCustomProlog.g:802:5: (lv_folge_1_0= ruleFolge )
                    {
                    // InternalCustomProlog.g:802:5: (lv_folge_1_0= ruleFolge )
                    // InternalCustomProlog.g:803:6: lv_folge_1_0= ruleFolge
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonEmptyListAccess().getFolgeFolgeParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_folge_1_0=ruleFolge();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonEmptyListRule());
                      						}
                      						set(
                      							current,
                      							"folge",
                      							lv_folge_1_0,
                      							"de.htwdd.sf.beleg.CustomProlog.Folge");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCustomProlog.g:826:3: (otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']' )
                    {
                    // InternalCustomProlog.g:826:3: (otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']' )
                    // InternalCustomProlog.g:827:4: otherlv_3= '[' ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) ) otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getNonEmptyListAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalCustomProlog.g:831:4: ( ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) ) )
                    // InternalCustomProlog.g:832:5: ( (lv_atom_4_0= ruleAtom ) ) otherlv_5= '|' ( (lv_term_6_0= ruleTerm ) )
                    {
                    // InternalCustomProlog.g:832:5: ( (lv_atom_4_0= ruleAtom ) )
                    // InternalCustomProlog.g:833:6: (lv_atom_4_0= ruleAtom )
                    {
                    // InternalCustomProlog.g:833:6: (lv_atom_4_0= ruleAtom )
                    // InternalCustomProlog.g:834:7: lv_atom_4_0= ruleAtom
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getNonEmptyListAccess().getAtomAtomParserRuleCall_1_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_14);
                    lv_atom_4_0=ruleAtom();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getNonEmptyListRule());
                      							}
                      							set(
                      								current,
                      								"atom",
                      								lv_atom_4_0,
                      								"de.htwdd.sf.beleg.CustomProlog.Atom");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getNonEmptyListAccess().getVerticalLineKeyword_1_1_1());
                      				
                    }
                    // InternalCustomProlog.g:855:5: ( (lv_term_6_0= ruleTerm ) )
                    // InternalCustomProlog.g:856:6: (lv_term_6_0= ruleTerm )
                    {
                    // InternalCustomProlog.g:856:6: (lv_term_6_0= ruleTerm )
                    // InternalCustomProlog.g:857:7: lv_term_6_0= ruleTerm
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getNonEmptyListAccess().getTermTermParserRuleCall_1_1_2_0());
                      						
                    }
                    pushFollow(FOLLOW_13);
                    lv_term_6_0=ruleTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getNonEmptyListRule());
                      							}
                      							set(
                      								current,
                      								"term",
                      								lv_term_6_0,
                      								"de.htwdd.sf.beleg.CustomProlog.Term");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }

                    otherlv_7=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getNonEmptyListAccess().getRightSquareBracketKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonEmptyList"


    // $ANTLR start "entryRuleFolge"
    // InternalCustomProlog.g:884:1: entryRuleFolge returns [EObject current=null] : iv_ruleFolge= ruleFolge EOF ;
    public final EObject entryRuleFolge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFolge = null;


        try {
            // InternalCustomProlog.g:884:46: (iv_ruleFolge= ruleFolge EOF )
            // InternalCustomProlog.g:885:2: iv_ruleFolge= ruleFolge EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFolgeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFolge=ruleFolge();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFolge; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFolge"


    // $ANTLR start "ruleFolge"
    // InternalCustomProlog.g:891:1: ruleFolge returns [EObject current=null] : ( ( (lv_atom_0_0= ruleAtom ) ) (otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) ) )* ) ;
    public final EObject ruleFolge() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_atom_0_0 = null;

        EObject lv_atom_2_0 = null;



        	enterRule();

        try {
            // InternalCustomProlog.g:897:2: ( ( ( (lv_atom_0_0= ruleAtom ) ) (otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) ) )* ) )
            // InternalCustomProlog.g:898:2: ( ( (lv_atom_0_0= ruleAtom ) ) (otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) ) )* )
            {
            // InternalCustomProlog.g:898:2: ( ( (lv_atom_0_0= ruleAtom ) ) (otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) ) )* )
            // InternalCustomProlog.g:899:3: ( (lv_atom_0_0= ruleAtom ) ) (otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) ) )*
            {
            // InternalCustomProlog.g:899:3: ( (lv_atom_0_0= ruleAtom ) )
            // InternalCustomProlog.g:900:4: (lv_atom_0_0= ruleAtom )
            {
            // InternalCustomProlog.g:900:4: (lv_atom_0_0= ruleAtom )
            // InternalCustomProlog.g:901:5: lv_atom_0_0= ruleAtom
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_atom_0_0=ruleAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFolgeRule());
              					}
              					add(
              						current,
              						"atom",
              						lv_atom_0_0,
              						"de.htwdd.sf.beleg.CustomProlog.Atom");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCustomProlog.g:918:3: (otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCustomProlog.g:919:4: otherlv_1= ',' ( (lv_atom_2_0= ruleAtom ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getFolgeAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCustomProlog.g:923:4: ( (lv_atom_2_0= ruleAtom ) )
            	    // InternalCustomProlog.g:924:5: (lv_atom_2_0= ruleAtom )
            	    {
            	    // InternalCustomProlog.g:924:5: (lv_atom_2_0= ruleAtom )
            	    // InternalCustomProlog.g:925:6: lv_atom_2_0= ruleAtom
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFolgeAccess().getAtomAtomParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_atom_2_0=ruleAtom();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFolgeRule());
            	      						}
            	      						add(
            	      							current,
            	      							"atom",
            	      							lv_atom_2_0,
            	      							"de.htwdd.sf.beleg.CustomProlog.Atom");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFolge"

    // $ANTLR start synpred1_InternalCustomProlog
    public final void synpred1_InternalCustomProlog_fragment() throws RecognitionException {   
        // InternalCustomProlog.g:318:4: ( ( ruleFact ) )
        // InternalCustomProlog.g:318:5: ( ruleFact )
        {
        // InternalCustomProlog.g:318:5: ( ruleFact )
        // InternalCustomProlog.g:319:5: ruleFact
        {
        pushFollow(FOLLOW_2);
        ruleFact();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalCustomProlog

    // Delegated rules

    public final boolean synpred1_InternalCustomProlog() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalCustomProlog_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000300070L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});

}