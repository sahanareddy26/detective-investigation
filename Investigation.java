public class Investigation {

    private Suspect[] suspects;
    private int actualCulpritId;
    private int accusationAttempts;
    private boolean caseSolved;

    // Constructor
    public Investigation(
            Suspect[] suspects,
            int actualCulpritId) {

        this.suspects = suspects;
        this.actualCulpritId = actualCulpritId;
        this.accusationAttempts = 0;
        this.caseSolved = false;
    }

    // Search for a suspect using ID
    public Suspect searchSuspect(int suspectId) {

        for (Suspect suspect : suspects) {

            if (suspect.getSuspectId() == suspectId) {
                return suspect;
            }
        }

        return null;
    }

    // Investigate a suspect
    public void investigateSuspect(int suspectId) {

        Suspect suspect = searchSuspect(suspectId);

        if (suspect == null) {

            System.out.println(
                    "No suspect found with ID " + suspectId + "."
            );

            return;
        }

        System.out.println(
                "\n===== SUSPECT INVESTIGATION ====="
        );

        suspect.displayDetails();
    }

    // Accuse a suspect
    public boolean accuseSuspect(int suspectId) {

        if (caseSolved) {

            System.out.println(
                    "The case has already been solved."
            );

            return true;
        }

        if (accusationAttempts >= 3) {

            System.out.println("INVESTIGATION FAILED!");
            System.out.println(
                    "You have used all three attempts."
            );
            System.out.println(
                    "The culprit escaped."
            );

            return false;
        }

        Suspect suspect = searchSuspect(suspectId);

        if (suspect == null) {

            System.out.println(
                    "Invalid suspect ID. This attempt is not counted."
            );

            return false;
        }

        accusationAttempts++;

        if (suspectId == actualCulpritId) {

            caseSolved = true;

            System.out.println("\nCASE SOLVED!");
            System.out.println(
                    "You identified the culprit."
            );
            System.out.println(
                    "The missing question paper has been recovered."
            );

            return true;

        } else {

            System.out.println(
                    "Incorrect accusation."
            );

            System.out.println(
                    "Attempts remaining: "
                    + (3 - accusationAttempts)
            );

            if (accusationAttempts == 3) {

                System.out.println(
                        "\nINVESTIGATION FAILED!"
                );

                System.out.println(
                        "You have used all three attempts."
                );

                System.out.println(
                        "The culprit escaped."
                );
            }
        }

        return false;
    }

    // Check whether case is solved
    public boolean isCaseSolved() {
        return caseSolved;
    }

    // Check whether investigation failed
    public boolean isInvestigationFailed() {

        return accusationAttempts >= 3
                && !caseSolved;
    }
}
