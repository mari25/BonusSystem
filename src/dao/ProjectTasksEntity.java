package dao;

import javax.persistence.*;

/**
 * Created by marie on 11-Oct-16.
 */
@Entity
@Table(name = "project_tasks", schema = "bonus_system", catalog = "")
public class ProjectTasksEntity {
    private int id;
    private String projectType;
    private String taskType;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "projectType")
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Basic
    @Column(name = "taskType")
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectTasksEntity that = (ProjectTasksEntity) o;

        if (id != that.id) return false;
        if (projectType != null ? !projectType.equals(that.projectType) : that.projectType != null) return false;
        if (taskType != null ? !taskType.equals(that.taskType) : that.taskType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectType != null ? projectType.hashCode() : 0);
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        return result;
    }
}
