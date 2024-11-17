package practice;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Person p1 = new Person("Bob");

        Group g = new Group("Coding Club", 5);

        g.addToGroup(p1);
        g.addToGroup(new Person("Tim"));
        g.addToGroup(new Person("Sue"));
        g.addToGroup(new Person("Ed"));
        g.addToGroup(new Person("Frank"));
        g.addToGroup(new Person("Josh"));

        g.groupSpeak("We love to Code!");
    }
}
