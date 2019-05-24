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
public class Hitung {
    private int saldo;
    private String keterangan;
    private String tanggal;
    
    public Hitung(){
        saldo = 0;
        keterangan = "";
        tanggal = "";
    }
    public Hitung(int saldo){
        this.saldo = saldo;
        this.keterangan = "N/A";
        this.tanggal = "N/A";
    }
    public Hitung(int saldo, String keterangan, String tanggal){
        this.saldo = saldo;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getSaldo() {
        return saldo;
    }
    
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public String getKeterangan() {
        return keterangan;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getTanggal() {
        return tanggal;
    }
    
    @Override
    public String toString() {
        return " " + saldo;
    }
}
