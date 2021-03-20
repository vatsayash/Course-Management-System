package com.courses.courseapidata.course;

import com.courses.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {


    @Autowired
    private CourseService courseService;

//    get all course under topicId id
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourse(@PathVariable("id") String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable("courseId") String id)
    {
        return courseService.getCourse(id);
    }


    //post request
    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    //put request
    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    //delete request
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{courseId}")
    public void deleteTopic(@PathVariable("courseId") String courseId){
        courseService.deleteCourse(courseId);
    }

}
