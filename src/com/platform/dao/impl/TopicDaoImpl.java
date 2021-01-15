package com.platform.dao.impl;

import com.platform.dao.TopicDao;
import com.platform.entity.Topic;
import com.platform.entity.Users;
import com.platform.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl implements TopicDao {

    //新增话题
    public void addNewTopic(Topic topic) throws Exception {
        String topicId = topic.getTopicId();
        String userId = topic.getUserId();
        String date = topic.getDate();
        int viewNum = topic.getViewNum();
        String title = topic.getTitle();
        String content = topic.getContent();
        String status = topic.getStatus();
        String userName = topic.getUserName();

        String sqlStr = "insert into topic(topicId,userId,date,viewNum,title,content,status,userName) values(?,?,?,?,?,?,?,?)";
        JDBCUtil.executeUpdate(sqlStr,new Object[]{topicId,userId,date,viewNum,title,content,status,userName});
    }

    //查询置顶话题
    public List<Topic> findSpecialTopic() throws Exception {
        String sqlStr = "select * from topic where status = 0";
        List<Topic> specialTopicList = selectTopicBySql(sqlStr,new Object[]{});
        return specialTopicList;
    }

    //查询普通话题
    public List<Topic> findNormalTopic() throws Exception {
        String sqlStr = "select * from topic where status = 1";
        List<Topic> normalTopicList = selectTopicBySql(sqlStr,new Object[]{});
        return normalTopicList;
    }

    //查询全部话题
    public List<Topic> findAllTopic() throws Exception {
        String sqlStr = "select * from topic";
        List<Topic> allTopicList = selectTopicBySql(sqlStr,new Object[]{});
        return allTopicList;
    }

    private List<Topic> selectTopicBySql(String sqlStr, Object[] objs) throws Exception{
        JDBCUtil.getConnection();
        JDBCUtil.prestatement = JDBCUtil.conn.prepareStatement(sqlStr);
        if(objs != null && objs.length != 0){
            for(int i=0;i<objs.length;i++){
                JDBCUtil.prestatement.setObject(i+1, objs[i]);
            }
        }
        JDBCUtil.rst = JDBCUtil.prestatement.executeQuery();
        List<Topic> topicList = new ArrayList<Topic>();
        while(JDBCUtil.rst.next()){
            Topic topic = new Topic();
            topic.setTopicId(JDBCUtil.rst.getString("topicId"));
            topic.setUserId(JDBCUtil.rst.getString("userId"));
            topic.setDate(JDBCUtil.rst.getString("date"));
            topic.setViewNum(JDBCUtil.rst.getInt("viewNum"));
            topic.setStatus(JDBCUtil.rst.getString("status"));
            topic.setTitle(JDBCUtil.rst.getString("title"));
            topic.setContent(JDBCUtil.rst.getString("content"));
            topic.setUserName(JDBCUtil.rst.getString("userName"));
            topicList.add(topic);
        }
        return topicList;

    }
}
