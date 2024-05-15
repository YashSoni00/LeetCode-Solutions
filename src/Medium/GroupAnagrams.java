package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        int len = strs.length;
        for (int i=0; i<len; i++) {
            // Skip if J is equal to null
            if (strs[i] == null) continue;

            List<String> curr = new ArrayList<>();
            char[] iCurr = strs[i].toCharArray();
            Arrays.sort(iCurr);
            curr.add(strs[i]);
            strs[i] = null;

            for (int j=i+1; j<len; j++) {
                if (strs[j] == null) continue;
                char[] jCurr = strs[j].toCharArray();
                Arrays.sort(jCurr);
                int jLen = jCurr.length;
                if (len != jLen) continue;

                boolean same = true;
                for (int k=0; k<jLen; k++) {
                    if (iCurr[k] != jCurr[k]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    curr.add(strs[j]);
                    strs[j] = null;
                }
            }
            result.add(curr);
        }
        return result;
    }
}
