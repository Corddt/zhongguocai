package com.cupk.pojo;

import lombok.Data;

/**
 * 名称:City
 * 描述:这是清单中的city实体类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-29 17:06
 */
@Data
public class City {
    private Integer id;
    private String mingcheng;
    private Integer lishi_year;
    private String tese;
    private String shijing;
    private Integer niankeliuliang_wan;
    private Double GDP_yi;
}
