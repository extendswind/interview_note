package codingInterviews;

import org.junit.Assert;


public class _15Count1InBinary {

    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            if((1 & n) == 1)
                count++;
            System.out.println(Integer.toBinaryString(n));
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] argvs){
        _15Count1InBinary s = new _15Count1InBinary();
        Assert.assertEquals(1, s.NumberOf1(1));
        Assert.assertEquals(1, s.NumberOf1(2));
        Assert.assertEquals(32, s.NumberOf1(-1));


    }
}
