package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	public static SimpleDateFormat sdfC = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus orderStatus;
	private Client client;
	List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
	}

	public Order(Date moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		Double total = 0.0;
		for (OrderItem item : items) {
			total += item.subTotal();
		}

		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: " + sdfC.format(moment) + "\n");
		sb.append("Order status: " + orderStatus + "\n");
		sb.append("Client: " + client.getName() + "(" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Order Itens:\n");
		
		for(OrderItem item : items) {
			sb.append(item);
		}
		
		sb.append(String.format("Total price: $%.2f%n", this.total()));

		return sb.toString();
	}

}
