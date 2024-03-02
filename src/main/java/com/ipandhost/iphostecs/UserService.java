package com.ipandhost.iphostecs;

import java.util.List;

public interface UserService {
    String creatUser(UserDto userDto);
    List<UserDto> getUsers();
}
