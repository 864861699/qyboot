package com.ax.service.daomain;

import com.ax.service.model.po.Login;
import java.util.List;

public interface LoginMapper {
    int insert(Login record);

    List<Login> selectAll();
}