package dgraph;

import java.util.Arrays;

//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.TreeMap;
//
//class KeyClass {
//
//    String key;
//
//    KeyClass(String key) {
//        this.key = key;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        KeyClass keyClass = (KeyClass) o;
//        return Objects.equals(key, keyClass.key);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(key);
//    }
//}
//
//
//class ValueClass {
//
//    String value;
//
//    ValueClass(String key) {
//        this.value = key;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        KeyClass keyClass = (KeyClass) o;
//        return Objects.equals(value, keyClass.key);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value);
//    }
//}
//
//class MapClass {
//
//    Map<KeyClass, ValueClass> map = new HashMap<KeyClass, ValueClass>();
//
//    public void insert(String key, String value,Long epochExpirey) {
//        KeyClass keyClass = new KeyClass(key) ;
//        map.put(keyClass, new ValueClass(value));
//
//        ExpireyCollection.insert(epochExpirey,keyClass);
//    }
//
//
//    public void remove(String key) {
//        map.remove(key);
//
//    }
//
//
//}
//
//
//class ExpireyCollection {
//
//    static Map<Long, KeyClass> exmap = new TreeMap<Long, KeyClass>();
//    MapClass map;
//
//    ExpireyCollection(MapClass map) {
//        this.map = map;
//    }
//
//
//    public static void insert(Long epoch, KeyClass key) {
//        exmap.put(epoch, key);
//    }
//
//    public void remove(Long epoch) {
//
//        for (Long val : exmap.keySet()) {
//            if (val <= epoch) {
//                map.remove(exmap.get(val).key);
//                exmap.remove(val);
//
//
//            } else {
//                break;
//            }
//
//        }
//
//    }
//
//}
//
public class Solution {

    class A {
        int a;

        A(int a) {
            this.a = a;

        }
    }

    public void check() {
        A aa = new A(2);
        A ss1 = aa;
        aa = new A(3);
        System.out.println(ss1.a);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.check();
        String[] a = new String[3];
        a[0] = "aa";
        a[1]= "a";
        a[2] = "aaa";


        Arrays.sort(a);

        for(int i=0;i<3;i++)
            System.out.println(a[i]);

    }
}
