package com.buer.entity;/**
 * Created by yuhaining on 2019/9/23.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @ClassName:UserEntity
 * @Author:yuhaining
 * @Date:2019/9/23
 */
public class UserEntity implements Serializable {
        private static final long serialVersionUID = -3320971805590503443L;
        private long id;
        private String username;
        private String password;
        private String salt;
        private List<SysRoleEntity> roles;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public List<SysRoleEntity> getRoles() {
            return roles;
        }

        public void setRoles(List<SysRoleEntity> roles) {
            this.roles = roles;
        }

        public String getCredentialsSalt() {
            return username + salt;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", username=" + username + "]";
        }
}
