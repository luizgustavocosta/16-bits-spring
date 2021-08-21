package com.costa.luiz.twitter.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NamedQuery(name = "Post.findAllByUserAndPost",
        query = "select post from Post post where post.user = ?1 and post.content like CONCAT('%',?2,'%')")
public class Post {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String user;
    private String content;
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

}
