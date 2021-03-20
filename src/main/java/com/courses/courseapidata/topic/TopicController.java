package com.courses.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {


    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{foo}")
    public Topic getTopic(@PathVariable("foo") String id)
    {
        return topicService.getTopic(id);
    }


    //post request
    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    //put request
    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{foo}")
    public void updateTopic(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    //delete request
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{foo}")
    public void deleteTopic(@PathVariable("foo") String id){
        topicService.deleteTopic(id);
    }

}
