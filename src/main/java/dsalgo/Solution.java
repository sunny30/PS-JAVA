package dsalgo;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        topKFrequent(words, 2);

        //for()


    }

    static class Pair {
        String name;
        Integer frequency;

        Pair(String name, Integer frequency) {
            this.name = name;
            this.frequency = frequency;

        }

    }

    //TODO
    public static List<Pair> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);

            }
        }
            List<Pair> uniquePairs = new ArrayList<Pair>();

            for (String key : map.keySet()) {
                uniquePairs.add(new Pair(key, map.get(key)));

            }

            Collections.sort(uniquePairs, new SortCriterion());
            for (int i = 0; i < k; i++)
                System.out.println(uniquePairs.get(i).name);

            return uniquePairs.subList(0, k);


        }

        static class SortCriterion implements Comparator<Pair> {

            public int compare(Pair p1, Pair p2) {
                if (p2.frequency == p1.frequency)
                    return p1.name.compareTo(p2.name);
                else
                    return p2.frequency - p1.frequency;
            }
        }
    }



/*
Your previous Plain Text content is preserved below:

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */