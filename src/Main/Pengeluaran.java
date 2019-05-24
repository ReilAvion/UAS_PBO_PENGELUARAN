/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


/**
 *
 * @author Avion
 */
public class Pengeluaran extends Pemasukan{
    private final int harga;
    
    public Pengeluaran( int harga){
        this.harga= harga;
    }
    
    public int getPrice(){
        return harga;
    }
    
    @Override
    public String toString(){
        return " " + getPrice() +  " " + getSaldo();
    }
}
