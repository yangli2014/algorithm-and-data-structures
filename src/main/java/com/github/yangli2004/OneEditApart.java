package com.github.yangli2004;

public class OneEditApart {
    public static void main(String[] args) {
        System.out.println(canEdit("cat", "dog"));
        System.out.println(canEdit("cat", "cats"));
        System.out.println(canEdit("cat", "cut"));
        System.out.println(canEdit("cat", "cast"));
        System.out.println(canEdit("cat", "at"));
        System.out.println(canEdit("cat", "act"));
    }

    static boolean canEdit(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        if (s2.length() - s1.length() > 1) {
            return false;
        }
        boolean hasDiff = false;
        for (int i = 0, j = 0; i < s1.length(); i++, j++) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if(hasDiff) {
                    return false;
                }
                hasDiff = true;
                if(s2.length() > s1.length()) {
                    i--;
                }
            }
        }
        return hasDiff || s2.length() != s1.length();
    }

}
