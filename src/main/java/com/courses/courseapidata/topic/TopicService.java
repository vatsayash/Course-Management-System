package com.courses.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;



    public List<Topic> getAllTopics()
    {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
        .forEach(topics::add);
        return topics;
    }


    public void addTopic(Topic topic)
    {
        topicRepository.save(topic);
    }

    public Topic getTopic(String id){
       return topicRepository.findById(id).get();
    }

    public void updateTopic(Topic topic){
        topicRepository.save(topic);
    }

    public  void deleteTopic(String id){
        topicRepository.deleteById(id);
    }

}
