package functionalinterfaceandlambda;

import java.util.ArrayList;
import java.util.List;

public class StreamApiBasics {
    public static void main(String[] args) {
        List<String> names = List.of("Harsh Kumar","Virat Kohli","Mahendra Singh Dhoni","Akash","Karan Chopra");
        List<String> validNames = getValidNames(names);
        List<String> shortNames = getShortNames(names);
        String allNames = getAllNames(names);

        System.out.println("Valid Names: "+validNames);
        System.out.println("Short Names: "+shortNames);
        System.out.println("All names: "+allNames);
    }

    public static List<String> getValidNames(List<String> names){
        List<String> validNames = new ArrayList<>();
        for(String name : names){
            if(name.split("\\s+").length >= 2){
                validNames.add(name);
            }
        }
        return validNames;
    }

    public static List<String> getShortNames(List<String> names){
        List<String> shortNames = new ArrayList<>();
        for(String name : names){
            String[] valid = name.split("//s+");
            StringBuilder sb = new StringBuilder();
            for(String valiShortName : valid){
                sb.append(valiShortName.charAt(0)).append(".");
            }
            shortNames.add(sb.toString());
        }
        return shortNames;
    }

    public static String getAllNames(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            String[] words = name.split("\\s+");
            StringBuilder shortName = new StringBuilder();
            for (String word : words) {
                shortName.append(word.charAt(0)).append(".");
            }
            sb.append(shortName).append(", ");
        }
        // Remove the trailing comma and space
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
