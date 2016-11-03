package com;

public class Card {
	private String type;
	private String value;
	public static String[] TYPES = { "B", "H", "C", "D" };
	public static String[] VALUES = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };

	public Card(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String toString() {
		return this.type + this.value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	private int getIndex(String[] arr, String str) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (str.equals(arr[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int compareType(Card card) {
		return getIndex(Card.TYPES, card.getType()) - getIndex(Card.TYPES, this.getType());
	}

	public int compareValue(Card card) {
		return getIndex(Card.VALUES, card.getValue()) - getIndex(Card.VALUES, this.getValue());
	}

	public int compareTypeValue(Card card) {
		int flag;
		if (this.compareType(card) > 0) {
			flag = 1;
		} else if (this.compareType(card) == 0) {
			if (this.compareValue(card) > 0) {
				flag = 1;
			} else if (this.compareValue(card) == 0) {
				flag = 0;
			} else {
				flag = -1;
			}
		} else {
			flag = -1;
		}
		return flag;
	}

	public int compareValueType(Card card) {
		int flag;
		if (this.compareValue(card) > 0) {
			flag = 1;
		} else if (this.compareValue(card) == 0) {
			if (this.compareType(card) > 0) {
				flag = 1;
			} else if (this.compareType(card) == 0) {
				flag = 0;
			} else {
				flag = -1;
			}
		} else {
			flag = -1;
		}
		return flag;
	}
}
