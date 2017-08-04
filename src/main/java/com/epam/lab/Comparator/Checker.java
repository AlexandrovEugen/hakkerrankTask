package com.epam.lab.Comparator;

import java.util.Comparator;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


 class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        final Integer i1 = o1.score;
        final Integer i2 = o2.score;

        final int iComp = -i1.compareTo(i2);
        if (iComp != 0) {
            return iComp;
        } else {
            final String n1 = o1.name;
            final String n2 = o2.name;
            return n1.compareTo(n2);
        }
    }
}
