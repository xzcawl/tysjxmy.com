package com.tysj.service.impl;

import com.tysj.dao.GuestOpreationMapper;
import com.tysj.domain.GuestInformation;
import com.tysj.domain.util.AppRuntimeException;
import com.tysj.domain.util.BasicResult;
import com.tysj.domain.util.GeneralResult;
import com.tysj.domain.util.ResultInformationEnum;
import com.tysj.service.GuestOpreationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Classname guestOpreationServiceImpl
 * @Description TODO
 * @Date 2018/11/9 11:21
 * @Created by xzcawl
 */

@Service
public class GuestOpreationServiceImpl implements GuestOpreationService {

    private final Logger logger = LoggerFactory.getLogger(GuestOpreationServiceImpl.class);

    @Autowired
    private GuestOpreationMapper guestOpreationMapper;

    @Transactional(rollbackOn = {AppRuntimeException.class})
    @Override
    public BasicResult saveGuestInformation(GuestInformation guestInformation) {

        BasicResult basicResult = new BasicResult();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(calendar.getTimeInMillis()));
            guestInformation.setCreateTime(parse);
            //guestInformation.setUpdatedTime(parse);

            guestOpreationMapper.saveGuestInformation(guestInformation);
            basicResult.setInformation(ResultInformationEnum.SUCCESS);
        } catch (Exception e) {
            basicResult.setInformation(ResultInformationEnum.ERROR);
            logger.error("添加客户预约信息失败: {}", e.getMessage());
        } finally {
            return basicResult;
        }
    }

    @Transactional(rollbackOn = {AppRuntimeException.class})
    @Override
    public BasicResult updateGuestInformation(GuestInformation guestInformation) {

        BasicResult basicResult = new BasicResult();
        try {
            guestOpreationMapper.updateGuestInformation(guestInformation);
            basicResult.setInformation(ResultInformationEnum.SUCCESS);
        } catch (Exception e) {
            basicResult.setInformation(ResultInformationEnum.ERROR);
            logger.error("修改客户预约信息失败: {}", e.getMessage());
        } finally {
            return basicResult;
        }
    }

    @Override
    public BasicResult deleteGuestInformation(GuestInformation guestInformation) {
        BasicResult basicResult = new BasicResult();
        try {
            guestOpreationMapper.deleteGuestInformation(guestInformation);
            basicResult.setInformation(ResultInformationEnum.SUCCESS);
        } catch (Exception e) {
            basicResult.setInformation(ResultInformationEnum.ERROR);
            logger.error("删除客户预约信息失败: {}", e.getMessage());
        } finally {
            return basicResult;
        }
    }

    @Override
    public GeneralResult<List<GuestInformation>> queryGuestInformations() {
        GeneralResult generalResult = new GeneralResult();
        try {
            List<GuestInformation> guestInformations = guestOpreationMapper.queryGuestInformations();
            generalResult.setInformation(ResultInformationEnum.SUCCESS);
            generalResult.setValue(guestInformations);
        } catch (Exception e) {
            generalResult.setInformation(ResultInformationEnum.ERROR);
            logger.error("查询所有客户列表信息失败: {}", e.getMessage());
        } finally {
            return generalResult;
        }
    }
}
