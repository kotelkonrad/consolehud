package com.fuzs.consolehud.util;

@SuppressWarnings("unused")
public enum EnumPositionPreset {

    TOP_LEFT("topleft", 0, 0, false),
    TOP_RIGHT("topright", 1, 0, true),
    BOTTOM_LEFT("bottomleft", 0, 1, false),
    BOTTOM_RIGHT("bottomright", 1, 1, false);

    private String unlocalizedName;
    private int x;
    private int y;
    private boolean shift;

    EnumPositionPreset(String unlocalizedNameIn, int x, int y, boolean potionShift) {
        this.unlocalizedName =unlocalizedNameIn;
        this.x = x;
        this.y = y;
        this.shift = potionShift;
    }

    public String toString() {
        return this.unlocalizedName;
    }

    public boolean isMirrored() {
        return this.x == 1;
    }

    public boolean isBottom() {
        return this.y == 1;
    }

    public boolean shouldShift() {
        return this.shift;
    }

    public int getX(int textureWidth, int scaledWidth, int offset) {
        return Math.abs((scaledWidth - textureWidth) * this.x - offset);
    }

    public int getY(int textureHeight, int scaledHeight, int offset) {
        return Math.abs((scaledHeight - textureHeight) * this.y - offset);
    }

    // inverts a value depending on the display side
    public float getRotation(float rotation) {
        return -(rotation - rotation * 2 * this.x);
    }

}
