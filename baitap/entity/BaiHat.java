package com.example.baitap.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaiHat {
    private String id;
    private String ten;
    private String tenCaSi;
    private int doDai;
    private String tenNhacSi;
}
