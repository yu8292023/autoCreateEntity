package com.buer.entity;/**
 * Created by yuhaining on 2019/9/23.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @ClassName:SysPermissionEntity
 * @Author:yuhaining
 * @Date:2019/9/23
 */
public class SysPermissionEntity implements Serializable {
        private static final long serialVersionUID = 353629772108330570L;
        private Integer id;
        private String name;
        private List<SysRoleEntity> roles;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SysRoleEntity> getRoles() {
            return roles;
        }

        public void setRoles(List<SysRoleEntity> roles) {
            this.roles = roles;
        }
}
