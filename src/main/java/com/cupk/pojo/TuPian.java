package com.cupk.pojo;

import lombok.Data;
import org.attoparser.dom.Text;

import javax.websocket.Decoder;

/**
 * 名称:TuPian
 * 描述:这是资源里面的图片的实体类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-28 18:16
 */
@Data
public class TuPian {
    private Integer id;
    private String timu;
    private String tupian;
    private String laiyuan;
}
