package com.keychat.dao.dummy;

import com.keychat.dao.base.UsersDao;
import com.keychat.dto.base.UsersModel;

import java.util.List;

public class UsersDummy implements UsersDao {

    @Override
    public boolean createUser(UsersModel createUserModel) {
        return false;
    }

    @Override
    public List<UsersModel> readUsers(UsersModel readUserModel) {
        return null;
    }

    @Override
    public boolean updateUser(UsersModel readUserModel, UsersModel updateUserModel) {
        return false;
    }

    @Override
    public boolean deleteUser(UsersModel deleteUserModel) {
        return false;
    }
}
