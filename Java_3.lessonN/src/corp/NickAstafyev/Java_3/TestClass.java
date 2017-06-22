package corp.NickAstafyev.Java_3;

public class TestClass {
    private int N;

    public long getN() {
        return N;
    }

    public void setN(int n) {
        if (n <= 0) n = 1;
        N = n;
    }

}
