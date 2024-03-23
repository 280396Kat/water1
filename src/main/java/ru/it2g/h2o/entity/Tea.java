package ru.it2g.h2o.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Tea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "vendor_code")
    private Integer vendorCode;

    @Column(name = "is_stock")
    private Boolean isStock;

    @ManyToOne
    @JoinColumn(name = "fk_catalog_id")
    private Catalog catalog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea tea = (Tea) o;
        return Objects.equals(id, tea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
