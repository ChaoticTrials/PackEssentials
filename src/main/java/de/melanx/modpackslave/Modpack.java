package de.melanx.modpackslave;

public enum Modpack {
    CAVESTONE("CaveStone"),
    GOG("Garden of Glass");

    private final String name;

    Modpack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
