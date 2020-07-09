package com.exam.interfacetest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Service;

@Service("subs")
public class SuibstractionClass implements ICalculatorService {

	@Override
	public int calc(int a, int b) {
		return a-b;
	}

}
