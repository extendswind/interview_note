package codingInterviews;

import org.junit.Assert;

public class _5ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if(str == null)
            return null;
        int oldLength = str.length();
        int newLength = oldLength;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                newLength += 2;
            }
        }
        str.setLength(newLength);
        for(int i=oldLength-1, j=newLength-1; i>=0; i--, j--){
            if(str.charAt(i) == ' '){
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j, '%');
            } else {
                str.setCharAt(j, str.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] argvs){
        _5ReplaceSpace s = new _5ReplaceSpace();
        String result = s.replaceSpace(new StringBuffer("aa bb cc"));
        Assert.assertEquals(result, "aa%20bb%20cc");
    }
}
