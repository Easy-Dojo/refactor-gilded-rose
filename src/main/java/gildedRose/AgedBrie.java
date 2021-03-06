package gildedRose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpired() {
        increaseQuality();
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }
}
