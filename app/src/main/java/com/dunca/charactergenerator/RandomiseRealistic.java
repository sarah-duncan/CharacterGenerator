package com.dunca.charactergenerator;


import java.util.Random;

public class RandomiseRealistic implements Randomise {
    //Temp until  mySQL database added
    String[] profession = {"Artist", "Engineer", "King", "Teacher","gamer"};
    String[] hairColour = {"brown", "blond", "grey","black", "red"};
    String[] hobby = {"painting", "gaming"};

    @Override
    public String[] randomCharacter(){
        return new String[]{randomTrait(profession),
                randomTrait(hairColour),
                randomTrait(hobby)};
    }

    public String randomTrait(String[] trait){
        Random random = new Random();
        int traitNum = random.nextInt(trait.length);
        return trait[traitNum];
    }

    public static void main (String[] args){
        Randomise random = new RandomiseRealistic();
        System.out.println(random.randomCharacter());
        System.out.println(random.randomCharacter());
        System.out.println(random.randomCharacter());
        System.out.println(random.randomCharacter());
    }
}
