package Data.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CourseToTeacher")
public class CourseToTeacher {

    @EmbeddedId
    private Key key;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Embeddable
    public class Key implements Serializable {

        @Column(name = "course_id")
        private Integer courseId;

        @Column(name = "teacher_id")
        private Integer teacherId;

        public Key(Integer courseId, Integer teacherId) {
            this.courseId = courseId;
            this.teacherId = teacherId;
        }

        public Integer getCourseId() {
            return courseId;
        }

        public void setCourseId(Integer courseId) {
            this.courseId = courseId;
        }

        public Integer getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(Integer teacherId) {
            this.teacherId = teacherId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(courseId, key.courseId) && Objects.equals(teacherId, key.teacherId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(courseId, teacherId);
        }
    }
}