package oltiv.business;

import oltiv.Dao.Interface.MasterDao;

public class User {
    int id;
    int age;
    String  name;
    String  lastname;
    String loginName;
    String email;

    public String getLoginName() {return loginName;}
    public void setLoginName(String loginName) {this.loginName = loginName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getName() { return name; }
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
