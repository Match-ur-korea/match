package com.Matchurkorea.Match.domain;

public class Character {
    private String characterName;
    private String description;
    private String shortDescription;
    private String moreDescription;
    private String goodtype;
    private String badtype;
    private String hotplace;
    private String characterId;
    private String cat1;
    private String cat2;
    private String cat3;

    public String getCharacterName() {
        return characterName;
    }

    public String getDescription() {
        return description;
    }


    public String getGoodtype() {
        return goodtype;
    }

    public String getBadtype() {
        return badtype;
    }

    public String getHotplace() {
        return hotplace;
    }

    public String getCharacterId() {
        return characterId;
    }

    public String getCat1() {
        return cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public String getShortdescription(){return shortDescription;}

    public String getMoreDescription(){return moreDescription;}

    @Override
    public String toString() {
        return "Character{" +
                "characterName='" + characterName + '\'' +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", moreDescription='" + moreDescription + '\'' +
                ", goodtype='" + goodtype + '\'' +
                ", badtype='" + badtype + '\'' +
                ", hotplace='" + hotplace + '\'' +
                ", characterId='" + characterId + '\'' +
                ", cat1='" + cat1 + '\'' +
                ", cat2='" + cat2 + '\'' +
                ", cat3='" + cat3 + '\'' +
                '}';
    }
}
