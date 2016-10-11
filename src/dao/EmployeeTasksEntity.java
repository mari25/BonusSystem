package dao;

import javax.persistence.*;

/**
 * Created by marie on 11-Oct-16.
 */
@Entity
@Table(name = "employee_tasks", schema = "bonus_system", catalog = "")
public class EmployeeTasksEntity {
    private int id;
    private int empId;
    private int taskId;
    private Integer plannedHours;
    private Integer actualHours;
    private String status;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "empID")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "taskID")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "plannedHours")
    public Integer getPlannedHours() {
        return plannedHours;
    }

    public void setPlannedHours(Integer plannedHours) {
        this.plannedHours = plannedHours;
    }

    @Basic
    @Column(name = "actualHours")
    public Integer getActualHours() {
        return actualHours;
    }

    public void setActualHours(Integer actualHours) {
        this.actualHours = actualHours;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeTasksEntity that = (EmployeeTasksEntity) o;

        if (id != that.id) return false;
        if (empId != that.empId) return false;
        if (taskId != that.taskId) return false;
        if (plannedHours != null ? !plannedHours.equals(that.plannedHours) : that.plannedHours != null) return false;
        if (actualHours != null ? !actualHours.equals(that.actualHours) : that.actualHours != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + empId;
        result = 31 * result + taskId;
        result = 31 * result + (plannedHours != null ? plannedHours.hashCode() : 0);
        result = 31 * result + (actualHours != null ? actualHours.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
