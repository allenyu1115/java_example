package com.coal.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class UserService {

	public static User createNewUser(String id, String name, String projectName, Calendar projectDeliverDate) {
		User newUser = new User(id, name, projectName, projectDeliverDate);
		return newUser;
	}

	public static Order createNewOrder(User user, String id) {
		Order newOrder = new Order(id, user);
		return newOrder;
	}
	
	public static List<Order> queryAllOrdersCreatedByUser(User user){
		return Arrays.asList();
	}

	public static class Order {
		public static enum OrderStatus {
			new_created
		}

		private String id;
		private User createdUser;
		private OrderStatus status;

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

	}

	public static class User {

		public static enum UserStatus {
			new_created, approved
		}

		private String name;
		private String projectName;
		private Calendar projectDeliverDate;
		private String id;
		private UserStatus status;

		public User() {
			this.status = UserStatus.new_created;
		}

		public User(String id, String name, String projectName, Calendar projectDeliverDate) {
			super();
			this.id = id;
			this.name = name;
			this.projectName = projectName;
			this.projectDeliverDate = projectDeliverDate;
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
	}

}
