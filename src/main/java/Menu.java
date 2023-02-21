
import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

public class Menu {

    Scanner scannerNumbers = new Scanner(System.in);
    Scanner scannerText = new Scanner(System.in);

    public void startProgramMenu() {
        int selectedOption;
        do {
            showMenu();
            System.out.println("Select an option: ");
            selectedOption = scannerNumbers.nextInt();
            //verifyString();
            switch (selectedOption) {
                case 1:
                    convertStringUppercase();
                    break;
                case 2:
                    reverseString();
                    break;
                case 3:
                    countVowels();
                    break;
                case 4:
                    countWords();
                    break;
                case 5:
                    getTitleCase();
                    break;
                case 6:
                    checkPalindrome();
                    break;
                case 7:
                    getLongestShortestWords();
                    break;
                case 8:
                    getMostFrequentWord();
                    break;
                case 9:
                    System.out.println("EXIT!");
                default:
                    System.out.println("You chose an invalid option!");
            }
        }while (selectedOption != 9);
    }

//    public void verifyString() {
//        try {
//            System.out.println("Enter the text");
//            String text = scannerText.nextLine();
//
////            if(userInput instanceof String){
////                System.out.println(userInput);
////            } else {
////                System.out.println("This input is not a string, please enter a string");
////            }
//        } catch (Exception e) {
//            System.out.println("This input is not a string, please enter a string" + e.getMessage());
//        }
//    }

    public void showMenu() {
        System.out.println("---MENU---");
        System.out.println("1. Convert a string to uppercase");
        System.out.println("2. Reverse a string");
        System.out.println("3. Count the number of vowels in a string");
        System.out.println("4. Count the number of words in a string");
        System.out.println("5. Convert a string to title case");
        System.out.println("6. Check if a string is a palindrome");
        System.out.println("7. Find the longest and shortest words in a string");
        System.out.println("8. Find the most frequent word in a string");
        System.out.println("9. Exit");
    }

    public void convertStringUppercase() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        System.out.println(text.toUpperCase());
    }

    public void reverseString() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        StringBuffer stringBuffer = new StringBuffer(text);
        System.out.println(stringBuffer.reverse());
    }

    public void countVowels() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();

        char []chars = text.toCharArray();
        int count = 0;

        for (char c : chars) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.println("Numbers of vowels = " +count);
    }

    public void countWords() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        System.out.println(text.split("\\s+").length);
    }

    public void getTitleCase() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        if(text.length() == 1)
            System.out.println(text.toUpperCase());

        String[] parts = text.split(" ");
        StringBuilder sb = new StringBuilder( text.length() );

        for(String part : parts){

            if(part.length() > 1 )
                sb.append( part.substring(0, 1).toUpperCase() )
                        .append( part.substring(1).toLowerCase() );
            else
                sb.append(part.toUpperCase());

            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public void checkPalindrome() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        text.replace(" ", "");
        String reverse = "";
        for (int i = text.length() - 1; i >= 0 ; i--) {
            reverse += text.charAt(i);
            System.out.println(reverse);
        }

        boolean palindrome = true;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != reverse.charAt(i)) {
                palindrome = false;
            }
        }

        if(palindrome) {
            System.out.println("The string is palindrome!");
        } else {
            System.out.println("The text is not a palindrome");
        }
    }

    public void getLongestShortestWords() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        String longest = Arrays.stream(text.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("Longest word: " + longest);
        String shortest = Arrays.stream(text.split(" "))
                .min(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("Shortest word: " + shortest);

    }

    public void getMostFrequentWord() {
        System.out.println("Enter the text");
        String text = scannerText.nextLine();
        String[] word = text.split(" ");
        int count;
        for(int i =0; i < word.length; i++){
            count = 1;
            for (int j = i+ 1; j < word.length; j++) {
                if(word[i].equals(word[j])) {
                    count = count + 1;
                    word[j] = "0";
                }
            }
            if(word[i] != "0") {
                System.out.println(word[i] + "  " + count);
            }
        }
    }

}
