package com.exam.string;

import java.util.Arrays;

public class CheckIfExistsOnArray {

	public static void main(String[] args) {
		String[] values = {"AB","BC","CD","AE"};
		boolean contains = Arrays.stream(values).anyMatch("AB"::equals);
		System.out.println(contains);
	}
}
