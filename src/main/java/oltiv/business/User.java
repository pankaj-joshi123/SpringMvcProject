package oltiv.business;

public class User {
    int id;
    int age;
    String  name;
    String  lastname;
    String loginName;
    String email;
    String password;

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

    public String getLoginName() {return loginName;}
    public void setLoginName(String loginName) {this.loginName = loginName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public void makeUser(String[] object) {
        this.setAge(Integer.parseInt(object[0]));
        this.setName(object[1]);
        this.setLastname(object[2]);
        this.setLoginName(object[3]);
        this.setEmail(object[4]);
        this.setPassword(object[5]);
    }
}
