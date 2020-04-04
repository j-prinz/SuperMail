package model;

public class MailboxServicedByModel {

    private int POID;
    private int MBID;

    public MailboxServicedByModel(int MBID, int POID){
        setPOID(POID);
        setWorkArea(MBID);
    }

    public int getPOID() {
        return POID;
    }

    public void setPOID(int customer_ID) {
        this.POID = POID;
    }

    public int getMBID() {
        return MBID;
    }

    public void setWorkArea(int MBID) {
        this.MBID = MBID;
    }
}
