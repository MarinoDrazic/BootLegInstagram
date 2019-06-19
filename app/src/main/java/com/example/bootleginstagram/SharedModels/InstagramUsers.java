package com.example.bootleginstagram.SharedModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstagramUsers implements Parcelable {

    //region BASE
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("user")
    @Expose
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//endregion

    public static class ProfileImage_ implements Parcelable {

        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.small);
            dest.writeString(this.medium);
            dest.writeString(this.large);
        }

        public ProfileImage_() {
        }

        protected ProfileImage_(Parcel in) {
            this.small = in.readString();
            this.medium = in.readString();
            this.large = in.readString();
        }

        public static final Parcelable.Creator<ProfileImage_> CREATOR = new Parcelable.Creator<ProfileImage_>() {
            @Override
            public ProfileImage_ createFromParcel(Parcel source) {
                return new ProfileImage_(source);
            }

            @Override
            public ProfileImage_[] newArray(int size) {
                return new ProfileImage_[size];
            }
        };
    }

    public static class Urls implements Parcelable {

        @SerializedName("raw")
        @Expose
        private String raw;
        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("regular")
        @Expose
        private String regular;
        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("thumb")
        @Expose
        private String thumb;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.raw);
            dest.writeString(this.full);
            dest.writeString(this.regular);
            dest.writeString(this.small);
            dest.writeString(this.thumb);
        }

        public Urls() {
        }

        protected Urls(Parcel in) {
            this.raw = in.readString();
            this.full = in.readString();
            this.regular = in.readString();
            this.small = in.readString();
            this.thumb = in.readString();
        }

        public static final Parcelable.Creator<Urls> CREATOR = new Parcelable.Creator<Urls>() {
            @Override
            public Urls createFromParcel(Parcel source) {
                return new Urls(source);
            }

            @Override
            public Urls[] newArray(int size) {
                return new Urls[size];
            }
        };
    }
    public static class User implements Parcelable {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("twitter_username")
        @Expose
        private String twitterUsername;
        @SerializedName("portfolio_url")
        @Expose
        private String portfolioUrl;
        @SerializedName("bio")
        @Expose
        private String bio;
        @SerializedName("location")
        @Expose
        private String location;

        @SerializedName("profile_image")
        @Expose
        private ProfileImage_ profileImage;
        @SerializedName("instagram_username")
        @Expose
        private String instagramUsername;
        @SerializedName("total_collections")
        @Expose
        private Integer totalCollections;
        @SerializedName("total_likes")
        @Expose
        private Integer totalLikes;
        @SerializedName("total_photos")
        @Expose
        private Integer totalPhotos;
        @SerializedName("accepted_tos")
        @Expose
        private Boolean acceptedTos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getTwitterUsername() {
            return twitterUsername;
        }

        public void setTwitterUsername(String twitterUsername) {
            this.twitterUsername = twitterUsername;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public ProfileImage_ getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(ProfileImage_ profileImage) {
            this.profileImage = profileImage;
        }

        public String getInstagramUsername() {
            return instagramUsername;
        }

        public void setInstagramUsername(String instagramUsername) {
            this.instagramUsername = instagramUsername;
        }

        public Integer getTotalCollections() {
            return totalCollections;
        }

        public void setTotalCollections(Integer totalCollections) {
            this.totalCollections = totalCollections;
        }

        public Integer getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(Integer totalLikes) {
            this.totalLikes = totalLikes;
        }

        public Integer getTotalPhotos() {
            return totalPhotos;
        }

        public void setTotalPhotos(Integer totalPhotos) {
            this.totalPhotos = totalPhotos;
        }

        public Boolean getAcceptedTos() {
            return acceptedTos;
        }

        public void setAcceptedTos(Boolean acceptedTos) {
            this.acceptedTos = acceptedTos;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.updatedAt);
            dest.writeString(this.username);
            dest.writeString(this.name);
            dest.writeString(this.firstName);
            dest.writeString(this.lastName);
            dest.writeString(this.twitterUsername);
            dest.writeString(this.portfolioUrl);
            dest.writeString(this.bio);
            dest.writeString(this.location);
            dest.writeParcelable(this.profileImage, flags);
            dest.writeString(this.instagramUsername);
            dest.writeValue(this.totalCollections);
            dest.writeValue(this.totalLikes);
            dest.writeValue(this.totalPhotos);
            dest.writeValue(this.acceptedTos);
        }

        public User() {
        }

        protected User(Parcel in) {
            this.id = in.readString();
            this.updatedAt = in.readString();
            this.username = in.readString();
            this.name = in.readString();
            this.firstName = in.readString();
            this.lastName = in.readString();
            this.twitterUsername = in.readString();
            this.portfolioUrl = in.readString();
            this.bio = in.readString();
            this.location = in.readString();
            this.profileImage = in.readParcelable(ProfileImage_.class.getClassLoader());
            this.instagramUsername = in.readString();
            this.totalCollections = (Integer) in.readValue(Integer.class.getClassLoader());
            this.totalLikes = (Integer) in.readValue(Integer.class.getClassLoader());
            this.totalPhotos = (Integer) in.readValue(Integer.class.getClassLoader());
            this.acceptedTos = (Boolean) in.readValue(Boolean.class.getClassLoader());
        }

        public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
            @Override
            public User createFromParcel(Parcel source) {
                return new User(source);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.color);
        dest.writeString(this.description);
        dest.writeParcelable(this.urls, flags);
        dest.writeValue(this.likes);
        dest.writeParcelable(this.user, flags);
    }

    public InstagramUsers() {
    }

    protected InstagramUsers(Parcel in) {
        this.id = in.readString();
        this.color = in.readString();
        this.description = in.readString();
        this.urls = in.readParcelable(Urls.class.getClassLoader());
        this.likes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Parcelable.Creator<InstagramUsers> CREATOR = new Parcelable.Creator<InstagramUsers>() {
        @Override
        public InstagramUsers createFromParcel(Parcel source) {
            return new InstagramUsers(source);
        }

        @Override
        public InstagramUsers[] newArray(int size) {
            return new InstagramUsers[size];
        }
    };
}
