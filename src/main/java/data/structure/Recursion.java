package data.structure;

/**
 * Created by pei on 2017/3/9.
 */
public class Recursion {
    private void permute(char[] str, int low, int high){

    }

    public void permute(String str){
    }

    static void permute(int level, String permuted,
                        boolean used[], String original) {
        int length = original.length();
        if (level == length) {
            System.out.println(permuted);
        } else {
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permute(level + 1, permuted + original.charAt(i),
                            used, original);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        boolean used[] = {false, false, false, false, false};
        permute(0, "", used, s);
    }
}
