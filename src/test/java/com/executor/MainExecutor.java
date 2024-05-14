package com.executor;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class MainExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JUnitCore junit=new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(TestRunner.class);
		//junit.run(ReRunner.class);
	}

}
