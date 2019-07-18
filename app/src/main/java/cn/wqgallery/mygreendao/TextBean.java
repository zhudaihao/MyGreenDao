package cn.wqgallery.mygreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TextBean {
    @Id
    Long id;
    String name;
    String password;
    @Generated(hash = 299429093)
    public TextBean(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Generated(hash = 809912491)
    public TextBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }




}
