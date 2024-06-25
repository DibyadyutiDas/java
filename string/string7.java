public class string7 {
    public static void main(String[] args) {
        String str = "Find the spaces in this string.";
        int spaceCount = 0;
    
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
    
        System.out.println("Number of spaces: " + spaceCount);
    }
}