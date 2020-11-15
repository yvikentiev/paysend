package com.paysend.test.service;

import com.paysend.test.dao.PaySendDao;
import com.paysend.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaySendService {

    @Autowired
    private PaySendDao paySendDao;
    public void registerUser(final User user) {
        paySendDao.saveUser(user);
    }
    public void getUserBalance(final User user) {
        paySendDao.findUser(user);
    }
}
