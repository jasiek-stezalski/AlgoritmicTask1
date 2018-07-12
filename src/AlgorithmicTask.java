import java.util.*;

public class AlgorithmicTask {

    public boolean areSimilar(List<Set<String>> dictionary, String sentence1, String sentence2) {
        List<String> s1 = new ArrayList<>(Arrays.asList(sentence1.split(" ")));
        List<String> s2 = new ArrayList<>(Arrays.asList(sentence2.split(" ")));

        if (s1.size() != s2.size()) return false;

        for (int i = 0; i < s1.size(); i++) {
            for (Set temp : dictionary) {
                if (temp.contains(s1.get(i))) {
                    if (temp.contains(s2.get(i))) break;
                    else return false;
                }
            }
        }
        return true;
    }

    public boolean areSimilarVersion2(List<Set<String>> dictionary, String sentence1, String sentence2) {
        List<String> s1 = new ArrayList<>(Arrays.asList(sentence1.split(" ")));
        List<String> s2 = new ArrayList<>(Arrays.asList(sentence2.split(" ")));

        if (s1.size() != s2.size()) return false;

        Map<String, Integer> dictionary2 = new HashMap<>();

        for (int i = 0; i < dictionary.size(); i++) {
            for (String dic : dictionary.get(i)) {
                dictionary2.put(dic, i);
            }
        }

        for (int i = 0; i < s1.size(); i++) {
            if (dictionary2.containsKey(s1.get(i)) && dictionary2.containsKey(s2.get(i))) {
                if (!dictionary2.get(s1.get(i)).equals(dictionary2.get(s2.get(i)))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Create sets
        Set<String> set1 = new HashSet<>();
        set1.add("mother");
        set1.add("mom");
        set1.add("hwefhewf");

        Set<String> set2 = new HashSet<>();
        set2.add("house");
        set2.add("home");

        Set<String> set3 = new HashSet<>();
        set3.add("in");

        Set<String> set4 = new HashSet<>();
        set4.add("first");
        set4.add("one");
        set4.add("kk");

        Set<String> set5 = new HashSet<>();
        set5.add("second");
        set5.add("wow");

        // create dictionaries
        List<Set<String>> dictionary1 = new ArrayList<>();
        dictionary1.add(set1);
        dictionary1.add(set2);
        dictionary1.add(set3);

        List<Set<String>> dictionary2 = new ArrayList<>();
        dictionary2.add(set4);
        dictionary2.add(set5);


        AlgorithmicTask algorithmicTask = new AlgorithmicTask();

        String s1 = "hwefhewf in house";
        String s2 = "mom in home";
        System.out.println(algorithmicTask.areSimilar(dictionary1, s1, s2));

        String s3 = "house home home";
        String s4 = "house house house";
        System.out.println(algorithmicTask.areSimilar(dictionary1, s3, s4));

        String s5 = "mother in house";
        String s6 = "in house mom";
        System.out.println(algorithmicTask.areSimilar(dictionary1, s5, s6));

        String s7 = "kk first second";
        String s8 = "one kk wow";
        System.out.println(algorithmicTask.areSimilar(dictionary2, s7, s8));


        System.out.println("Version 2:");
        System.out.println(algorithmicTask.areSimilarVersion2(dictionary1, s1, s2));
        System.out.println(algorithmicTask.areSimilarVersion2(dictionary1, s3, s4));
        System.out.println(algorithmicTask.areSimilarVersion2(dictionary1, s5, s6));
        System.out.println(algorithmicTask.areSimilarVersion2(dictionary2, s7, s8));

    }

}


