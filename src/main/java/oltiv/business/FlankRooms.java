package oltiv.business;

public class FlankRooms {
    int id;
    String  roomLabel;
    int noofStudentsPresent;
    String flankName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomLabel() {
        return roomLabel;
    }

    public void setRoomLabel(String roomLabel) {
        this.roomLabel = roomLabel;
    }

    public int getNoofStudentsPresent() {
        return noofStudentsPresent;
    }

    public void setNoofStudentsPresent(int studentsPresent) {
        this.noofStudentsPresent = studentsPresent;
    }

    public String getFlankName() {
        return flankName;
    }

    public void setFlankName(String flankName) {
        this.flankName = flankName;
    }
}
