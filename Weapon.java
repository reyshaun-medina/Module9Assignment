package FPSMultiplayer;

public class Weapon {
    protected int damage;
    protected int ammo;
    protected int maxAmmo;
    protected int rounds;

    public void fire() {
        if (ammo != 0) {
            ammo -= 1;
        } else {
            System.out.println("OUT OF AMMO!");
        }
    }

    public int getRounds() {
        return rounds;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getDamage() {
        return damage;
    }
}
