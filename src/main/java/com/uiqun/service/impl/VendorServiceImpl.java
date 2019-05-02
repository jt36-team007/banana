package com.uiqun.service.impl;

import com.uiqun.dao.VendorDao;
import com.uiqun.model.Vendor;
import com.uiqun.service.VendorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    @Resource
    private VendorDao vendorDao;

    public List<Vendor> queryVendor() {
        return vendorDao.queryVendor();
    }
}
