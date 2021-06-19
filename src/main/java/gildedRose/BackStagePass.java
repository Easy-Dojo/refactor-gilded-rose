package gildedRose;

public class BackStagePass extends Item {
    public BackStagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpired() {
        quality = 0;
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (sell_in < 11) {
            increaseQuality();
        }

        if (sell_in < 6) {
            increaseQuality();
        }
    }
}
