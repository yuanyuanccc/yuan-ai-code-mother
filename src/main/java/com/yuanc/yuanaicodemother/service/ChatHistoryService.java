package com.yuanc.yuanaicodemother.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yuanc.yuanaicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.yuanc.yuanaicodemother.model.entity.ChatHistory;
import com.yuanc.yuanaicodemother.model.entity.User;

import java.time.LocalDateTime;

/**
 *  服务层。
 *
 * @author yuanc
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    boolean deleteByAppId(Long appId);

    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);


    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);
}
