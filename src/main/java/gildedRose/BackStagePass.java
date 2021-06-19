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
}
