
public class StrToken extends Token{
    private String mString;
    protected StrToken(int line, String id) {
        super(line);
        mString = id;
    }
    
    @Override
    public boolean isString() {
        return true;
    }
    
    @Override
    public String getString() {
        return mString;
    }
}
