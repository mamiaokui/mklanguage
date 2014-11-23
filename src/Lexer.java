import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {

    private ArrayList<Token> mQueue = new ArrayList<Token>();
    private LineNumberReader mReader;
    
    public static String regexPat  = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"  + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
    
    private Pattern pattern = Pattern.compile(regexPat);
    
    public Lexer(Reader reader) {
        mReader = new LineNumberReader(reader);
    }
    
    public void ensureQueueFilled() {
        String line = null;
        try {
            line = mReader.readLine();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        if (line == null) {
            Token t = createTokenWithFlag(Token.EOF);
            mQueue.add(t);
            return;
        }
        
        int lineNo = mReader.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useAnchoringBounds(false);
        int pos = 0;
        int endPos = line.length();
        while(pos < endPos) {
            matcher.region(pos, endPos);
            if (matcher.lookingAt()) {
                addToken(lineNo, matcher);
                pos = matcher.end();
            }
            else {
                System.out.print("error");
            }
        }
        
    }

    public Token read() {
         ensureQueueFilled();
         return mQueue.remove(0);
    }
    
    public Token createTokenWithFlag(int flag) {
        Token t = new Token(-1);
        t.setFlag(flag);
        return t;
    }
    
    public  void addToken(int lineNumber, Matcher matcher) {
        String m = matcher.group(1); //if not a space
        if (m != null) {
            if (matcher.group(2) == null) { //if not a comment
                Token token;
                if (matcher.group(3) != null)
                    token = new NumToken(lineNumber, Integer.parseInt(m));
                else if (matcher.group(4) != null)
                    token = new StrToken(lineNumber, m);
                else
                        token = new IDToken(lineNumber, m);
                mQueue.add(token);
            }
        }
    }
    
    public static void main(String [] args) throws FileNotFoundException {
        Lexer l = new Lexer(new BufferedReader(new FileReader("/tmp/sample.mmk")));
        Token t;
        while (true) {
            t = l.read();
            if ((t.getFlag() & Token.EOF) != 0) {
                break;
            }
            
            System.out.println(t.getCommonValue());
               
        }
    }
}
