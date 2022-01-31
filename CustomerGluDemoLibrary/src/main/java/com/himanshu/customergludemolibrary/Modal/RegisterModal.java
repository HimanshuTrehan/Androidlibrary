package com.himanshu.customergludemolibrary.Modal;

public class RegisterModal {

    public RegisterModal()
    {

    }
    public RegisterModal(String Success, UserData data)
    {
        success = Success;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String Success) {
        success = Success;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public String success;
    public UserData data;

    public class UserData
    {
        public UserData(String token, User user) {
            this.token = token;
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String token;
        public User user;

    }
    public class User
    {
        public User(Profile profile, Identities identities, String id, String userId, String gluId, String userName, String email, String phone, String cookieId, String appVersion, String client, String referralLink, String referredBy, String sessionId, String deviceId, String deviceType) {
            this.profile = profile;
            this.identities = identities;
            this.id = id;
            this.userId = userId;
            this.gluId = gluId;
            this.userName = userName;
            this.email = email;
            this.phone = phone;
            this.cookieId = cookieId;
            this.appVersion = appVersion;
            this.client = client;
            this.referralLink = referralLink;
            this.referredBy = referredBy;
            this.sessionId = sessionId;
            this.deviceId = deviceId;
            this.deviceType = deviceType;
        }

        public Profile getProfile() {
            return profile;
        }

        public void setProfile(Profile profile) {
            this.profile = profile;
        }

        public Identities getIdentities() {
            return identities;
        }

        public void setIdentities(Identities identities) {
            this.identities = identities;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getGluId() {
            return gluId;
        }

        public void setGluId(String gluId) {
            this.gluId = gluId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCookieId() {
            return cookieId;
        }

        public void setCookieId(String cookieId) {
            this.cookieId = cookieId;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }

        public String getReferralLink() {
            return referralLink;
        }

        public void setReferralLink(String referralLink) {
            this.referralLink = referralLink;
        }

        public String getReferredBy() {
            return referredBy;
        }

        public void setReferredBy(String referredBy) {
            this.referredBy = referredBy;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        Profile profile;
        Identities identities;
        String id;
        String userId;
        String gluId;
        String userName;
        String email;
        String phone;
        String cookieId;
        String appVersion;
        String client;
        String referralLink;
        String referredBy;
        String sessionId;
        String deviceId;
        String deviceType;

    }

    public class Profile
    {
        public Profile(String firstName, String lastName, String age, String city, String country, String timezone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
            this.country = country;
            this.timezone = timezone;
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

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        String firstName;
        String lastName;
        String age;
        String city;
        String country;
        String timezone;

    }
    public class Identities
    {
        public Identities(String facebook_id, String google_id, String android_id, String ios_id, String clevertap_id, String mparticle_id, String segment_id, String moengage_id) {
            this.facebook_id = facebook_id;
            this.google_id = google_id;
            this.android_id = android_id;
            this.ios_id = ios_id;
            this.clevertap_id = clevertap_id;
            this.mparticle_id = mparticle_id;
            this.segment_id = segment_id;
            this.moengage_id = moengage_id;
        }

        public String getFacebook_id() {
            return facebook_id;
        }

        public void setFacebook_id(String facebook_id) {
            this.facebook_id = facebook_id;
        }

        public String getGoogle_id() {
            return google_id;
        }

        public void setGoogle_id(String google_id) {
            this.google_id = google_id;
        }

        public String getAndroid_id() {
            return android_id;
        }

        public void setAndroid_id(String android_id) {
            this.android_id = android_id;
        }

        public String getIos_id() {
            return ios_id;
        }

        public void setIos_id(String ios_id) {
            this.ios_id = ios_id;
        }

        public String getClevertap_id() {
            return clevertap_id;
        }

        public void setClevertap_id(String clevertap_id) {
            this.clevertap_id = clevertap_id;
        }

        public String getMparticle_id() {
            return mparticle_id;
        }

        public void setMparticle_id(String mparticle_id) {
            this.mparticle_id = mparticle_id;
        }

        public String getSegment_id() {
            return segment_id;
        }

        public void setSegment_id(String segment_id) {
            this.segment_id = segment_id;
        }

        public String getMoengage_id() {
            return moengage_id;
        }

        public void setMoengage_id(String moengage_id) {
            this.moengage_id = moengage_id;
        }

        String facebook_id;
        String google_id;
        String android_id;
        String ios_id;
        String clevertap_id;
        String mparticle_id;
        String segment_id;
        String moengage_id;
    }
}


