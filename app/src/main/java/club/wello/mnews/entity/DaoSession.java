package club.wello.mnews.entity;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import club.wello.mnews.entity.News;
import club.wello.mnews.entity.ThemeList;

import club.wello.mnews.entity.NewsDao;
import club.wello.mnews.entity.ThemeListDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig newsDaoConfig;
    private final DaoConfig themeListDaoConfig;

    private final NewsDao newsDao;
    private final ThemeListDao themeListDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        newsDaoConfig = daoConfigMap.get(NewsDao.class).clone();
        newsDaoConfig.initIdentityScope(type);

        themeListDaoConfig = daoConfigMap.get(ThemeListDao.class).clone();
        themeListDaoConfig.initIdentityScope(type);

        newsDao = new NewsDao(newsDaoConfig, this);
        themeListDao = new ThemeListDao(themeListDaoConfig, this);

        registerDao(News.class, newsDao);
        registerDao(ThemeList.class, themeListDao);
    }
    
    public void clear() {
        newsDaoConfig.clearIdentityScope();
        themeListDaoConfig.clearIdentityScope();
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public ThemeListDao getThemeListDao() {
        return themeListDao;
    }

}
