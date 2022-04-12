import java.util.Scanner;

/**
 * The TowersOfHanoi program implements an application that
 * solves the Tower of Hanoi riddle.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-04-12
 */

class TowersOfHanoi {
    /**
     * Declaring constant for movement.
     */
    private static final String TO_PEG = " to peg ";

    /**
     * Constructor for the program.
     *
     * @throws IllegalStateException for errors
     */
    public static void towersOfHanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * This function calculates where the disks should be placed in.
     *
     * @param nOfDisks passed in
     * @param startPeg passed in
     * @param endPeg passed in
     */
    public static void hanoi(int nOfDisks, int startPeg,
                             int endPeg) {
        // declaring variables
        final int pegNumber = 6;

        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + TO_PEG
                               + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks
                + " from peg " + startPeg + TO_PEG + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
     * Main entry into the program.
     *
     * @param args nothing passed in
     */
    public static void main(final String[] args) {
        final int startPegMain = 1;
        final int endPegMain = 3;

        System.out.println("This program functions as"
            + " the Tower of Hanoi game.");

        // gets disk amount from the user
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");
        final String nOfDisksMain = userInput.nextLine();

        try {
            final int nOfDisksInt = Integer.parseInt(nOfDisksMain);
            
            System.out.println();
            if (nOfDisksInt > 0) {
                // function call to calculate moves
                hanoi(nOfDisksInt, startPegMain, endPegMain);
            } else {
                System.out.println("Please enter a positive integer");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("\nThis is not an integer");
        }
    }
}
