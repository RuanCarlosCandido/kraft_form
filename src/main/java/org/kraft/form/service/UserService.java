package org.kraft.form.service;

import java.util.List;

import org.kraft.form.domain.entities.UserInfo;
import org.kraft.form.domain.repositories.UserInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserInfoRepository userInfoRepository;

  public UserService(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  public List<UserInfo> getUsers() {
    return userInfoRepository.findAll();
  }

  public UserInfo createUser(UserInfo userInfo) {
    return userInfoRepository.save(userInfo);
  }

}
