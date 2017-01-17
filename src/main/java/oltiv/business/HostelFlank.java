package oltiv.business;

public class HostelFlank {
    int id;
    String  flankName;
    int hostelId;
    int noOfRooms;
    int columns;
    int studenPerRoom;

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }


    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getStudenPerRoom() {
        return studenPerRoom;
    }

    public void setStudenPerRoom(int studenPerRoom) {
        this.studenPerRoom = studenPerRoom;
    }

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
