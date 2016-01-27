package codewars;

public class EightiesKids5 {

    public static String bucketOf(String said) {
        said = said.toLowerCase();
        boolean hasWater = false, hasSlime = false;

        hasWater = said.contains("water") || said.contains("wet")||said.contains("wash");
        hasSlime = said.contains("slime")||said.contains("i don\'t know");
        if(hasWater && hasSlime)
            return "sludge";
        else if(hasWater)
            return "water";
        else if(hasSlime)
            return "slime";
        else
            return "air";
    }
}