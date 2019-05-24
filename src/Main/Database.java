/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author Axioo
 */
public class Database extends Connector{
    public Database(){
        super();
    }
    
    public void pemasukan(int pemasukan,int saldo, String keterangan, String tanggal){
        insertPemasukan(pemasukan);
        insertDetailSaldo(saldo, keterangan, tanggal);
        insertPengeluaran(0);
    }
    
    public void pengeluaran(int pengeluaran,int saldo, String keterangan, String tanggal){
        insertPengeluaran(pengeluaran);
        insertDetailSaldo(saldo, keterangan, tanggal);
        insertPemasukan(0);
    }
    
    public void delete(){
        deleteDetailSaldo();
        deletePemasukan();
        deletePengeluaran();
    }
    //memasukan data pemasukan kedalam DB
    private void insertPemasukan(int pemasukan){
        query = "INSERT INTO `pemasukan` (`id_pemasukan`, `pemasukan`) "
                + "VALUES (NULL, '" + pemasukan + "')";
        try{
            st.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //memasukan data pengeluaran kedalam DB
    private void insertPengeluaran(int pengeluaran){
        query = "INSERT INTO `pengeluaran` (`id_pengeluaran`, `pengeluaran`) "
                + "VALUES (NULL, '" + pengeluaran + "')";
        try{
            st.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //memasukan data detail saldo kedalam DB
    private void insertDetailSaldo(int saldo, String keterangan, String tanggal){
        query = "INSERT INTO `saldo` (`saldo`,`keterangan`, `tanggal`) "
                + "VALUES ('" + saldo + "', '" + keterangan + "', '" + tanggal + "')";
        System.out.println(query);
        try{
            st.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //delete data pemasukan dalam db 
    private void deletePemasukan(){
        query = "DELETE FROM pemasukan ORDER BY id_pemasukan DESC LIMIT 1";
        try{
            st.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //delete data pengeluaran dalam db
    private void deletePengeluaran(){
        query = "DELETE FROM pengeluaran ORDER BY id_pengeluaran DESC LIMIT 1";
        try{
            st.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //delete data detail saldo dalam db
    private void deleteDetailSaldo(){
        query = "DELETE FROM saldo ORDER BY id DESC LIMIT 1";
        try{
            st.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Integer> getPemasukan(){
        ArrayList<Integer> dataPemasukan = new ArrayList<>();
        query = "SELECT * FROM `pemasukan`";
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                //Mendapatkan nilai pemasukan dari DB;
                dataPemasukan.add(Integer.parseInt(rs.getString(2)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dataPemasukan;
    }
    
    public ArrayList<Integer> getPengeluaran(){
        ArrayList<Integer> dataPengeluaran = new ArrayList<>();
        query = "SELECT * FROM `pengeluaran`";
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                //Mendapatkan nilai pemasukan dari DB;
                dataPengeluaran.add(Integer.parseInt(rs.getString(2)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dataPengeluaran;
    }
    
    //mengambil data dalam DB
    public ArrayList<Hitung> getDetailSaldo(){
        ArrayList<Hitung> dataDetailSaldo = new ArrayList<>();
        query = "SELECT * FROM `saldo`";
        System.out.println(query);
        try{
            rs = st.executeQuery(query);
            while(rs.next()){ 
                dataDetailSaldo.add(new Hitung(
                        //Mendapatkan saldo
                        Integer.parseInt(rs.getString(2)),
                        //Mendapatkan keterangan
                        rs.getString(3),
                        //Mendapatkan tanggal
                        rs.getString(4)
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dataDetailSaldo;
    }
    //menampilkan data dalam saldo
    public int getSaldo(){
        int saldo = 0;
        query = "SELECT `saldo` FROM `saldo`";
        System.out.println(query);
        try{
            rs = st.executeQuery(query);
            rs.last();
            saldo = Integer.parseInt(rs.getString(1));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return saldo;
    }
    
}    

    

   
