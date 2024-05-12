import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {

    public int solution(String S) {
        // Implement your solution here

   return  0;
    }

    public static void main(String[] args) {
        System.out.println(solution2("world"));
        System.out.println(solution2("cycle"));
    }

    public static int solution2(String s) {
        int ans = 1;
        int[] aux = new int[26];
        Arrays.fill(aux, 0);
        for (char i : s.toCharArray()) {
            if (aux[i - 'a'] == 1) {
                ans++;
                Arrays.fill(aux, 0);
            }
            aux[i - 'a']++;
        }
        return ans;
    }


    int []min = new int [1];

    private void dfs(String s, int index, List<String> subStrings) {
        if (index == s.length()) {
            min[0] = Math.min(subStrings.size(), min[0]);
            return ;
        }
        for (int j = index; j < s.length(); j++) {
            String subStr = s.substring(index, j + 1);
            if(checkUniqueString(subStr)){
                subStrings.add(subStr);
                dfs(s, index, subStrings);
            }
        }

    }
    private boolean checkUniqueString(String str){
        int[] chars = new int[26];
        for(char ch :  str.toCharArray()){
             chars[ch - 'a']++;
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] > 1){
                return false;
            }
        }
        return true;
    }



    public static int splitString(String s) {
        List<String> result = new ArrayList<>();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            i = Math.max(i, last[s.charAt(j) - 'a'] + 1);
            last[s.charAt(j) - 'a'] = j;
            if (i == j) {
                result.add(s.substring(i, j + 1));
            }
        }
        return result.size();
    }
}
