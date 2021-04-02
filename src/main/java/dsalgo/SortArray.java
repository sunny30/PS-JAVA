package dsalgo;

import java.util.*;

public class SortArray {

    public static void main(String[] args) {
        List<Person> entityList = new ArrayList<Person>() ;

        Person sharad = new Person(33,"sharad") ;
        Person amit = new Person(38,"amit") ;
        Person rajat = new Person(31,"rajat") ;
        entityList.add(sharad);entityList.add(amit);entityList.add(rajat) ;
        Collections.sort(entityList,new PersonCriterion())  ;
        for(Person p: entityList){
            System.out.println(p.age+" "+p.name);
        }

    }

    static class PersonCriterion implements Comparator<Person>{
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class Person{


        int age ;
        String name ;
        public Person(int age,String name){
            this.age = age ;
            this.name = name ;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
