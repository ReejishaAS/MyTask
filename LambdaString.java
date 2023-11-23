interface Message {
    String message(String str);
}

public class LambdaString {
    public static void main(String[] args) {
        Message st = (str) -> {
            String str1 = "I am  Reejisha";
            String str2 = str1 + str;
            return str2;
        };
        System.out.println(st.message("Rakesh"));
    }
}
