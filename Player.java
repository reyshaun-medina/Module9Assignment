package FPSMultiplayer;

import java.util.Scanner;

public class Player {
    private final Scanner input = new Scanner(System.in);
    protected String username = "Player";
    protected String weaponChoice= "Weapon" ;
    protected int health = 10;
    protected int score = 0;
    private int x = 0;
    private int y = 0;

    public String chooseWeapon() {
        String myWeapon;

        System.out.printf("%n[%s] %s:%n%s%n%s%n", getUsername(), "Choose from the following types of weapons",
                "Enter A for SMG", "Enter B for Shotgun");

        System.out.print("Enter: ");
        myWeapon = input.next();

        return switch (myWeapon) {
            case "A" -> "SMG";
            case "B" -> "Shotgun";
            default -> "Default SMG";
        };
    }

    public void attack(Player otherPlayer) {
        printAttack(otherPlayer);

        System.out.printf("%s's health is %d", getUsername(), getHealth());
    }

    public void printAttack(Player otherPlayer) {
        System.out.println(getUsername() + " has attacked " + otherPlayer.getUsername() + "!");

        if (otherPlayer.isTerminated()) {
            score++;

            System.out.println(otherPlayer.getUsername() + " has been terminated!");
            System.out.println(otherPlayer.respawn());

            otherPlayer.health = 10;
        } else {
            System.out.printf("%s's health is %d!%n", otherPlayer.getUsername(), otherPlayer.getHealth());
        }
    }

    public void meleeAttack(Player otherPlayer) {
        otherPlayer.health = 0;
        score++;

        System.out.printf("%s has attacked %s with a melee weapon!%n%s has been terminated!%n",
                getUsername(), otherPlayer.getUsername(), otherPlayer.getUsername());
        System.out.println(otherPlayer.respawn());
    }

    public void reload() {
        System.out.printf(getUsername() + " has reloaded their weapon!");
    }

    public void printReload(Weapon weapon) {
        System.out.println(getUsername() + " has reloaded!");
        System.out.println(getUsername() + " has " + weapon.getRounds() + " rounds left!");
        System.out.println(getUsername() + " has " + weapon.getAmmo() + " total bullets left!");
    }

    public boolean isTerminated() {
        return getHealth() <= 0;
    }

    public String respawn() {
        return String.format("%s has respawned!", getUsername());
    }

    public String moveForward() {
        return String.format("%s's coordinates are now (%d, %d)", getUsername(), x, ++y);
    }

    public String moveBackward() {
        return String.format("%s's coordinates are now (%d, %d)", getUsername(), x, --y);
    }

    public String moveLeft() {
        return String.format("%s's coordinates are now (%d, %d)", getUsername(), --x, y);
    }

    public String moveRight() {
        return String.format("%s's coordinates are now (%d, %d)", getUsername(), ++x, y);
    }

    public int getHealth() {
        return health;
    }

    public String getUsername() {
        return username;
    }

    public void closeScanner() {
        input.close();
    }
}
