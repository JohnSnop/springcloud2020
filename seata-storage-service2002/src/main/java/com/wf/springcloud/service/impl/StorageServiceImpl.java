package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.StorageMapper;
import com.wf.springcloud.domain.Storage;
import com.wf.springcloud.domain.StorageExample;
import com.wf.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wf
 * @create 2020-05-02 15:50
 * @desc
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("StorageService--->>>扣减库存开始");
        StorageExample storageExample = new StorageExample();
        storageExample.createCriteria().andProductIdEqualTo(productId);
        List<Storage> storageList = storageMapper.selectByExample(storageExample);
        if (storageList != null && storageList.size() > 0) {
            for (Storage storage : storageList) {
                storage.setUsed(storage.getUsed() + count);
                storage.setResidue(storage.getResidue() - count);
                storageMapper.updateByPrimaryKeySelective(storage);
            }
        }
        log.info("StorageService--->>>扣减库存结束");

    }
}
