package com.redmart.order.model;

import java.util.List;

public class Order {
	int volume;

	public int getVolume(List<Item> items) {
		int volume = 0;
		for (Item temp : items) {
			volume += temp.getVolume();
		}
		return volume;
	}

}
