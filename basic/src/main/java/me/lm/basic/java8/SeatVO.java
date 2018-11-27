package me.lm.basic.java8;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by blue_ann on 2018/5/24.
 */
@Data
@Accessors(chain = true)
public class SeatVO implements Serializable {
    private static final long serialVersionUID = 7728468622837469481L;

    //行号
    private String rowId;
    //列号
    private String columnId;
    //分区ID
    private String sectionId;
    //座位号 锁座唯一标识
    private String seatNo;
    //座位状态 0=空座位 1=可售卖 2=已锁定 3=已售出 4=禁售
    private int seatStatus;
    //座位类型 空座位= "" 普通座位="N" 情侣座左="L" 情侣座L="R"
    private String seatType;
}
