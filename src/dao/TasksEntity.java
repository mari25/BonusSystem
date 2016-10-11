package dao;

import javax.persistence.*;

/**
 * Created by marie on 11-Oct-16.
 */
@Entity
@Table(name = "tasks", schema = "bonus_system", catalog = "")
public class TasksEntity {
    private int id;
    private int projectId;
    private String type;
    private int bonusPercent;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "projectID")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "bonusPercent")
    public int getBonusPercent() {
        return bonusPercent;
    }

    public void setBonusPercent(int bonusPercent) {
        this.bonusPercent = bonusPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksEntity that = (TasksEntity) o;

        if (id != that.id) return false;
        if (projectId != that.projectId) return false;
        if (bonusPercent != that.bonusPercent) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + projectId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + bonusPercent;
        return result;
    }
}
