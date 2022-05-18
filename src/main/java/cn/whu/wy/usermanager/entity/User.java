package cn.whu.wy.usermanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String name;
    private String gender;
    private Long salary;
    private String password;
    private String phone;
    private java.sql.Timestamp registerTime;
    private java.sql.Timestamp lastLoginTime;
    private String role;
    private Boolean enabled;

}
