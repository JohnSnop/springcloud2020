package com.wf.springcloud.dao;

import com.wf.springcloud.domain.Storage;
import com.wf.springcloud.domain.StorageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}