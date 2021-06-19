package gildedRose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void should_quality_decrease_by_1_when_pass_one_day_given_regular_good_and_is_unexpired() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);

        item.updateSellInAndQuality();

        assertEquals(9, item.sell_in);
        assertEquals(19, item.quality);
    }

    @Test
    void should_quality_decrease_by_2_when_pass_one_day_given_regular_good_and_is_expired() {
        Item item = new Item("+5 Dexterity Vest", 0, 20);

        item.updateSellInAndQuality();

        assertEquals(-1, item.sell_in);
        assertEquals(18, item.quality);
    }

    @Test
    void should_quality_no_change_when_pass_one_day_given_regular_good_and_quality_is_minimum() {
        Item item = new Item("+5 Dexterity Vest", 1, 0);

        item.updateSellInAndQuality();

        assertEquals(0, item.sell_in);
        assertEquals(0, item.quality);
    }


    @Test
    void should_quality_increase_when_pass_one_day_given_aged_brie() {
        Item item = new Item("Aged Brie", 2, 0);

        item.updateSellInAndQuality();

        assertEquals(1, item.sell_in);
        assertEquals(1, item.quality);
    }

    @Test
    void should_quality_no_change_when_pass_one_day_given_aged_brie_and_quality_is_maximum() {
        Item item = new Item("Aged Brie", 2, 50);

        item.updateSellInAndQuality();

        assertEquals(1, item.sell_in);
        assertEquals(50, item.quality);
    }

    @Test
    void should_quality_and_sell_in_no_change_when_pass_one_day_given_sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 2, 50);

        item.updateSellInAndQuality();

        assertEquals(2, item.sell_in);
        assertEquals(50, item.quality);
    }

    @Test
    void should_quality_increase_1_when_pass_one_day_given_back_stage_pass_and_sell_in_more_than_10() {
        Item item = new BackStagePass(20, 10);

        item.updateSellInAndQuality();

        assertEquals(19, item.sell_in);
        assertEquals(11, item.quality);
    }

    @Test
    void should_quality_increase_2_when_pass_one_day_given_back_stage_pass_and_sell_in_less_than_10() {
        Item item = new BackStagePass(10, 10);

        item.updateSellInAndQuality();

        assertEquals(9, item.sell_in);
        assertEquals(12, item.quality);
    }

    @Test
    void should_quality_increase_3_when_pass_one_day_given_back_stage_pass_and_sell_in_less_than_5() {
        Item item = new BackStagePass(5, 10);

        item.updateSellInAndQuality();

        assertEquals(4, item.sell_in);
        assertEquals(13, item.quality);
    }

    @Test
    void should_quality_keep_when_pass_one_day_given_back_stage_pass_and_quality_is_maximum() {
        Item item = new BackStagePass(20, 50);

        item.updateSellInAndQuality();

        assertEquals(19, item.sell_in);
        assertEquals(50, item.quality);
    }

    @Test
    void should_quality_change_0_when_pass_one_day_given_back_stage_pass_and_is_expired() {
        Item item = new BackStagePass(0, 50);

        item.updateSellInAndQuality();

        assertEquals(-1, item.sell_in);
        assertEquals(0, item.quality);
    }
}