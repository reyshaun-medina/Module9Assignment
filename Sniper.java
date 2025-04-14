package FPSMultiplayer;

public class Sniper extends Player {
    private final SniperRifle rifle = new SniperRifle();

    public Sniper(String username) {
        this.username = username;

        System.out.println("\n[" + getUsername() + "] is using a sniper rifle!");
        System.out.printf("%s's health is %d%n", getUsername(), getHealth());
    }

    @Override
    public void attack(Player otherPlayer) {
        rifle.fire();
        otherPlayer.health -= rifle.getDamage();

        if (rifle.getAmmo() % 4 == 0) {
            reload();
        }

        printAttack(otherPlayer);
    }

    @Override
    public void reload() {
        rifle.rounds--;

        if (rifle.getAmmo() % 4 != 0) {
            rifle.ammo = rifle.getRounds() * 5;
        }

        printReload(rifle);
    }
}
