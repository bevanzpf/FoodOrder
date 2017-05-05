package po;

/**
 * Created by p on 2017/5/5.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String pwd;
    private String address;
    private String photoUrl;
    private boolean activited;
    private String activeDigest;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", activited=" + activited +
                ", activeDigest='" + activeDigest + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean isActivited() {
        return activited;
    }

    public void setActivited(boolean activited) {
        this.activited = activited;
    }

    public String getActiveDigest() {
        return activeDigest;
    }

    public void setActiveDigest(String activeDigest) {
        this.activeDigest = activeDigest;
    }
}
