package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.mockito.Matchers.*;
import static org.hamcrest.Matchers.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	BDD bd;
	AlertListener Alert;
	ArrayList<Movimientos>Arraylistm=new ArrayList<Movimientos>();
	@Before
	public void setupMocks() {
		bd= mock(BDD.class);
		Alert = mock(AlertListener.class);
	 	
	}
	
    @Test
    public void TestAlerta()
    {  
    	Cuenta cuenta= new Cuenta(1,"Veronica", 200,Alert,1);
    	cuenta.setBd(bd);	
    	cuenta.debit(150);
		verify(Alert).sendAlert("Veronica, your account balance is below 100"); 
		
	}
   
    @Test
    public void TestComprobacion()
    {  
    	Cuenta cuenta= new Cuenta(1,"Veronica", 200,Alert,1);
    	cuenta.setBd(bd); 
    	when(cuenta.almacenarMovimiento(anyFloat())).thenAnswer(new Answer<Movimientos>()
    			{
    			
    			public Movimientos answer(InvocationOnMock invocation) throws Throwable{
    					Movimientos m=(Movimientos) invocation.getArguments()[0];
    					Arraylistm.add(m);
    					
    					return m;
    				}
    			}
    
    	);
    	
    	cuenta.credit(600);
	cuenta.debit(20);
	cuenta.credit(400);
		
		float comisionTotal= 0; 
		
		for(Movimientos m :  Arraylistm) {
			
			comisionTotal += m.comision;
			
		}
		
		assertThat(cuenta.getBalance(),is(1170));
		assertThat(comisionTotal,is(9.8f));
		
	}
	
}
