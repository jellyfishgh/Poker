package com;

import java.util.Scanner;

public class Poker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CardPlayer player;
		String str;
		while(true) {
			System.out.println("请输入你的纸牌：");
			str = scan.nextLine();
			if(str.equals("exit"))break;
			player = new CardPlayer(str);
			System.out.println(player.result());
		}
		scan.close();
	}
}
