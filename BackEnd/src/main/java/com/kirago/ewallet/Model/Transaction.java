package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "id_transaction")
    private String id;

    private Long montant;

    @Column(name = "type_transaction")
    private String typeTransaction;

    @Column(name = "date_transaction")
    private LocalDateTime dateTransaction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compte_source", nullable = false)
    private Compte compteSource;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compte_cible", nullable = false)
    private Compte compteCible;

    @Lob
    private String qrCodeBase64;

    public Transaction(Long montant, Compte compteSource, Compte compteCible) {
        this.montant = montant;
        this.compteSource = compteSource;
        this.compteCible = compteCible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}