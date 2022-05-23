package com.ruoyi.common.core.domain.entity;

import java.io.Serializable;

public class SysOrder implements Serializable {
	private static final long serialVersionUID = 3891680019947461693L;
	private String orderId;
	private String orderStatus;
	private String createTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
