package Controller07298;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Entity07298.SepatuEntity07298;
public class SepatuController07298 implements controllerinterface07298 {

    public void Insert07298(String merek, String size, String warna){
        SepatuEntity07298 sepatu = new  SepatuEntity07298();
            sepatu.setMerek(merek);
            sepatu.setSize(size);
            sepatu.setWarna(warna);
        AllObjectSepatu07298.sepatumodel.insertData(sepatu);
    }


    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectSepatu07298.sepatumodel.updateMerek(data, id);
                break;
             case 2:
                AllObjectSepatu07298.sepatumodel.updateSize(data, id);
                break;
             case 3:
                AllObjectSepatu07298.sepatumodel.updateWarna(data, id);
                break;
     
        }


    }

  
    //update
    public void updateData(String merek, int id){
        AllObjectSepatu07298.sepatumodel.updateMerek(merek,id);
    }  

    
//delete
public void deleteData(int id){
        AllObjectSepatu07298.sepatumodel.deleteData(id);
    }


    

    public ArrayList<SepatuEntity07298> getDataSepatu(){
        return AllObjectSepatu07298.sepatumodel.getSepatu();
    } 
    
    
  


    public DefaultTableModel daftarSepatu(){

        DefaultTableModel dataDaftarSepatu = new DefaultTableModel();
        Object[] kolom = {"ID","MEREK","SIZE","WARNA"};
    
        dataDaftarSepatu.setColumnIdentifiers(kolom);
        int size=getDataSepatu().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[4];
    
        data[0]=AllObjectSepatu07298.sepatumodel.getSepatu().get(i).getId();
        data[1]=AllObjectSepatu07298.sepatumodel.getSepatu().get(i).getMerek();    
        data[2]=AllObjectSepatu07298.sepatumodel.getSepatu().get(i).getSize();
        data[3]=AllObjectSepatu07298.sepatumodel.getSepatu().get(i).getWarna();
       
    
        dataDaftarSepatu.addRow(data);
    
        }
        return dataDaftarSepatu;
    
    
    }












    


   
}
