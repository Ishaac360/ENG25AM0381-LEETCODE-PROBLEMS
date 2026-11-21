class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1;
        int n = s.length();
        long result = 0;

        while (i < n && s.charAt(i) == ' ')
            i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + s.charAt(i) - '0';

            if (result * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (result * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (result * sign);
    }
}
