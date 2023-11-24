package edu.undef.fie;

import edu.undef.fie.domain.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Nuevo producto financiero
        ProductAbstract simpleInvestment = new SimpleInvestment(100, 30, 0.1);
        ProductAbstract instantGift = new InstantGift(100, 30);
        ProductAbstract delayedGift = new DelayedGift(80, 15, 5);

        //Nuevo usuario
        User ignacio = new User("Ignacio", 1000, new ArrayList<>());

        //Usuario compra el producto financiero nro 1,2,3
        ignacio.buyProduct(simpleInvestment);
        ignacio.buyProduct(instantGift);
        ignacio.buyProduct(delayedGift);

        //El usuario se suscribe al producto financiero
        simpleInvestment.addObservers(ignacio);
        instantGift.addObservers(ignacio);
        delayedGift.addObservers(ignacio);

        //Pasan los dias sobre los productos

        for (int i = 0; i < 35; i++) {
            simpleInvestment.updateDate();
        }

//        Muestro por pantalla el balance del usuario
        System.out.println(ignacio);

        //Muestro por pantallas el historial de compras

    }
}