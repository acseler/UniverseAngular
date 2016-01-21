package com.universe.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by boduill on 30.11.15.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(
            name="idGenerator",
            table="IDS",
            pkColumnName = "table_name",
            valueColumnName = "id_value",
            allocationSize=100
    )
    @Column(name = "MESS_ID")
    private long messageId;

    @OneToOne
    @JoinColumn(name = "DIAL_ID")
    private Dialog dialog;

    @Column(name = "TEXT_MESSAGE", nullable = false)
    private String textMessage;

    @Column(name = "MESSAGE_TIME")
    private Date messageDate;

    @Column(name = "WAS_READ")
    private char wasRead;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Date getDate() {
        return messageDate;
    }

    public void setDate(Date date) {
        this.messageDate = date;
    }

    public char getWasRead() {
        return wasRead;
    }

    public void setWasRead(char wasRead) {
        this.wasRead = wasRead;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", dialog=" + dialog +
                ", textMessage='" + textMessage + '\'' +
                ", messageDate=" + messageDate +
                ", wasRead=" + wasRead +
                '}';
    }
}
