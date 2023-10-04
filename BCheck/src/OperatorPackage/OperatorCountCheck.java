package OperatorPackage;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class OperatorCountCheck extends AbstractCheck {
    private static final String CATCH_MSG = "Operator counts: ";
    
    //count for operator
    private int operatorCount = 0;

    @Override
    public int[] getDefaultTokens() {
        // token types that contain operators
        return new int[] {
            TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.STAR, TokenTypes.DIV,
            TokenTypes.MOD, TokenTypes.BAND, TokenTypes.BOR, TokenTypes.BXOR,
            TokenTypes.EQUAL, TokenTypes.NOT_EQUAL, TokenTypes.LT, TokenTypes.GT,
            TokenTypes.LITERAL_FALSE, TokenTypes.BNOT, TokenTypes.QUESTION
        };
    }
    // add to count
    @Override
    public void visitToken(DetailAST ast) {
        operatorCount++;
    }

    @Override
    public void beginTree(DetailAST ast) {
        operatorCount = 0;
    }
    
    @Override
    public void finishTree(DetailAST ast) {
        log(ast.getLineNo(), CATCH_MSG + operatorCount);
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {

        return getDefaultTokens();
    }
}

	