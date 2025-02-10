package com.example.baitap.Service;

import com.example.baitap.entity.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    private List<BaiHat> baiHats = new ArrayList<>();

    // Thêm bài hát
    public boolean addBaiHat(BaiHat baiHat) {
        if (baiHat.getDoDai() <= 0) return false; // Độ dài phải là số nguyên dương
        return baiHats.add(baiHat);
    }

    // Xóa bài hát theo ID
    public boolean deleteBaiHat(String id) {
        return baiHats.removeIf(bh -> bh.getId().equals(id));
    }

    // Tìm bài hát theo ID
    public BaiHat findBaiHatById(String id) {
        for (BaiHat bh : baiHats) {
            if (bh.getId().equals(id)) {
                return bh;
            }
        }
        return null;
    }

    // Lấy danh sách bài hát
    public List<BaiHat> getAllBaiHats() {
        return baiHats;
    }
}
