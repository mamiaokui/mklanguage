// we have 3 types of token, Identifier, number, string.
//Identifier: > < { } while if
//number: 123
//string: "abc"

public abstract class Token {
	private int mLineNumber;
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
}
