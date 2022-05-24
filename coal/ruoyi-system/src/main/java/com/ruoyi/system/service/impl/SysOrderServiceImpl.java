package com.ruoyi.system.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.entity.SysOrder;
import com.ruoyi.system.service.ISysOrderService;

@Service
public class SysOrderServiceImpl implements ISysOrderService {

	@Override
	public List<SysOrder> selectOrderList(SysOrder order) {
        SysOrder order1 = new SysOrder();
        order1.setOrderId("11");
        order1.setOrderStatus("new");
        order1.setCreateTime("2012-2-20");
        SysOrder order2 = new SysOrder();
        order2.setOrderId("22");
        order2.setOrderStatus("update");
        order2.setCreateTime("2012-2-30");       
		return Arrays.asList(order1, order2);
	}

}
