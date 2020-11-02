package controllers;

import models.House;
import models.Room;
import models.Villa;

public class MainTest {
    public static void main(String[] args) {
        Villa villa = new Villa("villa1123", "abc", 4.5, 15, 3, "abc", "xxx", "big Villa", 45.5, 3 );
        House house = new House("house", "abc", 4.5, 15, 3, "abc", "yyy", "big house", 3 );
        Room room = new Room("room12", "abc", 4.5, 15, 3, "xyx", "water" );
        System.out.println(villa.showInfo());
        System.out.println(house.showInfo());
        System.out.println(room.showInfo());
    }
}
