package com.coal.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.coal.service.ServiceImpl.Enitity.Order;
import com.coal.service.ServiceImpl.Enitity.Order.OrderStatus;
import com.coal.service.ServiceImpl.Enitity.OrderFlow;
import com.coal.service.ServiceImpl.Enitity.User;
import com.coal.service.ServiceImpl.Enitity.User.Role;

public class ServiceImpl {

	public User createNewUser(String id, String name, String projectName, Calendar projectDeliverDate) {
		User newUser = new User(id, name, projectName, projectDeliverDate, Role.User);
		return newUser;
	}

	public User createNewOperator(String id, String name) {
		User newOperator = new User(id, name, Role.Operator);
		return newOperator;
	}

	public Order createNewOrder(User user, String id) {
		Order newOrder = new Order(id, user);
		return newOrder;
	}

	public void assignOrderFlow(Order order, OrderFlow flow) {
		order.setOrderFlow(flow);
	}

	public void startOrderFlow(Order order) {
		order.setStatus(OrderStatus.progressing);
		order.setCurrentStep(order.getOrderFlow().getRootAction());
		order.getCurrentStep().getOrderHandler().handleOrder(order);
	}

	public void moveNextStepOfOrder(Order order) {
		if (order.getStatus() == OrderStatus.progressing) {
			order.getCurrentStep().getNextAction().getOrderHandler().handleOrder(order);
		}
	}

	public List<Order> queryAllOrdersCreatedByUser(User user, OrderStatus orderStatus) {
		return Arrays.asList();
	}

	public static class Enitity {

		public static class OrderFlow {
			private String id;
			private String flowName;
			private OrderStepAction rootAction;

			public OrderFlow(String id, String flowName, OrderStepAction rootAction) {
				this.id = id;
				this.flowName = flowName;
				this.rootAction = rootAction;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getFlowName() {
				return flowName;
			}

			public void setFlowName(String flowName) {
				this.flowName = flowName;
			}

			public OrderStepAction getRootAction() {
				return rootAction;
			}

			public void setRootAction(OrderStepAction rootAction) {
				this.rootAction = rootAction;
			}
		}

		public static interface OrderHandler {
			public Order handleOrder(Order order);
		}

		public static class OrderStepAction {
			private String id;
			private String actionName;
			private OrderHandler orderHandler;
			private OrderStepAction nextAction;
			private OrderStepAction previousAction;

			public OrderStepAction(String id, String actionName) {
				this.setId(id);
				this.setActionName(actionName);
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getActionName() {
				return actionName;
			}

			public void setActionName(String actionName) {
				this.actionName = actionName;
			}

			public OrderStepAction getNextAction() {
				return nextAction;
			}

			public OrderStepAction getPreviousAction() {
				return previousAction;
			}

			public OrderHandler getOrderHandler() {
				return orderHandler;
			}

			public void setOrderHandler(OrderHandler orderHandler) {
				this.orderHandler = orderHandler;
			}

		}

		public static class Order {
			public static enum OrderStatus {
				new_created, progressing, rejected, completed
			}

			private String id;
			private User createdUser;
			private OrderStatus status;
			private OrderFlow orderFlow;
			private OrderStepAction currentStep;

			public Order(String id, User createdUser) {
				super();
				this.id = id;
				this.createdUser = createdUser;
				this.status = OrderStatus.new_created;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public User getCreatedUser() {
				return createdUser;
			}

			public void setCreatedUser(User createdUser) {
				this.createdUser = createdUser;
			}

			public OrderStatus getStatus() {
				return status;
			}

			public void setStatus(OrderStatus status) {
				this.status = status;
			}

			public OrderFlow getOrderFlow() {
				return orderFlow;
			}

			public void setOrderFlow(OrderFlow orderFlow) {
				this.orderFlow = orderFlow;
			}

			public OrderStepAction getCurrentStep() {
				return currentStep;
			}

			public void setCurrentStep(OrderStepAction currentStep) {
				this.currentStep = currentStep;
			}

		}

		public static class User {

			public static enum UserStatus {
				new_created, approved
			}

			public static enum Role {
				User, Operator, Admin
			}

			private String name;
			private String projectName;
			private Calendar projectDeliverDate;
			private String id;
			private UserStatus status;
			private Role role;

			public User() {
				this.status = UserStatus.new_created;
			}

			public User(String id, String name, String projectName, Calendar projectDeliverDate, Role role) {
				super();
				this.id = id;
				this.name = name;
				this.projectName = projectName;
				this.projectDeliverDate = projectDeliverDate;
				this.role = role;
			}

			public User(String id, String name, Role operator) {
				super();
				this.id = id;
				this.name = name;
				this.role = operator;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getProjectName() {
				return projectName;
			}

			public void setProjectName(String projectName) {
				this.projectName = projectName;
			}

			public Calendar getProjectDeliverDate() {
				return projectDeliverDate;
			}

			public void setProjectDeliverDate(Calendar projectDeliverDate) {
				this.projectDeliverDate = projectDeliverDate;
			}

			public UserStatus getStatus() {
				return status;
			}

			public void setStatus(UserStatus status) {
				this.status = status;
			}

			public Role getRole() {
				return role;
			}

			public void setRole(Role role) {
				this.role = role;
			}
		}
	}

}
