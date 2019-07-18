package cn.wqgallery.mygreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/***
 * 注解解释：
 *
 * 1、@Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作。
 *
 * 2、@Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值。
 *
 * 3、@Property：可以自定义字段名，注意外键不能使用该属性。
 *
 * 4、@NotNull：属性不能为空。
 *
 * 5、@Transient：使用该注释的属性不会被存入数据库的字段中。
 *
 * 6、@Unique：该属性值必须在数据库中是唯一值。
 *
 * 7、@Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改。
 */
@Entity
public class User {
    @Id
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Transient
    private int tempUsageCount; // not persisted



    @Generated(hash = 873297011)
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tempUsageCount=" + tempUsageCount +
                '}';
    }
}