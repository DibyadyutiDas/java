public class string8 {
    public static void main(String[] args) {
        String str = "Find the spaces in this string.";
        
        char[] nameArray = str.toCharArray();

        for (int i = 0; i < nameArray.length; i++) {
            if (str.charAt(i) == ' ') {
                nameArray[i] = '@';
            }
        }

        str = new String(nameArray);
        System.out.println("Modified string: " + str);
    }
}

// Replace spaces with '@'
// StringBuilder modifiedStr = new StringBuilder(str);
// for (int i = 0; i < modifiedStr.length(); i++) {
//     if (modifiedStr.charAt(i) == ' ') {
//         modifiedStr.setCharAt(i, '@');
//     }
// }

// System.out.println("Modified string: " + modifiedStr.toString());