package com.universe.Entity;

import javax.persistence.*;

/**
 * Created by boduill on 01.10.15.
 */
@Entity
@Table(name = "UNIVERSE")
public class Universe {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(
            name="idGenerator",
            table="IDS",
            pkColumnName = "table_name",
            valueColumnName = "id_value",
            allocationSize=100
    )
    @Column(name = "UN_ID")
    private long id;

    @Column(name = "NAME")
    private String unverseName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UN_TABLE")
    private String unTable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUnverseName() {
        return unverseName;
    }

    public void setUnverseName(String unverseName) {
        this.unverseName = unverseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnTable() {
        return unTable;
    }

    public void setUnTable(String un_table) {
        this.unTable = un_table;
    }

}
