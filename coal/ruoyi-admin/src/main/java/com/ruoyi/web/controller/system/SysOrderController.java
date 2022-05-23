package com.ruoyi.web.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysOrder;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.service.ISysOrderService;

@RestController
@RequestMapping("/system/order")
public class SysOrderController extends BaseController{
	@Autowired
    private ISysOrderService orderService;
	
	@GetMapping("/list")
    public TableDataInfo list(SysOrder order)
    {
        startPage();
        List<SysOrder> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }
}
