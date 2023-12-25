/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part2;

import java.util.Date;

/**
 *
 * @author Durjoy
 */
public class Activity {
    private int activityId;
    private String activityName;
    private int activityQuantity;
    private Date activityDate;

    public Activity(int activityId, String activityName, int activityQuantity) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.activityDate = new Date();
    }

    public int getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getActivityQuantity() {
        return activityQuantity;
    }

    public Date getActivityDate() {
        return activityDate;
    }
}
