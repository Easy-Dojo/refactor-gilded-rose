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

    private void updateQuality() {
        if (!isAgedBrie()
                && !isBackStagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackStagePass()) {
                    if (sell_in < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sell_in < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
    }

    protected void updateQualityAfterExpired() {
        if (!isBackStagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            quality = 0;
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
