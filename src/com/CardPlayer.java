package com;

import java.util.Arrays;
import java.util.Comparator;

public class CardPlayer {
	private Card[] cards;
	public static String[] DESC = {"跳过", "顶同花顺", "同花顺", "四张", "葫芦", "同花", "顺子", "三张", "两对", "一对", "散牌"};
	public CardPlayer(String str) {
		this.init(str);
	}

	public void init(String str) {
		String[] arr = str.split(" ");
		this.cards = new Card[arr.length];
		for (int i = 0; i < arr.length; i++) {
			this.cards[i] = new Card(arr[i].substring(0, 1), arr[i].substring(1));
		}
	}

	public String result() {
		int result = 0;
		this.sortByTypeValue();
		// 同花
		if (this.sameType(0, 4)) {
			// 顺子
			if (this.diffValue(0, 4, 4)) {
				// 顶同花顺
				if (this.cards[0].getValue().equals("A")) {
					result = 1;// BK BJ BQ BA B10
				} else {
					// 同花顺
					result = 2; // BK BJ B9 BQ B10
				}
			} else {
				// 同花
				result = 5; // HK HJ H9 HQ H8
			}
		} else {
			this.sortByValueType();
			// 4张
			if (this.sameValue(0, 3) || this.sameValue(1, 4)) {
				result = 3; // B2 BK D2 C2 H2
			} else {
				// 3张
				if (this.sameValue(1, 3)) {
					result = 7; // D2 C3 D3 B9 H3
				} else if (this.sameValue(0, 2)) {
					// 葫芦
					if (this.sameValue(3, 4)) {
						result = 4; // D2 C3 D3 B2 H3
					} else {
						result = 7;
					}
				} else if (this.sameValue(2, 4)) {
					// 葫芦
					if (this.sameValue(0, 1)) {
						result = 7;
					} else {
						result = 7;
					}
				} else {
					// 2张
					if (this.sameValue(0, 1)) {
						// 两对
						if (this.sameValue(2, 3) || this.sameValue(3, 3)) {
							result = 8;// B2 D2 H10 C3 C10
						} else {
							// 一对
							result = 9;// B2 D2 H10 C3 CJ
						}
					} else if (this.sameValue(1, 2)) {
						if (this.sameValue(3, 4)) {
							result = 8;
						} else {
							result = 9;
						}
					} else if (this.sameValue(2, 3) || this.sameValue(3, 4)) {
						result = 9;
					} else {
						// 顺子
						if (this.diffValue(0, 4, 4)) {
							result = 6;// H2 B3 D6 D4 C5
						} else {
							// 散牌
							result = 10; // HA B3 D6 D4 C5
						}
					}
				}
			}
		}
		return CardPlayer.DESC[result];
	}

	public boolean sameType(int i, int j) {
		return this.cards[i].compareType(this.cards[j]) == 0;
	}

	public boolean sameValue(int i, int j) {
		return this.diffValue(i, j, 0);
	}

	public boolean diffValue(int i, int j, int dif) {
		return this.cards[i].compareValue(this.cards[j]) == dif;
	}

	public void show() {
		System.out.println("-----Cards-----");
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}

	public void sortByTypeValue() {
		Arrays.sort(this.cards, new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				return o2.compareTypeValue(o1);
			}
		});
	}

	public void sortByValueType() {
		Arrays.sort(this.cards, new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				return o2.compareValueType(o1);
			}
		});
	}
}
