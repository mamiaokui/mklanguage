// we have 3 types of token, Identifier, number, string.
//Identifier: > < { } while if
//number: 123
//string: "abc"

public class Token {
	private int mLineNumber;
	private int mFlag  = 0;
	public static final int EOF = 1;
	protected Token(int lineNumber) {
		mLineNumber = lineNumber;
	}
	
	public int getLineNumber() {
	    return mLineNumber;
	}
	
	public boolean isIdentifier() {
	    return false;
	}
	
	public boolean isNumber() {
	        return false;
	 }
	
	public boolean isString() {
            return false;
        }
	
	public String getIdentifier() {
	    return "";
	}
	
	public int getNumber() {
	    return 0;
	}
	
	public String getString() {
	    return "";
	}
	
	public String getCommonValue() {
	    return "";
	}
	
	public void setFlag(int flag) {
	    mFlag |= flag;
	}
	
	public int getFlag() {
	    return mFlag;
	}
} 
