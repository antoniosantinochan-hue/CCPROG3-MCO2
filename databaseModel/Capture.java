package databaseModel;
public class Capture {
    private final int captureID;
    private Character capturedPirate;
    private Character captor;

    public Capture(Character pCapturedPirate, Character pCaptor, int targetStatus,
            int pID){
        this.captor = pCaptor;
        this.capturedPirate = pCapturedPirate;
        this.captureID = pID;

        processTargetStatus(capturedPirate, targetStatus);
        routeFinancialRewards(pCapturedPirate, pCaptor);
    }

    public void processTargetStatus(Character capturedPirate, int status){
        if (status == 1){
            capturedPirate.setStatus("Captured");
            ((Pirate) capturedPirate).getPirateCrew().countBounty();
        }

        else if (status == 2){
            capturedPirate.setStatus("Dead");
            ((Pirate) capturedPirate).getPirateCrew().countBounty();
        }
    }

    public void routeFinancialRewards(Character capturedPirate, Character captor){
        captor.setWallet(captor.getWallet() + ((Pirate) capturedPirate).getBounty());
        ((Pirate) capturedPirate).assignBounty(0);
    }

    public Character getCapturedPirate(){
        return this.capturedPirate;
    }

    public Character getCaptor(){
        return this.captor;
    }
}

