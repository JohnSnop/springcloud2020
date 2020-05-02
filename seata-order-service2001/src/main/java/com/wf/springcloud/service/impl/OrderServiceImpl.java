package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.OrderMapper;
import com.wf.springcloud.domain.Order;
import com.wf.springcloud.service.AccountService;
import com.wf.springcloud.service.OrderService;
import com.wf.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-05-02 11:02
 * @desc
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "OrderServiceImpl.insert", rollbackFor = Exception.class)
    public void insert(Order order) {
        log.info("---------->>>开始创建订单");
        orderMapper.insertSelective(order);

        log.info("---------->>>订单-->>扣减库存start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---------->>>订单-->>扣减库存end");

        log.info("---------->>>订单-->>扣减金额start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("---------->>>订单-->>扣减金额end");

        log.info("---------->>>修改订单状态");
        // 这里根据订单号操作
        /*OrderExample example = new OrderExample();
        example.createCriteria().andUserIdEqualTo(order.getUserId());
        List<Order> orderList = orderMapper.selectByExample(example);
        if (orderList != null && orderList.size() > 0) {
            for (Order order1 : orderList) {
                order1.setStatus(1);
                orderMapper.updateByPrimaryKeySelective(order1);
            }
        }*/
        order.setStatus(1);
        orderMapper.updateByPrimaryKeySelective(order);

        log.info("---------->>>创建订单完成");
    }
}
