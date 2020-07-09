package com.exam.interfacetest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("adds")
public class AddClass implements ICalculatorService {

	@Override
	public int calc(int a, int b) {
		return a+b;
	}

}
