package com.universe.Entity;

import javax.persistence.*;

/**
 * Created by boduill on 16.12.15.
 */
@Entity
@Table(name = "FRIENDS")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(
            name="idGenerator",
            table="IDS",
            pkColumnName = "table_name",
            valueColumnName = "id_value",
            allocationSize=100
    )
    @Column(name = "FR_ID")
    private long id;

    @Column(name = "ACC_ID")
    private long accId;

    @Column(name = "FRIEND")
    private long friendId;

    /** Allowable values : af(from account to friend),
     *                     fa(from friend to account)*/
    @Column(name = "INVITE")
    private String invite;

    /** Allowable values : wait(account wait for apply),
     *                     friends(request applied),
     *                     apply(account decide apply or cancel)*/
    @Column(name = "STATUS")
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }

    public long getFriend() {
        return friendId;
    }

    public void setFriend(long friend) {
        this.friendId = friend;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", accId=" + accId +
                ", friend=" + friendId +
                ", invite='" + invite + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
