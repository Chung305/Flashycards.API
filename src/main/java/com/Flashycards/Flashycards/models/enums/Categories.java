package com.Flashycards.Flashycards.models.enums;

public enum Categories {
    Java, SQL, ERROR;
    /**
     * Add different categories
     */


    public static Categories getCategory(int value){
        switch(value){
            case 1 :
                return Categories.Java;
            case 2 :
                return Categories.SQL;
            default :
                return Categories.ERROR;
        }
    }

}
