package com.uiqun.dao;

import com.uiqun.model.Mfg;
import org.apache.ibatis.annotations.Insert;

public interface MfgDao {
    @Insert("insert into mfglist(MID ,mfgName ,mlogo ,product ,mprofile ,country ,website) " +
            "values(#{mid}  ,#{mfgName} ,#{mlogo} ,#{product} ,#{mprofile} ,#{country} ,#{website})")
    int insertMfg(Mfg mfg);
}
