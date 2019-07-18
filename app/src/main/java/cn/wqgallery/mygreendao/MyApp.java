package cn.wqgallery.mygreendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.com.sky.downloader.greendao.DaoMaster;
import com.com.sky.downloader.greendao.DaoSession;


public class MyApp extends Application {
    private static final String DATA_BASE_NAME = "zdh-db";//数据库名
    private static DaoSession daoSession;//DaoMaster的管理者

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化greenDao 配置数据库
        initGreenDao();
    }

    private void initGreenDao() {
        //创建数据库 zdh-db
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, DATA_BASE_NAME,null);
        //获取可写数据库
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    //创建个获取daoSession对象方法
    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
