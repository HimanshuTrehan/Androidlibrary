package com.himanshu.customergludemolibrary.Modal;

public class RegisterObject {

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setWriteKey(String writeKey) {
        this.writeKey = writeKey;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public void setCustomAttributes(String customAttributes) {
        this.customAttributes = customAttributes;
    }

    public void setProfile(ProfileObject profile) {
        this.profile = profile;
    }

    public void setIdentities(IdentitiesObject identities) {
        this.identities = identities;
    }

    String userId;
    String writeKey;
    String sessionId;
    String userName;
    String email;
    String phone;
    String deviceId;
    String deviceType;
    String deviceName;
    String firebaseToken;
    String cookieId;
    String appVersion;
    String referredBy;
    String customAttributes;
    ProfileObject profile;
    IdentitiesObject identities;

    public static class ProfileObject
    {
        String age;
        String city;

        public void setAge(String age) {
            this.age = age;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        String country;
        String timezone;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        String firstName;
        String LastName;
    }

    public static class IdentitiesObject
    {
        public void setFacebook_id(String facebook_id) {
            this.facebook_id = facebook_id;
        }

        public void setGoogle_id(String google_id) {
            this.google_id = google_id;
        }

        public void setAndroid_id(String android_id) {
            this.android_id = android_id;
        }

        public void setIos_id(String ios_id) {
            this.ios_id = ios_id;
        }

        public void setClevertap_id(String clevertap_id) {
            this.clevertap_id = clevertap_id;
        }

        public void setMparticle_d(String mparticle_d) {
            this.mparticle_d = mparticle_d;
        }

        public void setSegment_id(String segment_id) {
            this.segment_id = segment_id;
        }

        public void setMoengage_id(String moengage_id) {
            this.moengage_id = moengage_id;
        }

        String facebook_id;
        String google_id;
        String android_id;
        String ios_id;
        String clevertap_id;
        String mparticle_d;
        String segment_id;
        String moengage_id;
    }

}
