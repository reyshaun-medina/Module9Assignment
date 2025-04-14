package FPSMultiplayer;

public class Heavy extends Player {
    private SMG heavySMG;
    private Shotgun heavyShotgun;

    public Heavy(String username) {
        this.username = username;
        weaponChoice = chooseWeapon();

        System.out.printf("%s has chosen a %s as their weapon!%n", getUsername(), weaponChoice);
        System.out.printf("%s's health is %d%n", getUsername(), getHealth());
    }

    @Override
    public void attack(Player otherPlayer) {
        if (weaponChoice.equals("SMG") || weaponChoice.equals("Default SMG")) {
            heavySMG = new SMG();

            heavySMG.fire();
            otherPlayer.health -= heavySMG.getDamage();

            if (heavySMG.getAmmo() % 4 == 0) {
                reload();
            }
        }

        if (weaponChoice.equals("Shotgun")) {
            heavyShotgun = new Shotgun();

            heavyShotgun.fire();
            otherPlayer.health -= heavyShotgun.getDamage();

            if (heavyShotgun.getAmmo() % 4 == 0) {
                reload();
            }
        }

        printAttack(otherPlayer);
    }

    @Override
    public void reload() {
        if (weaponChoice.equals("SMG") || weaponChoice.equals("Default SMG")) {
            heavySMG.rounds--;

            if (heavySMG.getAmmo() % 4 != 0) {
                heavySMG.ammo = heavySMG.getRounds() * 30;
            }

            printReload(heavySMG);
        }

        if (weaponChoice.equals("Shotgun")) {
            heavyShotgun.rounds--;

            if (heavyShotgun.getAmmo() % 4 != 0) {
                heavyShotgun.ammo = heavyShotgun.getRounds() * 6;
            }

            printReload(heavyShotgun);
        }
    }
}
