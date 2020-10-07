package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;

import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MultiplyTest {
	

	@Parameters
	public static Iterable data() {
		return Arrays.asList(new Object[][] {
			{432,"Melissa",1,new Cuenta(432,"Melissa",1)},{766,"Ivanna",2,new Cuenta(766,"Ivanna",2)},{235,"Veronica",3,new Cuenta(235,"Veronica",3)}
		});
	}

	private int balance;
	private String holder;
	private int zone;
	private Cuenta expected;
	
	public MultiplyTest(int balance, String holder, int zone, Cuenta expected) {
		this.balance = balance;
		this.holder = holder;
		this.zone = zone;
		this.expected=expected;

	}
	
	@Test
	public void CreacionCuentas() {

		Cuenta cuentaT= new Cuenta(balance,holder,zone);
		ReflectionAssert.assertReflectionEquals(expected,cuentaT);

	}

}
