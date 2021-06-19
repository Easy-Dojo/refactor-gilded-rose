package gildedRose;

public class Item {

    public static final int MINIMUM_QUALITY = 0;
    public static final int MAXIMUM_QUALITY = 50;
    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }

    void updateSellInAndQuality() {
        updateQuality();
        updateSellIn();
        if (isExpired()) {
            updateQualityAfterExpired();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateQualityAfterExpired() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (quality > MINIMUM_QUALITY) {
            quality = quality - 1;
        }
    }

    protected void increaseQuality() {
        if (quality < MAXIMUM_QUALITY) {
            quality = quality + 1;
        }
    }

    private boolean isExpired() {
        return sell_in < 0;
    }

    protected void updateSellIn() {
        sell_in = sell_in - 1;
    }
}
