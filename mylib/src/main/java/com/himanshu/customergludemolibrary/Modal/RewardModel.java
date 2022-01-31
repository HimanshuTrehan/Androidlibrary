package com.himanshu.customergludemolibrary.Modal;

import java.util.List;

public class RewardModel {
    public RewardModel(String success, String defaultUrl, DefaultBanner defaultBanner, List<Campaigns> campaigns) {
        this.success = success;
        this.defaultUrl = defaultUrl;
        this.defaultBanner = defaultBanner;
        this.campaigns = campaigns;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public DefaultBanner getDefaultBanner() {
        return defaultBanner;
    }

    public void setDefaultBanner(DefaultBanner defaultBanner) {
        this.defaultBanner = defaultBanner;
    }

    public List<Campaigns> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaigns> campaigns) {
        this.campaigns = campaigns;
    }

    public String success;
    public String defaultUrl;
    public DefaultBanner defaultBanner;
    public List<Campaigns> campaigns;


    public class DefaultBanner
    {

    }

    public class Campaigns
    {
        public Campaigns(String campaignId, String url, String type, String status, Banner banner) {
            this.campaignId = campaignId;
            this.url = url;
            this.type = type;
            this.status = status;
            this.banner = banner;
        }

        public String getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(String campaignId) {
            this.campaignId = campaignId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Banner getBanner() {
            return banner;
        }

        public void setBanner(Banner banner) {
            this.banner = banner;
        }

        String campaignId;
        String url;
        String type;
        String status;
        Banner banner;
    }

    public class Banner
    {
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTotalUsers() {
            return totalUsers;
        }

        public void setTotalUsers(String totalUsers) {
            this.totalUsers = totalUsers;
        }

        public String getCompletedUsers() {
            return completedUsers;
        }

        public void setCompletedUsers(String completedUsers) {
            this.completedUsers = completedUsers;
        }

        public String getInProgressUsers() {
            return inProgressUsers;
        }

        public void setInProgressUsers(String inProgressUsers) {
            this.inProgressUsers = inProgressUsers;
        }

        public String getTotalSteps() {
            return totalSteps;
        }

        public void setTotalSteps(String totalSteps) {
            this.totalSteps = totalSteps;
        }

        public String getStepsCompleted() {
            return stepsCompleted;
        }

        public void setStepsCompleted(String stepsCompleted) {
            this.stepsCompleted = stepsCompleted;
        }

        public String getStepsRemaining() {
            return stepsRemaining;
        }

        public void setStepsRemaining(String stepsRemaining) {
            this.stepsRemaining = stepsRemaining;
        }

        public Banner(String title, String body, String imageUrl, String totalUsers, String completedUsers, String inProgressUsers, String totalSteps, String stepsCompleted, String stepsRemaining) {
            this.title = title;
            this.body = body;
            this.imageUrl = imageUrl;
            this.totalUsers = totalUsers;
            this.completedUsers = completedUsers;
            this.inProgressUsers = inProgressUsers;
            this.totalSteps = totalSteps;
            this.stepsCompleted = stepsCompleted;
            this.stepsRemaining = stepsRemaining;
        }

        String title;
        String body;
        String imageUrl;
        String totalUsers;
        String completedUsers;
        String inProgressUsers;
        String totalSteps;
        String stepsCompleted;
        String stepsRemaining;
    }

}
