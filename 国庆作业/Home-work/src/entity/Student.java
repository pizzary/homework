package entity;


public class Student {

  private long id;
  private String name;
  private String sex;



  private long age;
  private String address;
  private String qq;
  private String email;

  public Student() {
  }

  public Student(long id, String name, String sex, long age, String address, String qq, String email) {
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.address = address;
    this.qq = qq;
    this.email = email;
  }
  public Student( String name, String sex, long age, String address, String qq, String email) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.address = address;
    this.qq = qq;
    this.email = email;
  }
  public Student( long id, String sex, long age, String address, String qq, String email) {
    this.id = id;
    this.sex = sex;
    this.age = age;
    this.address = address;
    this.qq = qq;
    this.email = email;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
