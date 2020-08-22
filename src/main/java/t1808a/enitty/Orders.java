package t1808a.enitty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    private int id;
    private String createAt;
    private String updateAt;
    private double totalPrice;
    private String shipAddress;
    private String shipName;
    private int shipPhone;
    private int status;


    public Orders(int id, String createAt, String updateAt, double totalPrice, String shipAddress, String shipName, int shipPhone, int status) {
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.totalPrice = totalPrice;
        this.shipAddress = shipAddress;
        this.shipName = shipName;
        this.shipPhone = shipPhone;
        this.status = status;
    }

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(int shipPhone) {
        this.shipPhone = shipPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
