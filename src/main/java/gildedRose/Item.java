package gildedRose;

public class Item {

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
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void updateQualityAfterExpired() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private boolean isExpired() {
        return sell_in < 0;
    }

    private void updateSellIn() {
        if (!isSulfuras()) {
            sell_in = sell_in - 1;
        }
    }

    protected boolean isSulfuras() {
        return false;
    }

    protected boolean isBackStagePass() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }
}
