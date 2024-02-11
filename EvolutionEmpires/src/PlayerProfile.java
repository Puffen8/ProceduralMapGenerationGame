public class PlayerProfile {
    private String username;
    private float winRate;
    private int wins;
    private int losses;
    private int gamesPlayed;


    public PlayerProfile(String username) {
        this.username = username;
        this.gamesPlayed = 0;
    }
    public void updateProfileStats(/*GameStatistics stats*/) {
        // TODO: Update all the fields of the PlayerProfile
    }

    public void setWinRate() {
        winRate = (float)(wins / (wins + losses));
    }

}
