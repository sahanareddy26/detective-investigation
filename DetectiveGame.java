public class DetectiveGame {

    public static void main(String[] args) {

        // Create all suspects
        Suspect[] suspects = Suspect.createSuspects();

        // Create clue manager
        ClueManager clueManager = new ClueManager();

        // Predefined culprit
        // Assignment does not specify the culprit,
        // so ID 5 (Arjun) is used here.
        int actualCulpritId = 5;

        // Create investigation object
        Investigation investigation =
                new Investigation(suspects, actualCulpritId);

        /*
         * Predefined choices are used because
         * Scanner/user input is not required.
         */

        int[] menuChoices = {1, 2, 3, 4, 5};

        int[] investigationSuspectIds = {3};

        int[] clueChoices = {1, 3, 4, 5};

        int[] accusationIds = {2, 4, 5};

        int menuIndex = 0;
        int investigationIndex = 0;
        int clueIndex = 0;
        int accusationIndex = 0;

        boolean running = true;

        System.out.println("=================================");
        System.out.println("    DETECTIVE INVESTIGATION");
        System.out.println("=================================");

        while (running && menuIndex < menuChoices.length) {

            int choice = menuChoices[menuIndex];

            menuIndex++;

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View Suspects");
            System.out.println("2. Investigate Suspect");
            System.out.println("3. Collect Clue");
            System.out.println("4. View Collected Clues");
            System.out.println("5. Accuse Suspect");
            System.out.println("6. Exit");

            System.out.println("Selected option: " + choice);

            switch (choice) {

                case 1:

                    Suspect.displayAllSuspects(suspects);

                    break;

                case 2:

                    if (investigationIndex
                            < investigationSuspectIds.length) {

                        investigation.investigateSuspect(
                                investigationSuspectIds[
                                        investigationIndex]);

                        investigationIndex++;

                    } else {

                        System.out.println(
                                "No more predefined suspect investigations.");
                    }

                    break;

                case 3:

                    if (clueIndex < clueChoices.length) {

                        clueManager.displayAvailableClues();

                        clueManager.collectClue(
                                clueChoices[clueIndex]);

                        clueIndex++;

                    } else {

                        System.out.println(
                                "No more predefined clue selections.");
                    }

                    break;

                case 4:

                    clueManager.displayCollectedClues();

                    break;

                case 5:

                    if (accusationIndex < accusationIds.length) {

                        System.out.println(
                                "Accused suspect ID: "
                                        + accusationIds[
                                                accusationIndex]);

                        investigation.accuseSuspect(
                                accusationIds[accusationIndex]);

                        accusationIndex++;
                    }

                    if (investigation.isCaseSolved()
                            || investigation.isInvestigationFailed()) {

                        running = false;
                    }

                    break;

                case 6:

                    System.out.println(
                            "\nInvestigation terminated.");

                    running = false;

                    break;

                default:

                    System.out.println(
                            "Invalid menu option.");
            }
        }

        System.out.println(
                "\nThank you for using the Detective Investigation System.");
    }
}