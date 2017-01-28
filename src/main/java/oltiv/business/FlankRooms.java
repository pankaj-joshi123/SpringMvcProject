package oltiv.business;

public class FlankRooms {
    int id;
    String  roomLabel;
    int capacityOfRoom;
    int noofStudentsPresent;
    int flankId;

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

    public int getCapacityOfRoom() {
        return capacityOfRoom;
    }

    public void setCapacityOfRoom(int capacityOfRoom) {
        this.capacityOfRoom = capacityOfRoom;
    }

    public int getFlankId() {
        return flankId;
    }

    public void setFlankId(int flankId) {
        this.flankId = flankId;
    }
}
