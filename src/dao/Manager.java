package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by marie on 11-Oct-16.
 */
public class Manager {

    SessionFactory sessionFactory;
    Session session;

    public Manager(){
        sessionFactory = new Configuration().
                configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public boolean userExists(String username){
        Transaction tr = session.beginTransaction();
        String query = "FROM EmployeesEntity e WHERE e.username = '"+ username + "'";
        int size = session.createQuery(query).list().size();
        tr.commit();
        return size > 0;
    }

    public boolean login(String username, String password){
        Transaction tr = session.beginTransaction();
        String query = "FROM EmployeesEntity e WHERE e.username = '"+ username + "'";
        List users = session.createQuery(query).list();
        tr.commit();
        Iterator it = users.iterator();
        if (it.hasNext()) {
            EmployeesEntity user = (EmployeesEntity) it.next();
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public EmployeesEntity getUserInfo(String username){
        Transaction tr = session.beginTransaction();
        String query = "FROM EmployeesEntity e WHERE e.username = '"+ username + "'";
        List users = session.createQuery(query).list();
        tr.commit();
        Iterator it = users.iterator();
        if (it.hasNext()) {
            EmployeesEntity user = (EmployeesEntity) it.next();
            user.setPassword(null);
            return user;
        }
        return null;
    }

    public void addUser(EmployeesEntity user){
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
    }

    public Vector<String> getTaskTypesByProjectType(String project){
        Vector<String> v = new Vector<>();
        Transaction tr = session.beginTransaction();

        String query = "SELECT e.type FROM ProjectTypesEntity e WHERE e.name = '"
                + project + "'";
        List dummyList = session.createQuery(query).list();
        if (dummyList.isEmpty()) return v;
        String projectType = (String) dummyList.get(0);

        query = "SELECT e.taskType FROM ProjectTasksEntity e WHERE e.projectType = '"
                + projectType + "'";
        List taskTypes = session.createQuery(query).list();
        Iterator it = taskTypes.iterator();
        while(it.hasNext()){
            String taskType = (String) it.next();
            query = "SELECT e.name FROM TaskTypesEntity e WHERE e.type = '"
                    + taskType + "'";
            dummyList = session.createQuery(query).list();
            if (dummyList.isEmpty()){
                System.out.println("task-is ertert tips ar aqvs name(!)");
                continue;
            }
            String taskName = (String) dummyList.get(0);
            v.add(taskName);
        }
        tr.commit();
        return v;
    }

    double getBonusForEmployeeOnProject(int employeeID, int projectID){
        Transaction tr = session.beginTransaction();
        String query = "SELECT e.bonus FROM ProjectsEntity e WHERE e.id = " + projectID;
        List dummyList = session.createQuery(query).list();
        if (dummyList.isEmpty()){
            return 0;
        }
        int thisProjectsBonus = (int) dummyList.get(0);
        query = "SELECT e.taskId FROM EmployeeTasksEntity e";
        List thisEmployeesTasks = session.createQuery(query).list();
        if (thisEmployeesTasks.isEmpty()){
            return 0;
        }
        Iterator it = thisEmployeesTasks.iterator();
        double percentSum = 0;
        while (it.hasNext()) {
            int task = (int) it.next();
            query = "FROM TasksEntity e WHERE e.id = " + task +
                    " AND e.projectId = " + projectID;
            dummyList = session.createQuery(query).list();
            if (dummyList.isEmpty()){
                continue;
            }
            percentSum += getBonusPercentForEmployeeOnTask(employeeID, task, tr);
        }
        return percentSum * thisProjectsBonus;
    }

    double getBonusPercentForEmployeeOnTask(int employeeID, int taskID, Transaction tr){
        String query = "FROM TasksEntity e WHERE e.id = " + taskID;
        List dummyList = session.createQuery(query).list();
        if (dummyList.isEmpty()){
            System.out.println("mocemuli id-it ar gvaqvs task(!)");
            return 0;
        }
        int taskPercentInProject = ( (TasksEntity)dummyList.get(0)).getBonusPercent();
        query = "FROM EmployeeTasksEntity e WHERE e.taskId = " + taskID;
        List employeesOnThisTask = session.createQuery(query).list();
        if (employeesOnThisTask.isEmpty()){
            System.out.println("no employee on this task(!)");
            return 0;
        }
        int allHours = 0;
        Integer thisEmployeeHours = null;
        Iterator it = employeesOnThisTask.iterator();
        while (it.hasNext()) {
            EmployeeTasksEntity emp = (EmployeeTasksEntity) it.next();
            if (emp.getEmpId() == employeeID){
                if (thisEmployeeHours != null){
                    System.out.println("wtf, ert tasks erti employee orjer aketebs(!)");
                    return 0;
                }
                thisEmployeeHours = emp.getActualHours();
            }
            allHours += emp.getActualHours();
        }
        if (thisEmployeeHours == null) {
            System.out.println("am taskze am employees ar umushavia da vitxovt bonuss(!)");
            return 0;
        }
        return allHours/ (double) thisEmployeeHours * taskPercentInProject;
    }

}
