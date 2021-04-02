package dsalgo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueImpl {

    public static void main(String[] args) {


        Person sh = new Person(33,"Sharad") ;
        Person amit = new Person( 38, "Amit") ;
        Person Rajat = new Person(31,"Rajat") ;

        PriorityQueue<Person> minQueue = new PriorityQueue<Person>(3,new MinCriterion()) ;
        minQueue.add(sh);minQueue.add(amit);minQueue.add(Rajat) ;

        System.out.println(minQueue.peek().name);

        minQueue.poll() ;

        System.out.println(minQueue.peek().name);


        PriorityQueue<Person> maxQueue = new PriorityQueue<Person>(3,new MaxCriterion()) ;
        maxQueue.add(sh);maxQueue.add(amit);maxQueue.add(Rajat) ;

        System.out.println(maxQueue.peek().name);

        maxQueue.poll() ;

        System.out.println(maxQueue.peek().name);

    }

    static class MinCriterion implements Comparator<Person> {

        public int compare(Person o1, Person o2) {
            return o1.getName().compareToIgnoreCase(o2.getName()) ;
        }
    }

    static class MaxCriterion implements Comparator<Person> {

        public int compare(Person o1, Person o2) {
            return o2.getName().compareToIgnoreCase(o1.getName()) ;
        }
    }




    static class Person{
        String name ;
        int age ;
        Person(int age,String name){
            this.age = age ;
            this.name = name ;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


    }
}
