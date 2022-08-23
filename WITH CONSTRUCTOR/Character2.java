public class Character {
    // Attributes
    int strength;
    int agility;
    int intelligence;
    String name;

    // Method
    public void sayMyName() {
        System.out.println("Hello I am " + name);
    }

    public void sayMystrength() {
        System.out.println("My Strength is " + strength);
    }

    public void sayMyagility() {
        System.out.println("My Agility is " + agility);
    }

    public void sayMyintelligence() {
        System.out.println("My Intelligence is " + intelligence);
    }



    // Constructor
    public Character(int str, int agi, int intel, String characterName) {
        strength = str;
        agility = agi;
        intelligence = intel;
        name = characterName;
    }
}