package chapter1;

public class Sub4 {

    public static final int LIMBS_PER_PERSON = 4;
    /*
     * This is how to define and initialise a constant. It must be put outside
     * the main method, it can be placed at the other end, under the main method,
     * however best practise is to put it before, so it's more visible. For the
     * convention names of constants are spelled with upper case letters and
     * underscore is used between words.
     */

    public static void main(String[] args) {

        int numberOfPeople = 3;
        System.out.println(numberOfPeople + " people have " + (LIMBS_PER_PERSON * numberOfPeople) + " limbs.");

        // this is a line comment/inline comment. Usually for notes for the writer of
        // the code.

        /*
         * this is block comment, usually for others reading a code, it can span several
         * lines.
         */

        /**
         * This is a block comment with an extra asterisk. When extracting code, this
         * comment is included in the documentation. Sometimes put at the beginning of
         * the class with the name of the Author, email address, last edited date.
         */

    }
}