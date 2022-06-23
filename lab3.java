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
                if((str1[i].contains(",") || str1[i].contains("."))){ // Перевірка на кому в кінці слова
                    boolean flag = true;
                    if (str1[i].contains(".")) {
                        flag = false;
                    }
                    String last_letter = str1[i].substring(str1[i].length() - 2,str1[i].length() - 1);
                    str1[i] = str1[i].replace(last_letter.toLowerCase(), "");
                    str1[i] = str1[i].replace(last_letter.toUpperCase(), "");
                    // так як replace заміняє всі входження літери, а мені за варіантом потрібно тільки попередні входження я додаю в кінці літеру
                    if(flag){
                        str1[i] = str1[i].replace(",", last_letter);
                        str1[i] += ',';
                    }
                    else{
                        str1[i] = str1[i].replace(".", last_letter);
                        str1[i] += '.';
                    }

                }

                // перевірка чи є це взагалі словом і додам можливість перевірити слово через дефіс завдяки регулярним виразам
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
