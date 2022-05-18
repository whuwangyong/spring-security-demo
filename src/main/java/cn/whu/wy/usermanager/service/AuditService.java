package cn.whu.wy.usermanager.service;

import cn.whu.wy.usermanager.entity.OperationLog;
import cn.whu.wy.usermanager.mapper.IOperationLogMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService  {

    @Autowired
    private IOperationLogMapper operationLogMapper;


    @Autowired
    private Gson gson;
    @Autowired
    private KafkaTemplate<String, String> template;

    public void writeLog(Object obj) {
        template.send("salary-adjustment", gson.toJson(obj));
    }

    public List<OperationLog> getAllOps(){
        return operationLogMapper.selectAll();
    }

}
