package com.universe.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by boduill on 11.01.16.
 */
@Entity
@Table(name = "DIALOG_INFO")
public class Dialog {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(
            name="idGenerator",
            table="IDS",
            pkColumnName = "table_name",
            valueColumnName = "id_value",
            allocationSize=100
    )
    @Column(name = "DIAL_ID", nullable = false)
    private long dialId;

    @OneToOne
    @JoinColumn(name = "ACC_ID_ONE", nullable = false)
    private Account accIdOne;

    @OneToOne
    @JoinColumn(name = "ACC_ID_TWO", nullable = false)
    private Account accIdTwo;

    @Column(name = "MESSAGE")
    private String message;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "MESSAGE_TIME")
    private Date messageTime;

    public long getDialId() {
        return dialId;
    }

    public void setDialId(long dialId) {
        this.dialId = dialId;
    }

    public Account getAccIdOne() {
        return accIdOne;
    }

    public void setAccIdOne(Account accIdOne) {
        this.accIdOne = accIdOne;
    }

    public Account getAccIdTwo() {
        return accIdTwo;
    }

    public void setAccIdTwo(Account accIdTwo) {
        this.accIdTwo = accIdTwo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "dialId=" + dialId +
                ", accIdOne=" + accIdOne +
                ", accIdTwo=" + accIdTwo +
                '}';
    }
}
