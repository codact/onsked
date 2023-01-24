package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="appointment_rating")
public class AppointmentRating implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ratingId;

    @Column(name="appt_id")
    private Integer apptId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="rating")
    private Integer rating;

    @Column(name="comments")
    private String comments;

    @Column(name="rated_date")
    private Date ratedDate;

}
