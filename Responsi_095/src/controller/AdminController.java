
package controller;
import java.util.List;
import DAO.DAORenter;
import DAOImplement.RenterInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.*;
import viewresponsi.AdminPageView;
import javax.swing.JOptionPane;
import viewresponsi.RenterDataView;
import viewresponsi.UpdateView;

public class AdminController{
    AdminPageView frameadmin;
    Integer row;
    RenterInterface renterimplement;
    List<RenterModel> dr;
    public AdminController(AdminPageView adminView) {
        this.frameadmin = adminView;
        renterimplement =  new DAORenter();
        dr = renterimplement.getAll();
       
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
    
    
     public void showtabel(){
        dr = renterimplement.getAll();
        RenterTable rt = new RenterTable(dr);
        frameadmin.getTabel().setModel(rt);
    }
     
     public void pilihAksi(){
         setRow(frameadmin.tabel.getSelectedRow());
         String status = frameadmin.tabel.getValueAt(row, 5).toString();
         if (status.equals("notPaid")) {
             updatePayment();
         }else if(status.equals("Paid")){
            int result = JOptionPane.showOptionDialog(
                    frameadmin,
                    "Pilih aksi yang diinginkan:",
                    "Konfirmasi",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Update", "Delete", "Cancel"},
                    null
                    );
            
            if (result == JOptionPane.YES_OPTION) {
                JFrame UpdateView = new UpdateView();
                
                UpdateView frameUpdate = new UpdateView();
                UpdateController update = new UpdateController(frameUpdate, frameadmin);
                
                UpdateView.setVisible(true);
            } else if (result == JOptionPane.NO_OPTION) {
                delete();
                showtabel();
            } else if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
              
            }
        }
        
     }
    
    public void updatePayment(){
    Integer row = frameadmin.tabel.getSelectedRow();
    String status = frameadmin.tabel.getValueAt(row, 5).toString();
        RenterModel dr = new RenterModel();
        dr.setRenterName(frameadmin.tabel.getValueAt(row, 0).toString());
        dr.setId(frameadmin.tabel.getValueAt(row, 1).toString());
        dr.setContact(frameadmin.tabel.getValueAt(row, 2).toString());
        dr.setDuration(Integer.parseInt(frameadmin.tabel.getValueAt(row, 3).toString()));
        dr.setBill(Integer.parseInt(frameadmin.tabel.getValueAt(row, 4).toString()));
        dr.setStatus(frameadmin.tabel.getValueAt(row, 5).toString());
        dr.setRoom(frameadmin.tabel.getValueAt(row, 6).toString());
        renterimplement.updatePayment(dr);
        showtabel();
        JOptionPane.showMessageDialog(frameadmin, "Renter sudah membayar.", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
    
    }
    
    public void delete(){
        Integer row = frameadmin.tabel.getSelectedRow();
        String id = frameadmin.tabel.getValueAt(row, 1).toString();
        renterimplement.delete(id);
    }
    
    public String getIdUpdate(){
        Integer row = frameadmin.tabel.getSelectedRow();
        String idUpdate = frameadmin.tabel.getValueAt(row, 1).toString();
        return idUpdate;
    }
    public AdminPageView getFrame() {
        return frameadmin;
    }

}
