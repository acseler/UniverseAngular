package com.universe.Tools;

import com.universe.DAO.Enums.FriendEnum;
import com.universe.Entity.Account;
import com.universe.Entity.Dialog;
import com.universe.Entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by boduill on 17.12.15.
 * Class which helps DAO layer to do some operations
 */
@Repository
public class DAOTools {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     *
     * @param friendList
     * @return
     */
    @Transactional
    public List<Account> getFriendsAccountsFromFriendList(List<Friend> friendList, Account account) {
        List<Account> list = new LinkedList<>();
        for (Friend f : friendList) {
            list.add(getFriendAccount(f, account));
        }
        return list;
    }

    public Account getAccountById(long id) {
        Account account = hibernateTemplate.get(Account.class, id);
        return account;
    }

    private Account setStatus(Account account, Friend friend) {
        account.setStatus(friend.getStatus());
        return account;
    }

    private Account getFriendAccount(Friend friend, Account account) {
        if (account.getId() == friend.getAccId()) {
            return setStatus(getAccountById(friend.getFriend()), friend);
        } else {
            return setStatus(getAccountById(friend.getAccId()), friend);
        }
    }

}
