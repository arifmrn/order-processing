package com.redmart.order.controller;

import java.util.List;

import com.redmart.order.constants.Slots;
import com.redmart.order.model.Item;
import com.redmart.order.model.Order;
import com.redmart.order.util.PrintDecorator;

public class SlotProcessor {
	public String findSlot(List<Item> inputOrder) {
		Order s = new Order();
		int orderVolume = s.getVolume(inputOrder);
		if (orderVolume > 0) {
			if (orderVolume < 540000)
				return PrintDecorator.outputDecorator(findSlotUtil(orderVolume));
			else {
				while (orderVolume > 0) {
					findSlotUtil(orderVolume);
					orderVolume -= 540000;
				}
			}

			return "No slots are available for today";
		} else {
			return "Invalid Order";
		}
	}

	static String findSlotUtil(int orderVolume) {
		for (Slots temp : Slots.values()) {
			if (temp.volume >= orderVolume) {
				temp.volume -= orderVolume;
				return temp.toString();
			}
		}
		return null;
	}
}
