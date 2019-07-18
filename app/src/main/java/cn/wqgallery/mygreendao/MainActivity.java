package cn.wqgallery.mygreendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.com.sky.downloader.greendao.TextBeanDao;
import com.com.sky.downloader.greendao.UserDao;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    UserDao userDao;
    TextBeanDao textBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDao = MyApp.getDaoSession().getUserDao();
        textBeanDao = MyApp.getDaoSession().getTextBeanDao();
    }


    List<User> list=new ArrayList<>();
    public void insert(View view) {
        User user = new User();
        user.setName("张");

        User user2 = new User();
        user2.setName("赵宇");

        User user3 = new User();
        user3.setName("诸葛亮");


        User user4 = new User();
        user4.setName("李四");

        User user5 = new User();
        user5.setName("万物");

        User user6= new User();
        user6.setName("精灵");

        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);

        //插入当个数据
//        userDao.insert(user);
        //插入一个集合
        userDao.insertInTx(list);
    }


    /**
     * ID从1开始
     */
    public void delete(View view) {
        //删除指定对象（参数id值）
//        userDao.deleteByKey(Long.valueOf(1));
        //删除所有
        userDao.deleteAll();

    }

    /**
     * 修改
     *
     * @param view
     */
    public void update(View view) {
        //修改指定的对象
//        User load = userDao.load(Long.valueOf(1));
//        load.setName("黄忠");
//        userDao.update(load);

        //全部修改
        List<User> list = userDao.loadAll();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(0);
            switch (i) {
                case 0:
                    user.setName("曹操");
                    break;
                case 1:
                    user.setName("曹植");
                    break;
                case 2:
                    user.setName("曹冲");
                    break;
            }
        }

        userDao.updateInTx(list);
    }

    //查询
    public void load(View view) {

        //获取指定对象
        //        String name = userDao.load(Long.valueOf(1)).getName();

        //获取所有对象
        List<User> list = userDao.loadAll();

        Log.e("zdh", "-------" + list.toString());


    }



    public void paging(View view) {
        List<User> list = queryPaging(1, 3);
        Log.e("zdh", "-------分页查询" + list.toString());
    }


    /**
     *  分页加载
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可) 从0开始算
     * @param pageNum  每页显示多少个
     * @return
     */
    public  List<User> queryPaging( int pageSize, int pageNum){
        List<User> listMsg = userDao.queryBuilder().offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }
}
