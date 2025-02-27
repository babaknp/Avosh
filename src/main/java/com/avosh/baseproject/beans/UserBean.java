package com.avosh.baseproject.beans;

import com.avosh.baseproject.dto.UserDto;
import com.avosh.baseproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Scope("session")
public class UserBean extends BaseBean<UserService, UserDto> {
    private boolean isEditMode;
    private List<UserDto> dtoList;
    private UserDto userDto;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        dtoList = service.retrieveAll();
        userDto = new UserDto();
    }

    public List<UserDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<UserDto> dtoList) {
        this.dtoList = dtoList;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public boolean isEditMode() {
        return isEditMode;
    }

    @Override
    public void save() {

    }


    public void deleteRecord() {

    }
}
