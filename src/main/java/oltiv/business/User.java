package oltiv.business;

import oltiv.Dao.Interface.MasterDao;

public class User {
    int id;
    int age;
    String  name;
    String  lastname;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
