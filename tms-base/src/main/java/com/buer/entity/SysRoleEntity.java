package com.buer.entity;/**
 * Created by yuhaining on 2019/9/23.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @ClassName:SysRoleEntity
 * @Author:yuhaining
 * @Date:2019/9/23
 */
public class SysRoleEntity implements Serializable{
        private static final long serialVersionUID = -8687790154329829056L;
        private Integer id;
        private String role;
        private List<SysPermissionEntity> permissions;
        private List<User> users;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public List<SysPermissionEntity> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<SysPermissionEntity> permissions) {
            this.permissions = permissions;
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
}
