package com.example.usedstaffsaleapplication.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Advert_comment")
@AllArgsConstructor
@NoArgsConstructor

public class AdvertComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Standart_user_id",referencedColumnName = "id")
    private StandartUsers standartUsers;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "advert_id",referencedColumnName = "id")
    private Advert advert;

    private String comment;


}