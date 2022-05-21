package com.coal.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.coal.service.ServiceImpl.Enitity.Order;
import com.coal.service.ServiceImpl.Enitity.Order.OrderStatus;
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

	public List<Order> queryAllOrdersCreatedByUser(User user, OrderStatus orderStatus) {
		return Arrays.asList();
	}
	
	public void assignOrderToUser(Order order, User user){
		order.setAssignedUser(user);		
	}

	public static class Enitity {

		public static interface OrderHandler {
			public Order handleOrder(Order order);
		}


		public static class Order {
			public static enum OrderStatus {
				new_created, progressing, rejected, completed
			}

			private String id;
			private User createdUser;
			private OrderStatus status;
			private User assignedUser;


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

			public User getAssignedUser() {
				return assignedUser;
			}

			public void setAssignedUser(User assignedUser) {
				this.assignedUser = assignedUser;
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
