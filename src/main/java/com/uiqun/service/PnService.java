package com.uiqun.service;

import com.uiqun.model.Pn;

import java.util.List;

public interface PnService {
    /**
     * 查找全部
     * @return
     */
    List<Pn> queryPns();

    /**
     * excle模板插入型号
     * @return
     */
    boolean insertPns(List<List<Object>> pns);
}
