/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.bigtop.manager.server.service.impl;

import org.apache.bigtop.manager.dao.entity.User;
import org.apache.bigtop.manager.dao.repository.UserRepository;
import org.apache.bigtop.manager.server.enums.ApiExceptionEnum;
import org.apache.bigtop.manager.server.exception.ApiException;
import org.apache.bigtop.manager.server.holder.SessionUserHolder;
import org.apache.bigtop.manager.server.model.converter.UserConverter;
import org.apache.bigtop.manager.server.model.dto.UserDTO;
import org.apache.bigtop.manager.server.model.vo.UserVO;
import org.apache.bigtop.manager.server.service.UserService;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserVO current() {
        Long id = SessionUserHolder.getUserId();
        User user = userRepository.findById(id).orElseThrow(() -> new ApiException(ApiExceptionEnum.NEED_LOGIN));
        return UserConverter.INSTANCE.fromEntity2VO(user);
    }

    @Override
    public UserVO update(UserDTO userDTO) {
        Long id = SessionUserHolder.getUserId();
        User user = userRepository.findById(id).orElseThrow(() -> new ApiException(ApiExceptionEnum.NEED_LOGIN));
        user.setNickname(userDTO.getNickname());
        userRepository.save(user);
        return UserConverter.INSTANCE.fromEntity2VO(user);
    }
}
