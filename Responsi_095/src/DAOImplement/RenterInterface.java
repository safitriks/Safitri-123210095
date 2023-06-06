/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;

public interface RenterInterface {
        public void insert(RenterModel rt);
        public List<RenterModel> getAll();
        public void editstatusroom(RenterModel rt);
        public void updatePayment(RenterModel rt);
        public void update(String nama, String contact, String Id);
        public void delete(String id);     
}
