package com.example.oasiscab;

//import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class User {

        private String uid;
        private String username;
        private String name;
        @Nullable
        private String urlPicture;

        public User() { }

        public User(String uid, String username, String urlPicture, String name) {
            this.uid = uid;
            this.username = username;
            this.urlPicture = urlPicture;
            this.name = name;
        }

        // --- GETTERS ---
        public String getUid() { return uid; }
        public String getUsername() { return username; }
        public String getUrlPicture() { return urlPicture; }
        public String getIName() { return name; }

        // --- SETTERS ---
        public void setUsername(String username) { this.username = username; }
        public void setUid(String uid) { this.uid = uid; }
        public void setUrlPicture(String urlPicture) { this.urlPicture = urlPicture; }
        public void setName(String mentor) { name = mentor; }

}
