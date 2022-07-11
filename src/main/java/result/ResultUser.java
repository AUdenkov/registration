package result;

import model.Profile;
import sorces.Manager;

public class ResultUser extends Result {
    public ResultUser(Profile profile) {
        super(profile);
        goUser();
    }

    public void goUser() {
        System.out.println("Добрый день " + getProfile().getNick());
        if (!Manager.menuUserResult()) {
            setProfile(null);
            Manager.menuOneResult();
        } else {
            goUser();
        }
    }
}
