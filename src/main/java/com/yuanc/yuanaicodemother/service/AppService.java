package com.yuanc.yuanaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yuanc.yuanaicodemother.model.dto.app.AppQueryRequest;
import com.yuanc.yuanaicodemother.model.entity.App;
import com.yuanc.yuanaicodemother.model.entity.User;
import com.yuanc.yuanaicodemother.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 *  服务层。
 *
 * @author yuanc
 */
public interface AppService extends IService<App> {

    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);

    List<AppVO> getAppVOList(List<App> appList);
}
