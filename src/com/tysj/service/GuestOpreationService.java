package com.tysj.service;

import com.tysj.domain.GuestInformation;
import com.tysj.domain.util.BasicResult;
import com.tysj.domain.util.GeneralResult;

import java.util.List;

/**
 * @Classname GuestOpreationService
 * @Description TODO
 * @Date 2018/11/9 10:57
 * @Created by xzcawl
 */
public interface GuestOpreationService {

    /**
     * 保存客户预定信息
     *
     * @param guestInformation 客户预定信息
     * @return
     */
    BasicResult saveGuestInformation(GuestInformation guestInformation);

    /**
     * 更新客户预定信息
     *
     * @param guestInformation 客户预定信息
     * @return
     */
    BasicResult updateGuestInformation(GuestInformation guestInformation);

    /**
     * 删除客户预定信息
     *
     * @param guestInformation 客户预定信息
     * @return
     */
    BasicResult deleteGuestInformation(GuestInformation guestInformation);

    /**
     * 查询所有预定的客户信息
     *
     * @return
     */
    GeneralResult<List<GuestInformation>> queryGuestInformations();


}
