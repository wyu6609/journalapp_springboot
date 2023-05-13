package com.example.demo.model;


import jakarta.persistence.*;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name ="journals")
public class Journal {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter
        @Setter
        private Long id;

        @Column(name = "title")
        @Getter
        @Setter
        private String title;

        @Column(name = "content")
        @Getter
        @Setter
        private String content;

        // getters and setters

    }

