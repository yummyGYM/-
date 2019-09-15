package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/15 9:52
 * @Modified By：
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label implements Serializable{
    @Id
    private String id;
    private String labelname; //标签名称
    private String state;  //状态
    private Long count;    //使用数量
    private String recommend;//是否推荐
    private Long fans;        //粉丝数


}
