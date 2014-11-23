
public class NumToken extends Token{
    private int mNumber;
    protected NumToken(int line, int value) {
        super(line);
        mNumber = value;
    }
    
    @Override
    public boolean isNumber() {
        return true;
    }
    
    @Override
    public int getNumber() {
        return mNumber;
    }
}
