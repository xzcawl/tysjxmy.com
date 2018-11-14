package com.tysj.dao;

import com.tysj.domain.GuestInformation;

import java.util.List;

/**
 * @Classname GuestOpreationMapper
 * @Description TODO
 * @Date 2018/11/9 11:22
 * @Created by xzcawl
 */
public interface GuestOpreationMapper {

    int saveGuestInformation(GuestInformation guestInformation);

    int updateGuestInformation(GuestInformation guestInformation);

    int deleteGuestInformation(GuestInformation guestInformation);

    List<GuestInformation> queryGuestInformations();

    GuestInformation queryIdGuestInformation(Long id);

}
