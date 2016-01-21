package com.universe.DAO.Enums;

/**
 * Created by boduill on 17.12.15.
 */
public enum FriendEnum {
    UserToFriendInvite("af"),
    FriendToUserInvite("fa"),
    StatusWait("wait"),
    StatusFriends("friends"),
    StatusApply("apply");

    private String value;

    public String getValue() {
        return value;
    }

    private FriendEnum(String value) {
        this.value = value;
    }
}
