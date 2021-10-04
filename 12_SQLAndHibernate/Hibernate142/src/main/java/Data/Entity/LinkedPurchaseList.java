package Data.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey linkedPurchaseList;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer courseId;

    public LinkedPurchaseListKey getLinkedPurchaseList() {
        return linkedPurchaseList;
    }

    public void setLinkedPurchaseList(LinkedPurchaseListKey linkedPurchaseList) {
        this.linkedPurchaseList = linkedPurchaseList;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Embeddable
    public static class LinkedPurchaseListKey implements Serializable {

        @Column(name = "student_id")
        private Integer studentId;

        @Column(name = "course_id")
        private Integer courseId;

        public LinkedPurchaseListKey(Integer courseId, Integer studentId) {
            this.courseId = courseId;
            this.studentId = studentId;
        }

        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public Integer getCourseId() {
            return courseId;
        }

        public void setCourseId(Integer courseId) {
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinkedPurchaseList that = (LinkedPurchaseList) o;
            return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, courseId);
        }
    }
}