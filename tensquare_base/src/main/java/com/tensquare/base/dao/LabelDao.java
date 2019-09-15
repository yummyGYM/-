package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/15 14:18
 * @Modified By：
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
    //JpaRepository<Label, String> String为id的类型


}
