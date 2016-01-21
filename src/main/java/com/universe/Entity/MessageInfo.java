package com.universe.Entity;

import javax.persistence.*;

/**
 * Created by boduill on 26.12.15.
 */
@Entity
@Table(name = "MESSAGES_INFO")
public class MessageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(
            name = "idGenerator",
            table = "IDS",
            pkColumnName = "table_name",
            valueColumnName = "id_value",
            allocationSize = 100
    )
    @Column(name = "MESS_INFO_ID")
    private long messInfoID;

    @Column(name = "MESS_COUNT")
    private int messCount;

    @Column(name = "ACC_ID")
    private long accId;

    public long getMessInfoID() {
        return messInfoID;
    }

    public void setMessInfoID(long messInfoID) {
        this.messInfoID = messInfoID;
    }

    public int getMessCount() {
        return messCount;
    }

    public void setMessCount(int messCount) {
        this.messCount = messCount;
    }

    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }
}
