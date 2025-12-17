package com.example.CRUDApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column
    private String email;

    @Column(name = "sentiment_analysis")
    private boolean sentimentAnalysis;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;     //Spring Security expects the ROLE_ prefix

}
