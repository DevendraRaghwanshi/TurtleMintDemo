package com.turtlemint.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.turtlemint.utils.DataConverter;

import java.util.List;

@Entity(tableName = "Issues")
@TypeConverters({DataConverter.class})
public class IssuesModel {
    @PrimaryKey
    @SerializedName("id")
    private long id;
    @SerializedName("state_reason")
    private String state_reason;
    @SerializedName("timeline_url")
    private String timeline_url;
    @SerializedName("body")
    private String body;
    @SerializedName("author_association")
    private String author_association;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("comments")
    private int comments;
    @SerializedName("locked")
    private boolean locked;
    @SerializedName("state")
    private String state;
    @SerializedName("title")
    private String title;
    @SerializedName("number")
    private int number;
    @SerializedName("node_id")
    private String node_id;
    @SerializedName("html_url")
    private String html_url;
    @SerializedName("events_url")
    private String events_url;
    @SerializedName("comments_url")
    private String comments_url;
    @SerializedName("labels_url")
    private String labels_url;
    @SerializedName("repository_url")
    private String repository_url;
    @SerializedName("url")
    private String url;
    @TypeConverters({DataConverter.class})
    @SerializedName("user")
    private UserEntity user;
    @Ignore
    @SerializedName("labels")
    private List<LabelsEntity> labels;
    @Ignore
    @SerializedName("reactions")
    private ReactionsEntity reactions;


    public void setId(long id) {
        this.id = id;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setLabels(List<LabelsEntity> labels) {
        this.labels = labels;
    }

    public String getState_reason() {
        return state_reason;
    }

    public void setState_reason(String state_reason) {
        this.state_reason = state_reason;
    }

    public String getTimeline_url() {
        return timeline_url;
    }

    public void setTimeline_url(String timeline_url) {
        this.timeline_url = timeline_url;
    }

    public ReactionsEntity getReactions() {
        return reactions;
    }

    public void setReactions(ReactionsEntity reactions) {
        this.reactions = reactions;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor_association() {
        return author_association;
    }

    public void setAuthor_association(String author_association) {
        this.author_association = author_association;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getComments() {
        return comments;
    }

    public String getState() {
        return state;
    }

    public List<LabelsEntity> getLabels() {
        return labels;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public long getId() {
        return id;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class ReactionsEntity {
        @SerializedName("eyes")
        private int eyes;
        @SerializedName("rocket")
        private int rocket;
        @SerializedName("heart")
        private int heart;
        @SerializedName("confused")
        private int confused;
        @SerializedName("hooray")
        private int hooray;
        @SerializedName("laugh")
        private int laugh;
        @SerializedName("total_count")
        private int total_count;
        @SerializedName("url")
        private String url;

        public int getEyes() {
            return eyes;
        }

        public void setEyes(int eyes) {
            this.eyes = eyes;
        }

        public int getRocket() {
            return rocket;
        }

        public void setRocket(int rocket) {
            this.rocket = rocket;
        }

        public int getHeart() {
            return heart;
        }

        public void setHeart(int heart) {
            this.heart = heart;
        }

        public int getConfused() {
            return confused;
        }

        public void setConfused(int confused) {
            this.confused = confused;
        }

        public int getHooray() {
            return hooray;
        }

        public void setHooray(int hooray) {
            this.hooray = hooray;
        }

        public int getLaugh() {
            return laugh;
        }

        public void setLaugh(int laugh) {
            this.laugh = laugh;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class LabelsEntity {
        @SerializedName("description")
        private String description;
        @SerializedName("default")
        private boolean default1;
        @SerializedName("color")
        private String color;
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;
        @SerializedName("node_id")
        private String node_id;
        @SerializedName("id")
        private long id;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean default1() {
            return default1;
        }

        public void default1(boolean default1) {
            this.default1 = default1;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNode_id() {
            return node_id;
        }

        public void setNode_id(String node_id) {
            this.node_id = node_id;
        }

        public long getId() {
            return id;
        }
    }

    public static class UserEntity {
        @SerializedName("site_admin")
        private boolean site_admin;
        @SerializedName("type")
        private String type;
        @SerializedName("received_events_url")
        private String received_events_url;
        @SerializedName("events_url")
        private String events_url;
        @SerializedName("repos_url")
        private String repos_url;
        @SerializedName("organizations_url")
        private String organizations_url;
        @SerializedName("subscriptions_url")
        private String subscriptions_url;
        @SerializedName("starred_url")
        private String starred_url;
        @SerializedName("gists_url")
        private String gists_url;
        @SerializedName("following_url")
        private String following_url;
        @SerializedName("followers_url")
        private String followers_url;
        @SerializedName("html_url")
        private String html_url;
        @SerializedName("url")
        private String url;
        @SerializedName("gravatar_id")
        private String gravatar_id;
        @SerializedName("avatar_url")
        private String avatar_url;
        @SerializedName("node_id")
        private String node_id;
        @SerializedName("id")
        private int id;
        @SerializedName("login")
        private String login;

        public boolean getSite_admin() {
            return site_admin;
        }

        public void setSite_admin(boolean site_admin) {
            this.site_admin = site_admin;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReceived_events_url() {
            return received_events_url;
        }

        public void setReceived_events_url(String received_events_url) {
            this.received_events_url = received_events_url;
        }

        public String getEvents_url() {
            return events_url;
        }

        public void setEvents_url(String events_url) {
            this.events_url = events_url;
        }

        public String getRepos_url() {
            return repos_url;
        }

        public void setRepos_url(String repos_url) {
            this.repos_url = repos_url;
        }

        public String getOrganizations_url() {
            return organizations_url;
        }

        public void setOrganizations_url(String organizations_url) {
            this.organizations_url = organizations_url;
        }

        public String getSubscriptions_url() {
            return subscriptions_url;
        }

        public void setSubscriptions_url(String subscriptions_url) {
            this.subscriptions_url = subscriptions_url;
        }

        public String getStarred_url() {
            return starred_url;
        }

        public void setStarred_url(String starred_url) {
            this.starred_url = starred_url;
        }

        public String getGists_url() {
            return gists_url;
        }

        public void setGists_url(String gists_url) {
            this.gists_url = gists_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public void setGravatar_id(String gravatar_id) {
            this.gravatar_id = gravatar_id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getNode_id() {
            return node_id;
        }

        public void setNode_id(String node_id) {
            this.node_id = node_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }
}
