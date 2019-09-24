package com.qf.project.mapper;

import com.qf.project.entity.Studentinfo;

import java.util.List;

/**
 * @author Administrator
 */
public interface StudentinfoDao {
    /**
     * 获取数据列表
     * @return
     */
    List<Studentinfo> getList();

    /**
     *根据id查询一条记录
     */
    Studentinfo findById(int id);

    /**
     * 增加一条记录
     */
     int add(Studentinfo studentinfo);

    /**
     * 修改一条记录
     *
     */
    int update(Studentinfo studentinfo);

    /**
     * 删除数据
     */
    int delete(String uid);
}
