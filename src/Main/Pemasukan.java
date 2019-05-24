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
public class Pemasukan extends Hitung{
    private final int masuk;
    
    public Pemasukan (){
        masuk = 0;
    }
    public Pemasukan( int masuk, int saldo){
        super(saldo);
        this.masuk= masuk;
    }
    
    public int getMasuk(){
        return masuk;
    }
    
    
    
    @Override
    public String toString(){
        return  " " + getMasuk() +  " " + getSaldo();
    }
    
}
