package com.redmart.order.constants;
//Slot Names in reverse eg: MA1190 = 09-11 AM Slot
public enum Slots {
MA1190(1),MA1210(2),MP0111(3),MP0402(4),MP0503(5),MP0604(6); 
public int value = 0;
public int volume = 540000;
Slots(int temp) {
	value = temp;
}
public int getVolume() {
	return volume;
}
public void setVolume(int slotVolume) {
	this.volume=slotVolume;
}
public int getSlots() {
	return value;
}
};
