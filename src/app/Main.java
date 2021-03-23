package app;

public class Main {
    public static void main(String[] args) {
        IdGenerator generator = new IdGenerator();
        UserInstance a = new UserInstance("Bob", "Bill" ,"27701", generator.generateId());
        UserInstance b = new UserInstance("Mike", "Doe" ,"27701", generator.generateId());
        UserInstance c = new UserInstance("John", "Hardy" ,"27730", generator.generateId());
        UserInstance d = new UserInstance("Bo", "Jackson" ,"57412", generator.generateId());
        UserInstance e = new UserInstance("Karen", "Thompson" ,"27712", generator.generateId());
        UserInstance f = new UserInstance("Joe", "Johnson" ,"28801", generator.generateId());
        UserInstance g = new UserInstance("Lindsay", "Jones" ,"37701", generator.generateId());
        UserInstance h = new UserInstance("Emilia", "Smith" ,"27601", generator.generateId());

        GraphNode personA = new GraphNode(a);
        GraphNode personB = new GraphNode(b);
        GraphNode personC = new GraphNode(c);
        GraphNode personD = new GraphNode(d);
        GraphNode personE = new GraphNode(e);
        GraphNode personF = new GraphNode(f);
        GraphNode personG = new GraphNode(g);
        GraphNode personH = new GraphNode(h);

        personA.addRelation(personB);
        personA.addRelation(personC);
        personA.addRelation(personD);
        personA.addRelation(personE);
        personA.addRelation(personF);
        personA.addRelation(personG);
        personA.addRelation(personH);

        personB.addRelation(personA);
        personC.addRelation(personA);
        personD.addRelation(personA);

        personB.addRelation(personA);
        personB.addRelation(personB);
        personB.addRelation(personC);

        personC.addRelation(personE);
        personC.addRelation(personF);
        personC.addRelation(personG);

        personD.addRelation(personF);
        personD.addRelation(personG);
        personD.addRelation(personA);

        // A => B
        int userBId = personB.getUser().getId();
        GraphNode findBFromA = personA.findNode(userBId);
        findBFromA.getUser().printUser();

        // A => E
        int userEId = personE.getUser().getId();
        GraphNode findEFromBFromA = findBFromA.findNode(userEId);
        findEFromBFromA.getUser().printUser();

        // D => A => H
        int userHId = personH.getUser().getId();
        GraphNode findHFromD = personD.findNode(userHId);
        findHFromD.getUser().printUser();

        // H => null
        int userDId = personD.getUser().getId();
        GraphNode findDFromHFromD = findHFromD.findNode(userDId);

        // returns H because H contains no relations
        findDFromHFromD.getUser().printUser();

        // H => A => D
        personH.addRelation(personA);
        findDFromHFromD = findHFromD.findNode(userDId);
        findDFromHFromD.getUser().printUser();
    }
}
