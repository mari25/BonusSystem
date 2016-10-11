package dao;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by marie on 11-Oct-16.
 */
@Entity
@Table(name = "employees", schema = "bonus_system", catalog = "")
public class EmployeesEntity {
    private int id;
    private String username;
    private String password;
    private String accessLvl;
    private String personalNo;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private int salary;
    private Integer managerId;
    private String deptId;
    private String posId;

    /*
     * DO NOT USE THIS CONSTRUCTOR.
     * it's for hibernate.
     */
    public EmployeesEntity(){}

    public EmployeesEntity(String username, String password, String accessLvl){
        this.username = username;
        this.password = password;
        this.accessLvl = accessLvl;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "accessLvl")
    public String getAccessLvl() {
        return accessLvl;
    }

    public void setAccessLvl(String accessLvl) {
        this.accessLvl = accessLvl;
    }

    @Basic
    @Column(name = "personalNo")
    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "managerID")
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "deptID")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "posID")
    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesEntity that = (EmployeesEntity) o;

        if (id != that.id) return false;
        if (salary != that.salary) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (accessLvl != null ? !accessLvl.equals(that.accessLvl) : that.accessLvl != null) return false;
        if (personalNo != null ? !personalNo.equals(that.personalNo) : that.personalNo != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (posId != null ? !posId.equals(that.posId) : that.posId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accessLvl != null ? accessLvl.hashCode() : 0);
        result = 31 * result + (personalNo != null ? personalNo.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (posId != null ? posId.hashCode() : 0);
        return result;
    }
}
