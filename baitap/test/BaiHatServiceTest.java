package com.example.baitap.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.baitap.Service.BaiHatService;
import com.example.baitap.entity.BaiHat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaiHatServiceTest {
    private BaiHatService baiHatService;

    @BeforeEach
    void setUp() {
        baiHatService = new BaiHatService();
    }

    @Test
    void testAddBaiHat_Valid() {
        BaiHat baiHat = new BaiHat("1", "Hello", "Adele", 300, "Ryan");
        assertTrue(baiHatService.addBaiHat(baiHat));
        assertNotNull(baiHatService.findBaiHatById("1"));
    }

    @Test
    void testAddBaiHat_DoDaiInvalid() {
        BaiHat baiHat = new BaiHat("2", "Shape of You", "Ed Sheeran", -150, "Ed Sheeran");
        assertFalse(baiHatService.addBaiHat(baiHat));
    }

    @Test
    void testAddBaiHat_ZeroDuration() {
        BaiHat baiHat = new BaiHat("3", "Song Zero", "Singer", 0, "Composer");
        assertFalse(baiHatService.addBaiHat(baiHat));
    }

    @Test
    void testDeleteBaiHat_Exists() {
        BaiHat baiHat = new BaiHat("1", "Hello", "Adele", 300, "Ryan");
        baiHatService.addBaiHat(baiHat);

        assertTrue(baiHatService.deleteBaiHat("1"));
        assertNull(baiHatService.findBaiHatById("1"));
    }

    @Test
    void testDeleteBaiHat_NotFound() {
        assertFalse(baiHatService.deleteBaiHat("999"));
    }

    @Test
    void testFindBaiHatById_Exists() {
        BaiHat baiHat = new BaiHat("1", "Hello", "Adele", 300, "Ryan");
        baiHatService.addBaiHat(baiHat);

        assertNotNull(baiHatService.findBaiHatById("1"));
        assertEquals("Hello", baiHatService.findBaiHatById("1").getTen());
    }

    @Test
    void testFindBaiHatById_NotFound() {
        assertNull(baiHatService.findBaiHatById("100"));
    }

    @Test
    void testAddMultipleBaiHats() {
        BaiHat b1 = new BaiHat("1", "Hello", "Adele", 300, "Ryan");
        BaiHat b2 = new BaiHat("2", "Shape of You", "Ed Sheeran", 250, "Ed Sheeran");

        assertTrue(baiHatService.addBaiHat(b1));
        assertTrue(baiHatService.addBaiHat(b2));
        assertEquals(2, baiHatService.getAllBaiHats().size());
    }

    @Test
    void testUpdateBaiHat_KeepSameValues() {
        BaiHat baiHat = new BaiHat("1", "Hello", "Adele", 300, "Ryan");
        baiHatService.addBaiHat(baiHat);

        assertTrue(baiHatService.addBaiHat(new BaiHat("1", "Hello", "Adele", 300, "Ryan")));
    }

    @Test
    void testDeleteAllBaiHats() {
        baiHatService.addBaiHat(new BaiHat("1", "Hello", "Adele", 300, "Ryan"));
        baiHatService.addBaiHat(new BaiHat("2", "Shape of You", "Ed Sheeran", 250, "Ed Sheeran"));

        assertTrue(baiHatService.deleteBaiHat("1"));
        assertTrue(baiHatService.deleteBaiHat("2"));
        assertEquals(0, baiHatService.getAllBaiHats().size());
    }
}
