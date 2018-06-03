package com.keychat.dao.base;

import com.keychat.dto.base.UsersModel;

import java.util.List;

/**
 * The interface Users dao.
 */
public interface UsersDao {

    /**
     * 사용자 추가
     *
     * @param createUserModel 추가하고자 하는 사용자
     * @return the boolean 사용자 추가 성공/실패 여부
     */
    public boolean createUser(UsersModel createUserModel);

    /**
     * 사용자 조회
     *
     * @param readUserModel 검색하고자 하는 사용자 조건
     * @return the list 검색된 사용자 리스트
     */
    public List<UsersModel> readUsers(UsersModel readUserModel);

    /**
     * 사용자 수정
     *
     * @param readUserModel 수정하고자 하는 사용자 조건
     * @param updateUserModel 수정하고자 하는 사용자 모델
     * @return the boolean
     */
    public boolean updateUser(UsersModel readUserModel, UsersModel updateUserModel);

    /**
     * 사용자 삭제
     *
     * @param deleteUserModel 삭제하고자 하는 사용자 조건
     * @return the boolean 사용자 삭제 성공/실패 여부
     */
    public boolean deleteUser(UsersModel deleteUserModel);
}
