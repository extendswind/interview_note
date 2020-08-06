package codingInterviews;

import org.junit.Assert;


public class _14CutRope {

    // 2<=n<=60
    // 自底向上
    public int cutRope(int target) {
        int[] f = new int[target + 1];
        f[2] = 2;
        if(target>=3)
            f[3] = 3;
        for(int i=5; i<=target; i++){
            int max = -1;
            for(int j=2; j<=i/2; j++){
                int fi = f[j] * f[i-j];
                if(fi > max){
                    max = fi;
                }
            }
            f[i] = max;
        }
        return f[target];
    }


    public static void main(String[] argvs){
        _14CutRope s = new _14CutRope();
        Assert.assertEquals(s.cutRope(2), 2);
        Assert.assertEquals(s.cutRope(5), 6);
        Assert.assertEquals(s.cutRope(9), 27);


    }
}
