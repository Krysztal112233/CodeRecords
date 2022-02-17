package dev.krysztal.l4b1;

public class KrysztalCodes {

	public KrysztalCodes() {
	}

	public int run() {

		int year = 2021;
		int week = 5;

		for (;;) {
			if (year % 100 == 99 && week == 0) {
				return year;
			}

			int additionDay = 0;
			if (year % 4 == 0) {
				additionDay += 1;
			}

			week = (week + (365 + additionDay) % 7) % 7;
			year++;
		}

	}
}
