package cn.whu.wy.usermanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {

    @Id
    private Long id;
    private LocalDateTime dateTime;
    private String operation;
    private String operator;

}
