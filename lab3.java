import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {

        final int C3 = 1529 % 3; //String
        System.out.println("C3 = " + C3 + " /String");
        final int C17 = 1529 % 17; // В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.
        System.out.println("C17 = " + C17 + " / В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.");
        Scanner myobj = new Scanner(System.in);
        System.out.print("Enter your sentence: ");

        String user_str = myobj.nextLine();
        if (user_str.length() < 1) {
            System.out.println("you didn't enter a sentence :( ");
            System.exit(0);
        } else {
            String[] str1 = user_str.split("[\\s]+");
            System.out.println(str1[0]);
            for (int i = 0; i < str1.length; i++) {
                if(str1[i].contains(",")){
                    String last_letter = str1[i].substring(str1[i].length() - 2,str1[i].length() - 1);
                    str1[i] = str1[i].replace(last_letter.toLowerCase(), "");
                    str1[i] = str1[i].replace(last_letter.toUpperCase(), "");
                    str1[i] = str1[i].replace(",", last_letter);
                    str1[i] += ',';
                }
                if ((str1[i].matches("\\p{L}+")) || (str1[i].matches("(?=\\S*['-])([\\p{L}-]+)"))){
                    String last_letter = str1[i].substring(str1[i].length() - 1);
                    System.out.println(last_letter);
                    str1[i] = str1[i].replace(last_letter.toLowerCase(), "");
                    str1[i] = str1[i].replace(last_letter.toUpperCase(), "");
                    str1[i] = str1[i] + last_letter;
                }
            }
            System.out.println("new string: " + String.join(" ", str1));
        }

    }
}
