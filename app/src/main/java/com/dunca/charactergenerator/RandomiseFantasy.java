package com.dunca.charactergenerator;

import java.util.Random;

public class RandomiseFantasy implements Randomise {
    String[] race ={"Human", "Elf", "Halfling","Orc", "Tabaxi", "Dragon"};
    String[] profession ={"Ranger","Paladin", "Fighter", "Druid"};
    String[] eyeColour = {"brown", "red", "black", "blue"};
    String[] hairColour= {"brown", "black", "white", "blonde"};
    String[] fantasyHobbie= {"necromancy", "drinking", "cards", "nature", "adventuring", "brawling", "politics"};

    @Override
    public String[] randomCharacter(){
        return new String[]{randomTrait(race), randomTrait(profession), randomTrait(eyeColour), randomTrait(hairColour), randomTrait(fantasyHobbie)};
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
