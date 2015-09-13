package com.redmart.order.util;

import java.util.ArrayList;
import java.util.List;

import com.redmart.order.constants.Slots;

public class PrintDecorator {
	public static String outputDecorator(String input) {
		int value = 0;
		List<String> langList = new ArrayList<String>();
		for (Slots ls : Slots.values()) {
			langList.add(ls.name());
		}
		if (langList.contains(input)) {
			value = Slots.valueOf(input).value;

		}

		switch (value) {
		case 1:
			return "9-11 AM Slot Booked";
		case 2:
			return "10-12 AM Slot Booked";
		case 3:
			return "11-1 PM Slot Booked";
		case 4:
			return "2-4 PM Slot Booked";
		case 5:
			return "3-5 PM Slot Booked";
		case 6:
			return "4-6 PM Slot Booked";
		}
		return null;
	}
}
