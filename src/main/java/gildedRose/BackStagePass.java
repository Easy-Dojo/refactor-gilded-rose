package gildedRose;

public class BackStagePass extends Item {
    public BackStagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected boolean isBackStagePass() {
        return true;
    }

    @Override
    protected void updateQualityAfterExpired() {
        quality = 0;
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
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
