public class Suspect {

    private int suspectId;
    private String name;
    private String location;
    private String alibi;

    public Suspect(int suspectId, String name, String location, String alibi) {
        this.suspectId = suspectId;
        this.name = name;
        this.location = location;
        this.alibi = alibi;
    }

    public int getSuspectId() {
        return suspectId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAlibi() {
        return alibi;
    }

    public void displayDetails() {
        System.out.println("ID: " + suspectId);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Alibi: " + alibi);
        System.out.println("----------------------------");
    }

    public static Suspect[] createSuspects() {

        Suspect[] suspects = new Suspect[5];

        suspects[0] = new Suspect(
                1, "Alex", "Computer Lab", "Working on a project");

        suspects[1] = new Suspect(
                2, "Maya", "Library", "Studying");

        suspects[2] = new Suspect(
                3, "Rahul", "Staff Room", "Meeting a faculty member");

        suspects[3] = new Suspect(
                4, "Sara", "Canteen", "Having lunch");

        suspects[4] = new Suspect(
                5, "Arjun", "Department Office", "Collecting documents");

        return suspects;
    }

    public static void displayAllSuspects(Suspect[] suspects) {

        System.out.println("\n===== ALL SUSPECTS =====");

        for (Suspect suspect : suspects) {

            if (suspect == null) {
                continue;
            }

            suspect.displayDetails();
        }
    }
}