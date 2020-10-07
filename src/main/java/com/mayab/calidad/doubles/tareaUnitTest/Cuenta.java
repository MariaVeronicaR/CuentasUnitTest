package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.ArrayList;
import java.util.HashMap;


public class Cuenta {
    int id;
    int balance;
    String holder;
    AlertListener alerts;
    BDD bd;
    int zone;
  
    public Cuenta(int id, String holder, int initialBalance, AlertListener alerts, int zone){
    	this.id=id;
        this.holder = holder;
        this.balance = initialBalance;
        this.alerts = alerts;
        this.zone=zone;
    }
    public Cuenta(int balance, String holder, int zone) {
		this.balance = balance;
		this.holder = holder;
		this.zone = zone;
	}
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BDD getBd() {
		return bd;
	}

	public void setBd(BDD bd) {
		this.bd = bd;
	}

	

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }

    public void debit(float cantidad) {
    	if (this.balance <= 0) {
			System.out.println("Not enough money on your account");
		}
		Movimientos m = this.almacenarMovimiento(cantidad * -1);
		this.balance += (int) m.getCantidad() - m.getComision();
		
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }
        
    }

    public void credit(float cantidad) {
    	Movimientos m = this.almacenarMovimiento(cantidad);
		this.balance += (int) m.getCantidad() - m.getComision();

    }
    
   
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
    public Movimientos almacenarMovimiento(float cantidad) {
    	float comision = (float) (cantidad * (0.01 * this.zone));
		float ncom = cantidad - comision;
		
		Movimientos m = new Movimientos(this.id, comision, cantidad);
		this.bd.almacenar(m);
		return m;    }
    
    
}