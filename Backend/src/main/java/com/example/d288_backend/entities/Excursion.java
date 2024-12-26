package com.example.d288_backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "excursion_title", nullable = false)
    @JsonProperty("excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price", nullable = false)
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions", fetch = FetchType.LAZY)
    private Set<CartItem> cartItems;

}
