public class ConsonantAlgorithm {
    public static void consonant(String str) {
        String answer = "";
        String[] chs = {
                "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ",
                "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ",
                "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ",
                "ㅋ", "ㅌ", "ㅍ", "ㅎ"
        };

        for(char c : str.toCharArray()) {
            if(c - 0xAC00 >= 0 && c - 0xAC00 <= 11172)
            {
                int result = (((c-0xAC00) - ((c-0xAC00) % 28))/28)/21;
                answer += chs[result];
            } else if(c == 32) {
                answer += " ";
            }
        }
        System.out.println(answer);
    }
}
