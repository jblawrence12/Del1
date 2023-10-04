package CommentPackage;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class CommentCountCheck extends AbstractCheck {
    private static final String CATCH_MSG = "Comment counts: ";
    
    //count for operator
    private int commentCount = 0;

    @Override
    public int[] getDefaultTokens() {
        // token types that contain comments
        return new int[] {
            TokenTypes.SINGLE_LINE_COMMENT
        };
    }
    // add to count
    @Override
    public void visitToken(DetailAST ast) {
        commentCount++;
    }
    
    public boolean isCommentNodesRequired() {
        return true;
    }
    
    @Override
    public void beginTree(DetailAST ast) {
        commentCount = 0;
    }
    
    @Override
    public void finishTree(DetailAST ast) {
        log(ast.getLineNo(), CATCH_MSG + commentCount);
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

	