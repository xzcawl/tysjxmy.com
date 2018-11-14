package com.tysj.web;

import com.tysj.common.JsonUtil;
import com.tysj.domain.GuestInformation;
import com.tysj.domain.util.BasicResult;
import com.tysj.domain.util.DataModel;
import com.tysj.domain.util.GeneralResult;
import com.tysj.service.GuestOpreationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * @Classname GuestInformationController
 * @Description TODO
 * @Date 2018/11/9 15:50
 * @Created by xzcawl
 */
@Controller
@RequestMapping("/guestInformation")
public class GuestInformationController {

    private final static Logger logger = LoggerFactory.getLogger(GuestInformationController.class);

    @Autowired
    private GuestOpreationService guestOpreationService;

    @RequestMapping(value = "/saveGuestInformation.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BasicResult saveGuestInformation(@RequestBody @Valid GuestInformation guestInformation) {
        logger.info("@saveGuestInformation params ：{}", JsonUtil.objToStr(guestInformation));
        return guestOpreationService.saveGuestInformation(guestInformation);
    }

    @RequestMapping(value = "/updateGuestInformation.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BasicResult updateGuestInformation(@RequestBody @Valid GuestInformation guestInformation) {
        logger.info("@updateGuestInformation params:{}", JsonUtil.objToStr(guestInformation));
        return guestOpreationService.updateGuestInformation(guestInformation);
    }


    @RequestMapping(value = "/deleteGuestInformation.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BasicResult deleteGuestInformation(@RequestBody @Valid GuestInformation guestInformation) {
        logger.info("@deleteGuestInformation params ：{}", JsonUtil.objToStr(guestInformation));
        return guestOpreationService.deleteGuestInformation(guestInformation);
    }


    /**
     * 获取所有信息记录
     */
    @RequestMapping(value = "/getAllAppList.do", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getAllAppList(int draw, int start, int length, @RequestParam(value = "search[value]", required = false) String search) {
        try {
            GeneralResult<List<GuestInformation>> listGeneralResult = guestOpreationService.queryGuestInformations();
            List<GuestInformation> tmpList = listGeneralResult.getValue();
            if (!"".equals(search)) {
                tmpList = listBySearch(search, tmpList);
            }
            int pageNumber = start >= length ? start / length + 1 : 1;
            DataModel<GuestInformation> dataModel;
            int totalSize = tmpList.size();
            List<GuestInformation> BeanPage = new ArrayList<GuestInformation>();
            int currIdx = (pageNumber > 1 ? (pageNumber - 1) * length : 0);
            for (int i = 0; i < length && i < tmpList.size() - currIdx; i++) {
                GuestInformation bean = tmpList.get(currIdx + i);
                BeanPage.add(bean);
            }
            dataModel = new DataModel<GuestInformation>(draw, totalSize, totalSize, BeanPage);
            return dataModel;
        } catch (CannotGetJdbcConnectionException e) {
            return "fail";
        }
    }

    public List<GuestInformation> listBySearch(String search, List<GuestInformation> reportList) {
        List<GuestInformation> list = new ArrayList<>();
        for (GuestInformation versionInfo : reportList) {
            if (versionInfo.toString().contains(search)) {
                list.add(versionInfo);
            }
        }
        return list;
    }


    /**
     * 获取所有信息记录
     */
    /*@RequestMapping(value = "/getAllAppList1.do", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getAllAppList1(){
        GeneralResult<List<GuestInformation>> listGeneralResult = guestOpreationService.queryGuestInformations();
        logger.info("@queryGuestInformations params ：{}", JsonUtil.objToStr(listGeneralResult));
        return listGeneralResult;
    }*/

    /**
     * 获取指定信息记录
     */
    @RequestMapping(value = "/queryIdGuestInformation/{id}.do", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public GeneralResult queryIdGuestInformation(@PathVariable Long id) {
        logger.info("@queryIdGuestInformation params ：{}", JsonUtil.objToStr(id));
        return guestOpreationService.queryIdGuestInformation(id);
    }


}
