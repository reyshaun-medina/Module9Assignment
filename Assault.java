package FPSMultiplayer;

public class Assault extends Player {
    private SMG assaultSMG;
    private Shotgun assaultShotgun;

    public Assault(String username) {
        this.username = username;
        weaponChoice = chooseWeapon();

        System.out.printf("%s has chosen a %s as their weapon!%n", getUsername(), weaponChoice);
        System.out.printf("%s's health is %d%n", getUsername(), getHealth());
    }

    @Override
    public void attack(Player otherPlayer) {
        if (weaponChoice.equals("SMG") || weaponChoice.equals("Default SMG")) {
            assaultSMG = new SMG();

            assaultSMG.fire();
            otherPlayer.health -= assaultSMG.getDamage();

            if (assaultSMG.getAmmo() % 4 == 0) {
                reload();
            }
        }

        if (weaponChoice.equals("Shotgun")) {
            assaultShotgun = new Shotgun();

            assaultShotgun.fire();
            otherPlayer.health -= assaultShotgun.getDamage();

            if (assaultShotgun.getAmmo() % 4 == 0) {
                reload();
            }
        }

        printAttack(otherPlayer);
    }

    @Override
    public void reload() {
        if (weaponChoice.equals("SMG") || weaponChoice.equals("Default SMG")) {
            assaultSMG.rounds--;

            if (assaultSMG.getAmmo() % 4 != 0) {
                assaultSMG.ammo = assaultSMG.getRounds() * 30;
            }

            printReload(assaultSMG);
        }

        if (weaponChoice.equals("Shotgun")) {
            assaultShotgun.rounds--;

            if (assaultShotgun.getAmmo() % 4 != 0) {
                assaultShotgun.ammo = assaultShotgun.getRounds() * 6;
            }

            printReload(assaultShotgun);
        }
    }
}
