package com.doneasy.don.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoPayAmount {
    private int total;
    private int tax_free;
    private int vat;
    private int point;
    private int discount;
}
