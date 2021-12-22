package Gui07298;
import javax.swing.*;
import Entity07298.SepatuEntity07298;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sepatuGui extends ComponentGui {
    JTable tabelsepatu = new JTable();
    JScrollPane spsepatu = new JScrollPane(tabelsepatu);
    JTextField textpilih = new JTextField();
    int id;
 
    String merek;
    String size;
    String warna;

    public sepatuGui(int cek){
        initComponent(cek);
    
    }
    void initComponent(final int cek) {
        for ( SepatuEntity07298 sepatuEntity : allobjectcontroller.sepatumodel.getDataSepatu()) {
        this.id = sepatuEntity.getId();
        this.merek = sepatuEntity.getMerek();
        this.size =sepatuEntity.getSize();
        this.warna = sepatuEntity.getWarna();
  
        }

setTitle("GUDANG SEPATU");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(800,480); 
setLocationRelativeTo(null); 
getContentPane().setBackground(Color.red);
 setLayout(null); setVisible(true);



 labeldatagudang.setBounds (200,0,400,40);
 labeldatagudang.setHorizontalAlignment(JLabel.CENTER);
 labeldatagudang.setFont(new Font("calibri", Font.PLAIN, 20));
 labeldatagudang.setForeground (Color.white);
 add(labeldatagudang);

//merek
labelmerek.setBounds (25,60,100,25);
labelmerek.setFont(new Font("calibri", Font.PLAIN, 16));
labelmerek.setForeground (Color.white);
add(labelmerek);

fieldmerek.setBounds (120,60,300,25);
fieldmerek.setText("");
fieldmerek.setEditable(true);
add(fieldmerek);

// size
labelsize.setBounds(25,95,40,25);
labelsize.setFont(new Font("calibri", Font.PLAIN, 16));
labelsize.setForeground (Color.white);
add(labelsize);

fieldsize.setBounds(120,95,300,25);
fieldsize.setText("");
fieldsize.setEditable(true);
add(fieldsize);

//warna
labelwarna.setBounds(25,135,80,25);
labelwarna.setFont(new Font("calibri", Font.PLAIN, 16));
labelwarna.setForeground (Color.white);
add(labelwarna);

fieldwarna.setBounds (120,130,300,25);
fieldwarna.setText("");
fieldwarna.setEditable(true);
add(fieldwarna);

btnaddnew.setBounds(500,60,100,25);
btnupdate.setBounds(500,100,100,25);
btndelete.setBounds(500,140,100,25);

add(btnaddnew);
add(btnupdate);
add(btndelete);

// tabel
spsepatu.setBounds(100, 200, 600, 200);
tabelsepatu.setModel(allobjectcontroller.sepatumodel.daftarSepatu());
add(spsepatu);

// untuk insert
btnaddnew.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        String merek = fieldmerek.getText();
        String size = fieldsize.getText();
        String warna = fieldwarna.getText();
     
        if(merek.length() != 0 && size.length() != 0 && warna.length() != 0){
            allobjectcontroller.sepatumodel.Insert07298(merek, size, warna);
            JOptionPane.showMessageDialog(null, "data sudah masuk");
            dispose();
            //new sepatuGui().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            kosong();
        }
    }
});

//string untuk hapus
tabelsepatu.addMouseListener(new MouseAdapter(){
    @Override
    public void mouseClicked(MouseEvent e){
        int i = tabelsepatu.getSelectedRow();
        textpilih.setText(allobjectcontroller.sepatumodel.daftarSepatu().getValueAt(i, 0).toString());
    }
});

// untuk update
btnupdate.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e){


    try{ 
    
    String inputData = JOptionPane. showInputDialog("Masukkan merek baru");
    String inputData1 = JOptionPane. showInputDialog("Masukkan size baru");
    String inputData2 = JOptionPane. showInputDialog("Masukkan warna baru");
    
    if(inputData.length()>0){
        id= Integer.parseInt(textpilih.getText());
         allobjectcontroller.sepatumodel.updateData(1, inputData, id);
         fieldmerek.setText("");
         tabelsepatu.setModel(allobjectcontroller.sepatumodel.daftarSepatu());
         JOptionPane.showMessageDialog(null, "Berhasil update");
    

    if (inputData1.length()>0){
        id= Integer.parseInt(textpilih.getText());
        allobjectcontroller.sepatumodel.updateData(2, inputData1, id);
        fieldsize.setText("");
        tabelsepatu.setModel(allobjectcontroller.sepatumodel.daftarSepatu());
        JOptionPane.showMessageDialog(null, "Berhasil update");

        if (inputData2.length()>0){
            id= Integer.parseInt(textpilih.getText());
            allobjectcontroller.sepatumodel.updateData(3, inputData2, id);
            fieldwarna.setText("");
            tabelsepatu.setModel(allobjectcontroller.sepatumodel.daftarSepatu());
            JOptionPane.showMessageDialog(null, "Berhasil update");
    
 
    }}}
    
    else{
    JOptionPane.showMessageDialog(null,"Data Kosong");
    }
    }catch (Exception ex){
    JOptionPane.showMessageDialog(null, "Cancelled");
    }
    }
    });

//untuk delete

btndelete.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        id= Integer.parseInt(textpilih.getText());
        allobjectcontroller.sepatumodel.deleteData(id);
        tabelsepatu.setModel(allobjectcontroller.sepatumodel.daftarSepatu());
        JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
    }
});


    }
    
}
