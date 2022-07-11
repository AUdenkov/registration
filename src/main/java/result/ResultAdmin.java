package result;

import model.Profile;
import sorces.Manager;

public class ResultAdmin extends Result {
    public ResultAdmin(Profile profile) {
        super(profile);
        goAdmin();
    }

    public void goAdmin() {
        System.out.println("Добрый день " + getProfile().getNick());
        if (!Manager.menuAdminResult()) {
            setProfile(null);
            Manager.menuOneResult();
        } else {
            goAdmin();
        }
    }
}
