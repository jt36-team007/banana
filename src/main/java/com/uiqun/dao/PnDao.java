package com.uiqun.dao;

import com.uiqun.model.Pn;

import java.util.List;

public interface PnDao {
    /**
     * 查找全部
     * @return
     */
    List<Pn> queryPns();

    /**
     * excle模板插入型号
     * @return
     */
    int insertPns(List<List<Object>> pns);
}
