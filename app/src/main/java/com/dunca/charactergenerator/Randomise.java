package com.dunca.charactergenerator;


import java.util.Random;

public class Randomise {
    //Temp until  mySQL database added
    String[] profession = {"Artist", "Engineer", "King", "Teacher","gamer"};
    String[] hairColour = {"brown", "blond", "grey","black", "red"};
    String[] hobby = {"painting", "gaming"};

    public String randomCharacter(){
        return "A " + randomTrait(profession) + " with " + randomTrait(hairColour)+ " hair, who enjoys " + randomTrait(hobby)+ ".";
    }

    private String randomTrait(String[] trait){
        Random random = new Random();
        int traitNum = random.nextInt(trait.length);
        return trait[traitNum];
    }

    public static void main (String[] args){
        Randomise random = new Randomise();
        System.out.println(random.randomCharacter());
        System.out.println(random.randomCharacter());
        System.out.println(random.randomCharacter());
        System.out.println(random.randomCharacter());
    }
}
