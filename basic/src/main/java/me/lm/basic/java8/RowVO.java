package me.lm.basic.java8;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Created by blue_ann on 2018/5/24.
 */
@Data
@Accessors(chain = true)
public class RowVO implements Serializable {
    private static final long serialVersionUID = 1502844577781588407L;

    //物理行座标
    private int rowNum;
    //行号
    private String rowId;
    //行包含的座位
    private List<SeatVO> seats;
}
