package com.bilgeadam.java.tutorials.design_patterns.builder;

public class HamburgerBuilder {

    private Hamburger hamburger;

    public HamburgerBuilder HamburgerBuild(){
        hamburger = new Hamburger();
        return this;
    }

    public HamburgerBuilder addMeat(){
        hamburger.setMeatCount(hamburger.getMeatCount() + 1);
        return this;
    }

    public HamburgerBuilder removeMeat(){
        hamburger.setMeatCount(hamburger.getMeatCount() - 1);
        return this;
    }
    public HamburgerBuilder addCheese(){
        hamburger.setCheeseCount(hamburger.getCheeseCount() + 1);
        return this;
    }

    public HamburgerBuilder removeCheese(){
        hamburger.setCheeseCount(hamburger.getCheeseCount() - 1);
        return this;
    }
    public HamburgerBuilder removeMayonnaise(){
        hamburger.setMayonnaise(false);
        return this;
    }
    public HamburgerBuilder removeKetchup(){
        hamburger.setKetchup(false);
        return this;
    }
    public Food build(){
        return hamburger;
    }
}
