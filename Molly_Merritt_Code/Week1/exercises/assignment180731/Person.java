public class Person extends LivingThing {

    private int height;     // private fields
    private int weight;
    private String email;
    private int age;
    private static int birthYear;   // doesn't change

    public Person(int height, int weight, String email) {
        this.height = height;
        this.weight = weight;
        this.email = email;
    }

    // overloaded constructor
    public Person(int height, int weight) {

    }
    

    // Getters and setters
    int getHeight() { return height; }
    void setHeight(int h) { height = h; }

    int getWeight() { return weight; }
    void setWeight(int w) { weight = w; }


    
}