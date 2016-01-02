package ru.rsoft.configurator.core.entity;


import javax.persistence.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;


/**
 * Created by Admin on 16.11.2015.
 */
@Entity
@Table(name="VILLAGES")
public class Village {




    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PLAYER_ID", nullable = false)
    @Nonnull
    private Player player;

    @Column (name = "NAME", nullable = true)
    @Nullable
    private String name;


    @Column (name = "ID_IN_WORLD", nullable = false)
    @Nonnull
    private Integer idInWorld;

    public Village() {
        this(new Player(new User("",""), ""), "", 0);

    }

    public Village(@Nonnull Player player,@Nullable String name, @Nonnull Integer idInWorld) {
//        final UserRepository userRepository1;
//        final User user1 = userRepository1.findOne(1);
//        user == null  ? null : user = userRepository.findOne(1);

//        if (user == null) {
//            user = new User("1","1");
//            user.setId(1);}
//        player == null ? null : player = playerRepository.findOne(1);
        this.player = Objects.requireNonNull(player, "player for a village must not be null");
        this.name = name;
        this.idInWorld = idInWorld;
    }

    public Integer getId() {
        return id;
    }

    public void setId(@Nonnull Integer id) {
        this.id = id;
    }

    @Nullable
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(@Nullable Player player) {
        this.player = player;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nonnull
    public Integer getIdInWorld() {
        return idInWorld;
    }

    public void setIdInWorld(@Nonnull Integer idInWorld) {
        this.idInWorld = idInWorld;
    }

/*
    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
*/

    @Override
    public String toString() {
        return "Village{" +
                "id=" + id +
                ", player='" + player + '\'' +
                ", name='" + name + '\'' +
                ", idInWorld='" + idInWorld + '\'' +
                '}';
    }
}