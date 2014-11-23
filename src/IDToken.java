
public class IDToken extends Token {
    private String mString;
    protected IDToken(int line, String id) {
        super(line);
        mString = id;
    }
    
    @Override
    public boolean isIdentifier() {
        return true;
    }
    
    @Override
    public String getIdentifier() {
        return mString;
    }
}
