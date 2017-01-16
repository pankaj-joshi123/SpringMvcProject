package oltiv.business;

public class HostelFlank {
    int id;
    String  flankName;
    int hostelId;

    public int getId() { return id; }
    public void setId(int id) {this.id = id;}
    public String getFlankName() {
        return flankName;
    }
    public void setFlankName(String name) {
        this.flankName = name;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }
}
