package com.kadu.RpgManager.entities;

import java.util.UUID;

import com.kadu.RpgManager.enums.RPGSystem;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_rpgStory")
public class RpgStory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private RPGSystem system;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public RpgStory() {
    }

    public RpgStory(UUID id, String title,RPGSystem system, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.system = system;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RPGSystem getSystem() {
         return system; 
        }

    public void setSystem(RPGSystem system) {
         this.system = system; 
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RpgStory other = (RpgStory) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
