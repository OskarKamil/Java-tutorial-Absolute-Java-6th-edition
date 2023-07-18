package chapter1;

public class Sub3 {
    public static void main(String[] args) {

        String noun = "Strings";
        String sentence;
        sentence = noun + "are cool.";
        System.out.println(sentence); // Stringsare cool.
        /*
         * String is a text. It can be stored into a variable of type string, and can be
         * combined with other strings using + operator.
         */

        String solution = "The answer is " + 42; // The answer is 42
        System.out.println("100" + 42); // 10042
        /*
         * Other variable types can be cast into string type. Most of types can be
         * easily casted into string type,
         */

        System.out.println("2 + 2 = " + (2 + 2));
        System.out.println("2 + 2 = " + 2 + 2);
        /*
         * When operation takes String and other types, all other types are casted into
         * String. In the first example, the calculation is done first, so 2+2=4, and
         * then the 4 value is casted as "4" String type. Second example prints 2 + 2,
         * and then next operation is plus, which is done from left to right, on left is
         * String, on right is 2, 2 is casted into "2" and added into String, then there
         * is another 2 casted into "2". This result is "2 + 2 = 22"
         */

        String word1 = "pronouncation";
        int letterCount;
        letterCount = word1.length();
        System.out.println("The length of the word: " + word1 + ", is " + letterCount + " characters.");
        /*
         * String is a class that has methods. Each String variable is actually an
         * object. Objects are part of a class and usually objects make actions. Method
         * is a function within a class. So String.length() is actually a method (this
         * is a function). The return value of it is integer, the length of the string.
         */

        // escape sequence but before that, some string methods
        String greeting = "Say \"Hi\"!";
        System.out.println(greeting);
        System.out.println("The sentence above contains " + greeting.length() + " characters.");
        /*
         * However escape sequences are made of 2 characters, they are treated as one.
         * For example /" is printed as double quote, and treated as one character,
         * however I used slash and double quote.
         */

        /*
         * THE LIST OF ESCAPE SEQUENCES: \" Double quote. \' Single quote. \\ Backslash.
         * \n New line. Go to the beginning of the next line. \r Carriage return. Go to
         * the beginning of the current line. \t Tab. White space up to the next tab
         * stop.
         */

        String sentence2 = "I hate text processing!";
        int position = sentence2.indexOf("hate");
        String ending = sentence2.substring(position + "hate".length());

        System.out.println("01234567890123456789012");
        System.out.println(sentence2);
        System.out.println("The word \"hate\" starts at index " + position);

        sentence2 = sentence2.substring(0, position) + "adore" + ending;
        // sentence2 = sentence2.substring(0, position) + "adore" +
        // sentence2.substring(position + "hate".length());
        /*
         * This is an alternative solution. Instead of creating a String ending, you can
         * use method substring 2 times. First, you print String until you meet the
         * "hate" world. Then you print "adore". And then you print another substring
         * starting at the position of "hate" plus the length of that "hate" and
         * continue till the end.
         */

        System.out.println("The changed string is:");
        System.out.println(sentence2);
        /* Just an example of how to use String methods. */

        /*
         * LIST OF FEW STRING METHODS: int length() boolean equals(Other_String) boolean
         * equalsIgnoreCase(Other_String) String toLowerCase( ) String toUpperCase( )
         * String trim( ) char charAt(Position) String substring(Start) String
         * substring(Start, End) int indexOf(A_String) int indexOf(A_String, Start) int
         * lastIndexOf(A_String) int compareTo(A_String) int
         * compareToIgnoreCase(A_String)
         */
    }
}