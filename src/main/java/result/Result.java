package result;

import model.Profile;

public class Result {
    private Profile profile;

    public Result(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
