package application;

import java.util.Random;

public class Goods {
    private String name;
    private int MLTP, MTLU, TTP, BasePrice, IPL, Var, MTL, MTH;
    private static final int CARGOSIZE = 200;
    private static int used = 0;
    static int a, b, c, d, e, f, g, h, i, j;

    public Goods(String name, int amt) {
        if (used != CARGOSIZE) {
            this.name = name;
            if (name == "water") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                a = a + amt;
                used = used + amt;
            } else if (name == "furs") {
                MLTP = 0;
                MTLU = 0;
                TTP = 0;
                BasePrice = 250;
                IPL = 10;
                Var = 10;
                MTL = 230;
                MTH = 280;
                b = b + amt;
                used = used + amt;
            } else if (name == "food") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                c = c + amt;
                used = used + amt;
            } else if (name == "ore") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                d = d + amt;
                used = used + amt;
            } else if (name == "games") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                e = e + amt;
                used = used + amt;
            } else if (name == "firearms") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                f = f + amt;
                used = used + amt;
            } else if (name == "medicine") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                g = g + amt;
                used = used + amt;
            } else if (name == "machines") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                h = h + amt;
                used = used + amt;
            } else if (name == "narcotics") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                i = i + amt;
                used = used + amt;
            } else if (name == "robots") {
                MLTP = 0;
                MTLU = 0;
                TTP = 2;
                BasePrice = 30;
                IPL = 3;
                Var = 4;
                MTL = 30;
                MTH = 50;
                j = j + amt;
                used = used + amt;
            }
        }
    }

    public Goods(String name) {
        this(name, 1);
    }

    public int getWater() {
        return a;
    }

    public int getFur() {
        return b;
    }

    public int getFood() {
        return c;
    }

    public int getOre() {
        return d;
    }

    public int getGames() {
        return e;
    }

    public int getFirearms() {
        return f;
    }

    public int getMedicine() {
        return g;
    }

    public int getMachine() {
        return h;
    }

    public int getNarcotics() {
        return i;
    }

    public int getRobots() {
        return j;
    }

    public static int getUsed() {
        return used;
    }

    public String toString() {
        if (this.name == "water") {
            return this.name + ": " + getWater();
        } else if (this.name == "furs") {
            return this.name + ": " + getFur();
        } else if (this.name == "food") {
            return this.name + ": " + getFood();
        } else if (this.name == "ore") {
            return this.name + ": " + getOre();
        } else if (this.name == "games") {
            return this.name + ": " + getGames();
        } else if (this.name == "firearms") {
            return this.name + ": " + getFirearms();
        } else if (this.name == "medicine") {
            return this.name + ": " + getMedicine();
        } else if (this.name == "machines") {
            return this.name + ": " + getMachine();
        } else if (this.name == "narcotics") {
            return this.name + ": " + getNarcotics();
        } else if (this.name == "robots") {
            return this.name + ": " + getRobots();
        } else {
            return null;
        }
    }

    // ////////////////////
    // TESTING PURPOSE //
    // ////////////////////

    public static void main(String[] args) {
        Random rand = new Random();
        Goods[] test = new Goods[10];
        String[] g =
                { "water", "furs", "food", "ore", "games", "firearms",
                        "medicine", "machines", "narcotics", "robots" };
        for (int i = 0; i < test.length; i++) {
            int num = rand.nextInt(21);
            test[i] = new Goods(g[i], num);
            System.out.println(test[i].toString());
        }
        System.out.println("Used Space: " + getUsed() + "/" + CARGOSIZE);
    }
}
