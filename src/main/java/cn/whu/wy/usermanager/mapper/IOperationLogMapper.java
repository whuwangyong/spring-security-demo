package cn.whu.wy.usermanager.mapper;

import cn.whu.wy.usermanager.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface IOperationLogMapper extends BaseMapper<OperationLog> {
}
