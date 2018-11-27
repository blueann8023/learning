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
public class RegionVO implements Serializable {
    private static final long serialVersionUID = 3617673834671598368L;

    //区域ID
    private String regionId;
    //区域名
    private String regionName;
    //区域包含的行
    private List<RowVO> rows;
}
